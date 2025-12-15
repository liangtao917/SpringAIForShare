package com.liangfang.springai.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.web.bind.annotation.GetMapping;

public class MyController {

    @Resource
    private DeepSeekChatModel deepSeekChatModel;


}


