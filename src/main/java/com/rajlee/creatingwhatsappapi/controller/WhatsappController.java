package com.rajlee.creatingwhatsappapi.controller;

//import com.rajlee.creatingwhatsappapi.dto.MediaBodyDTO;
import com.rajlee.creatingwhatsappapi.dto.MessageBodyDTO;
import com.rajlee.creatingwhatsappapi.model.Organization;
import com.rajlee.creatingwhatsappapi.model.RequestMedia;
import com.rajlee.creatingwhatsappapi.model.ResponseWhatsapp;
import com.rajlee.creatingwhatsappapi.model.User;
import com.rajlee.creatingwhatsappapi.service.ApiWhatsappService;
//import com.rajlee.creatingwhatsappapi.service.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class WhatsappController {

    @Autowired
    private ApiWhatsappService apiWhatsappService;

//    @Autowired
//    private WhatsAppService whatsAppService;


    @PostMapping("/send")
    ResponseWhatsapp send(@RequestBody MessageBodyDTO payload){
        return apiWhatsappService.sendMessage(payload);
    }







//    @PostMapping("/sendMedia")
//    public ResponseEntity<String> sendMedia(@RequestBody RequestMedia mediaRequest) {
//        try {
//            File mediaFile = new File(mediaRequest.getFilePath());
//            whatsAppService.sendMediaMessage(mediaRequest.getPhoneNumber(), mediaFile);
//            return ResponseEntity.ok("Media sent successfully!");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending media: " + e.getMessage());
//        }
//    }
}