package com.csh.food.jwt.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.csh.food.res.base.exception.TokenAuthenticationException;
import com.csh.food.res.base.response.ResponseCodeEnum;

import java.util.Date;

public class JWTUtil {
    //2h
    public static final long TOKEN_EXPIRE_TIME = 7200 * 1000 ;
    private static final String ISSUER = "CHENG";

    public static String generateToken(String userName,String secretKey){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        //过期时间
        Date expireTime = new Date(new Date().getTime() + TOKEN_EXPIRE_TIME);
        String token = JWT
                .create()
                .withIssuer(ISSUER)
                .withIssuedAt(new Date())
                .withExpiresAt(expireTime)
                .withClaim("userName",userName)
                .sign(algorithm);
        return token;
    }
    public static void verifyToken(String token,String secretKey)  {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier jwtVerifier =JWT.require(algorithm).withIssuer(ISSUER).build();
            jwtVerifier.verify(token);
        }catch (JWTDecodeException jwtDecodeException){
            throw new TokenAuthenticationException(ResponseCodeEnum.TOKEN_INVALID.getCode(),ResponseCodeEnum.TOKEN_INVALID.getMessage());
        }catch (SignatureVerificationException signatureVerificationException){
            throw new TokenAuthenticationException(ResponseCodeEnum.TOKEN_SIGNATURE_INVALID.getCode(),ResponseCodeEnum.TOKEN_SIGNATURE_INVALID.getMessage());
        }catch (TokenExpiredException tokenExpiredException){
            throw new TokenAuthenticationException(ResponseCodeEnum.TOKEN_EXPIRED.getCode(), ResponseCodeEnum.TOKEN_EXPIRED.getMessage());
        }catch (Exception ex){
            throw new TokenAuthenticationException(ResponseCodeEnum.UNKNOWN_ERROR.getCode(), ResponseCodeEnum.UNKNOWN_ERROR.getMessage());
        }
    }
    public static String getUserInfo(String token){
        //返回用户信息
        return JWT.decode(token).getClaim("userName").asString();
    }
}
