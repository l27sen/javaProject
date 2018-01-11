package com.sen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @GetMapping("/fun")
    public String fun() {
        return "tableToJSON";
    }


    @GetMapping("/table")
    public String table() {
        return "tracktable";
    }

    @GetMapping("/load")
    public String load() {
        return "loadtable";
    }
}
