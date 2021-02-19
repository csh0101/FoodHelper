package com.csh.food.bucket.base.controller;

import com.csh.food.bucket.base.domain.response.PicAnalysisResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PicAnalysisController {

    @RequestMapping("/picAnalysis")
    public PicAnalysisResponse picAnalysis(@RequestParam(value = "file")MultipartFile file){
        return  null;
    }
}
