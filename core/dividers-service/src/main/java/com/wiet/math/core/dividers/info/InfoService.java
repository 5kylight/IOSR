package com.wiet.math.core.dividers.info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoService {


    @RequestMapping("/info")
    public String getInfo() {
        return "DividersService instance";
    }

}
