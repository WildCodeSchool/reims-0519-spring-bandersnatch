package com.wildcodeschool.bandersnatch.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class BandersnatchController {

@RequestMapping(value="/hello/{name}")
@ResponseBody
public String hello(@PathVariable String name) {
    return "Hello " + name;
}
}