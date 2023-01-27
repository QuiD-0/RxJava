package com.quid.feignClient.controller;

import com.quid.feignClient.model.BaseRes;
import com.quid.feignClient.model.ProductRes;
import com.quid.feignClient.service.FeignService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign")
public class FeignController {

    private final FeignService feignService;

    @GetMapping("/get")
    public BaseRes get() {
        return feignService.callGet();
    }

    @GetMapping("/dummy/{id}")
    public ProductRes dummy(@PathVariable String id) {
        return feignService.callDummyJson(id);
    }

    @GetMapping("/error")
    public String error() {
        return feignService.callError();
    }

    @GetMapping("/async")
    public String async() {
        return feignService.callAsync();
    }

    @GetMapping("/returnAsync")
    public ProductRes returnAsync() {
        return feignService.returnAsync();
    }

    @GetMapping("/returnAsyncList")
    public List<ProductRes> returnAsyncList() {
        return feignService.returnAsyncList();
    }
}
