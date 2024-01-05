package com.sin.web.test;

import com.sin.domain.Test;
import com.sin.service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sin
 */
@Tag(name = "Test")
@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @Operation(summary = "测试", description = "没有")
    @GetMapping
    public String get() {
        return "ok";
    }

    @Operation(summary = "获取测试1")
    @Parameters({
            @Parameter(name = "id", description = "测试id", required = true, in = ParameterIn.QUERY)
    })
    @GetMapping("/getAll")
    public Test getTest(String id) {
        return testService.getById(1);
    }

    @Operation(summary = "获取测试2")
    @PostMapping("/getByTest")
    public Test getByTest(@RequestBody Test test) {
        return test;
    }
}
