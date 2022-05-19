package com.qu.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class OrganizationCreateDTO {
    public String email;
    public String password;
    public String username;
    public String name;
    public String subscriptionToken;
}
