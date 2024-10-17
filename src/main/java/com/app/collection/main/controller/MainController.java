package com.app.collection.main.controller;

import com.app.collection.main.service.MainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello, World!"; // 단순한 문자열 반환
    }

    @GetMapping("/v1/main")
    public String main() {
        return mainService.main();
    }
}
