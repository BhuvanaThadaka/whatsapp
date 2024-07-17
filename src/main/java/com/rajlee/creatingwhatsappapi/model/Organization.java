package com.rajlee.creatingwhatsappapi.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data

public class Organization {

    @Id
    private int orgId;
    private String orgName;
    private String place;


}
