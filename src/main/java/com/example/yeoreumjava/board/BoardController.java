package com.example.yeoreumjava.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @GetMapping("/get")
    public String Hello() {
        return "Hello";
    }
}
