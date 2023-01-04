package com.quid.feignClient.controller;

import com.quid.feignClient.model.BaseRes;
import com.quid.feignClient.model.ProductRes;
import com.quid.feignClient.service.FeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BaseRes> get() {
        return feignService.callGet();
    }

    @GetMapping("/dummy/{id}")
    public ResponseEntity<ProductRes> dummy(@PathVariable String id) {
        return feignService.callDummyJson(id);
    }
}
