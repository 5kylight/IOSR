package com.wiet.math.core.dividers.service;

import com.wiet.math.core.dividers.communication.DividersServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;

@RestController
public class DividersProductService {

    @Autowired
    private DividersServiceClient dividersServiceClient;

    @RequestMapping("api/{integer}/string")
    public String getDividersAsStringInfo(@PathVariable("integer") int integer) {
        return buildResult(integer, this::buildStringInfo, "No dividers retrieved :(");
    }

    private String buildStringInfo(List<Integer> factors) {
        String leftSide = getLeftSideString(factors);
        String rightSide = String.valueOf(getProductAsLong(factors));

        return String.format("%s = %s", leftSide, rightSide);
    }

    private String getLeftSideString(List<Integer> dividers) {
        StringJoiner leftSideStringJoiner = new StringJoiner(" * ");
        dividers.stream().map(String::valueOf).forEach(leftSideStringJoiner::add);
        return leftSideStringJoiner.toString();
    }

    private long getProductAsLong(List<Integer> dividers) {
        return dividers.stream().mapToLong(el -> (long) el).reduce(1, (a, b) -> a * b);
    }

    @RequestMapping("api/{integer}")
    public long getDividers(@PathVariable("integer") int integer) {
        return buildResult(integer, this::getProductAsLong, 0L);
    }

    private <T> T buildResult(Integer integer, Function<List<Integer>, T> onSuccess, T defaultVal) {
        List<Integer> dividers = dividersServiceClient.getDividers(integer);
        return Objects.nonNull(dividers) && !dividers.isEmpty() ? onSuccess.apply(dividers) : defaultVal;
    }
}
