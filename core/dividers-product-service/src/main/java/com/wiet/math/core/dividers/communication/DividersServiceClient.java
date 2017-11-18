package com.wiet.math.core.dividers.communication;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "dividers-service")
public interface DividersServiceClient {

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    List<Integer> getDividers(@PathVariable("number") int number);
}
