package com.csh.food.gateway.base.filter;

import com.alibaba.fastjson.JSON;
import com.csh.food.jwt.base.util.JWTUtil;
import com.csh.food.res.base.exception.TokenAuthenticationException;
import com.csh.food.res.base.response.ResponseCodeEnum;
import com.csh.food.res.base.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;


@Slf4j
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Value("${token.auth.secretKey:123456}")
    private String secretKey;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        String uri = serverHttpRequest.getURI().getPath();
        if(uri.contains("/common/api/user/login") || uri.contains("/common/api/user/register")){
            return chain.filter(exchange);
        }
        String token = serverHttpRequest.getHeaders().getFirst("token");
        if(StringUtils.isBlank(token)){
            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return getVoidMono(serverHttpResponse, ResponseCodeEnum.TOKEN_MISSION);
        }
        try{
            JWTUtil.verifyToken(token,secretKey);
        }catch (TokenAuthenticationException ex){
            return getVoidMono(serverHttpResponse,ResponseCodeEnum.TOKEN_INVALID);
        }catch (Exception ex){
            return getVoidMono(serverHttpResponse,ResponseCodeEnum.UNKNOWN_ERROR);
        }
        //从token中取出userId
        String userId = JWTUtil.getUserInfo(token);
        ServerHttpRequest mutableReq = serverHttpRequest.mutate().header("userId",userId).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);
    }

    private Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse,ResponseCodeEnum responseCodeEnum){
        serverHttpResponse.getHeaders().add("Content-Type","application/json:charset=UTF-8");
        ResponseResult responseResult = ResponseResult.error(responseCodeEnum.getCode(),responseCodeEnum.getMessage());
        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(responseResult).getBytes());
        return serverHttpResponse.writeWith(Flux.just(dataBuffer));
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
