package com.wiet.math.core.dividers.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DividersProductService {

    @RequestMapping("/{integer}")
    public Long getDividers(@PathVariable("integer") int integer) {
        return 0L;
    }

}
