package com.qu.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

public class AdminInvitationDTO {
    public String id;
    public String email;
    public LocalDateTime creationTime;
    public Set<String> roles;
}
