package com.wiet.math.core.dividers.service;

import com.wiet.math.core.dividers.communication.DividersServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;

@RestController
public class DividersProductService {

    @Autowired
    private DividersServiceClient dividersServiceClient;

    @RequestMapping(value = "api/{integer}/string", method = RequestMethod.GET)
    public ResponseEntity<String> getDividersAsStringInfo(@PathVariable("integer") int integer) {
        if (Math.abs(integer) < 21) {
            String result = buildResult(integer, this::buildStringInfo, "No dividers retrieved :(");
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

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

    @RequestMapping(value = "api/{integer}", method = RequestMethod.GET)
    public ResponseEntity<Long> getDividers(@PathVariable("integer") int integer) {
        if (Math.abs(integer) < 21) {
            long result = buildResult(integer, this::getProductAsLong, 0L);
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    private <T> T buildResult(Integer integer, Function<List<Integer>, T> onSuccess, T defaultVal) {
        List<Integer> dividers = dividersServiceClient.getDividers(integer);
        return Objects.nonNull(dividers) && !dividers.isEmpty() ? onSuccess.apply(dividers) : defaultVal;
    }
}
