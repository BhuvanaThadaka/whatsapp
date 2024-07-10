package com.rajlee.creatingwhatsappapi.controller;

import com.rajlee.creatingwhatsappapi.dto.MessageBodyDTO;
import com.rajlee.creatingwhatsappapi.model.ResponseWhatsapp;
import com.rajlee.creatingwhatsappapi.service.ApiWhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class WhatsappController {

    @Autowired
    private ApiWhatsappService apiWhatsappService;

    @PostMapping("/send")
    ResponseWhatsapp send(@RequestBody MessageBodyDTO payload){
        return apiWhatsappService.sendMessage(payload);
    }
}