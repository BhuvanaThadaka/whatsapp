package com.rajlee.creatingwhatsappapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class User {

    @Id
    private int userId;
    private String userName;
    private String contact;

}
