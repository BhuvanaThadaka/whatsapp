package com.rajlee.creatingwhatsappapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rajlee.creatingwhatsappapi.dto.MediaBodyDTO;
import com.rajlee.creatingwhatsappapi.dto.MessageBodyDTO;
import com.rajlee.creatingwhatsappapi.model.*;
import com.rajlee.creatingwhatsappapi.repository.OrganizationRepository;
import com.rajlee.creatingwhatsappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

@Service
public class ApiWhatsappService {

    private final RestClient restClient;


    public ApiWhatsappService(){
        restClient = RestClient.builder()
                .baseUrl("https://graph.facebook.com/v19.0/302797252927415/messages")
                .defaultHeader("Authorization","Bearer EAAQI7isKUIcBO54VLAZCJq95wYOVisDKgXkjPsvw0BRqo5ZAqNGmEiyF34b47ZArqdNapCyEHpWcbMI8zhzoTbuZAf4npHL2tF2NNfBMR9cmq30hliF2ecZBgKkk8ubOQrW2Eq872VP339gXIBu7XdgqE2ZAjDWq7j9H1bAzZBvHlVMiS8QE55srGujUVKBpYHJBbjbMkV4RNommavvxb4ayYvpenKZCa6qKNZCyRfsP0GfgZD")
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









//    public ResponseWhatsapp sendMedia(MediaBodyDTO payload2){
//        RequestMedia request=new RequestMedia("whatsapp","individual", payload2.number(), "image",new RequestMediaId(payload2.id()));
//        try{
//            String response = restClient.post()
//                    .uri("")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(request)
//                    .retrieve()
//                    .body(String.class);
//
//            ObjectMapper obj = new ObjectMapper();
//            ResponseWhatsapp responseWhatsapp = obj.readValue(response,ResponseWhatsapp.class);
//            return responseWhatsapp;
//        }catch(RestClientException | JsonProcessingException e){
//            throw new RestClientResponseException("Error in sending message",400,"Error in sending message",null,null,null);
//        }
//    }


}
