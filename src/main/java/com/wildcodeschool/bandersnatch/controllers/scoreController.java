package com.wildcodeschool.bandersnatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class scoreController {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/bandersnatch_db?serverTimezone=GMT";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "@AdminEcho1234";
}
