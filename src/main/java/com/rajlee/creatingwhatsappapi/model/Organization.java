package com.rajlee.creatingwhatsappapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orgId;
    private String orgName;
    private String place;


}
