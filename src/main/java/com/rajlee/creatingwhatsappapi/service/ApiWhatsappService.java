package com.rajlee.creatingwhatsappapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajlee.creatingwhatsappapi.dto.MessageBodyDTO;
import com.rajlee.creatingwhatsappapi.model.RequestMessage;
import com.rajlee.creatingwhatsappapi.model.RequestMessageText;
import com.rajlee.creatingwhatsappapi.model.ResponseWhatsapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

@Service
public class ApiWhatsappService {

    private final RestClient restClient;

    public ApiWhatsappService(){
        restClient = RestClient.builder()
                .baseUrl("https://graph.facebook.com/v19.0/302797252927415/messages")
                .defaultHeader("Authorization","Bearer EAAQI7isKUIcBOwGeUZCoiNssznuSdWtYnzevBpSR8ZCLlmqgFP9GNaixos1bKurOZAB8FVAIUgF6C3EhvpeYOKviXZAZCy58ctOaOV4IT4DfvrNg5VDATLRhY5y7z1LkrTFpieisHfZC3Nnn3LJWT6QSx1NyfHaMGJarjQlOpcJYYuZBDnZBieZANT7rfbf7l6uNvGpRYCJ4iOpuUdOKved9nW3ylvj2dkaSbZCAeec4CCQqkZD")
                .build();
    }

    public ResponseWhatsapp sendMessage(MessageBodyDTO payload){
        RequestMessage request=new RequestMessage("whatsapp", payload.number(), new RequestMessageText(payload.message()));
        try{
            String response = restClient.post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(String.class);

            ObjectMapper obj = new ObjectMapper();
            ResponseWhatsapp responseWhatsapp = obj.readValue(response,ResponseWhatsapp.class);
            return responseWhatsapp;
        }catch(RestClientException | JsonProcessingException e){
            throw new RestClientResponseException("Error in sending message",400,"Error in sending message",null,null,null);
        }
    }
}
