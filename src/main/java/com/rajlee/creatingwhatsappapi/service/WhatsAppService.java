//package com.rajlee.creatingwhatsappapi.service;
//
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Service;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.http.HttpClient;
//import java.net.http.HttpResponse;
//
//@Service
//public class WhatsAppService {
//
//    private static final String WHATSAPP_API_URL = "https://api.whatsapp.com/send?phone=";
//    private static final String WHATSAPP_MEDIA_ENDPOINT = "/v1/messages";
//
//    public void sendMediaMessage(String phoneNumber, File mediaFile) throws IOException {
//        String url = WHATSAPP_API_URL + phoneNumber + WHATSAPP_MEDIA_ENDPOINT;
//        HttpClient httpClient = HttpClients.createDefault();
//
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
//
//        FileInputStream fileInputStream = new FileInputStream(mediaFile);
//        InputStreamEntity entity = new InputStreamEntity(fileInputStream, ContentType.APPLICATION_OCTET_STREAM);
//        httpPost.setEntity(entity);
//
//        HttpResponse response = httpClient.execute(httpPost);
//        // Handle response as needed
//        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
//    }
//}
