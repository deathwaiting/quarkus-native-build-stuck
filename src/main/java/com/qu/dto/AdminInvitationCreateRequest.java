package com.qu.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

public class AdminInvitationCreateRequest {
    public String email;
    public List<String> roles;
}
