package com.wiet.math.core.dividers.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class DividersService {


    @RequestMapping("/{integer}")
    public List<Integer> getDividers(@PathVariable("integer") int integer) {
        return IntStream.rangeClosed(1, Math.abs(integer))
                .filter(i -> integer % i == 0)
                .boxed()
                .collect(Collectors.toList());
    }

}
