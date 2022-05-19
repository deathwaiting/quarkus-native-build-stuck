package com.qu.dto;

public class AdminInvitationCreateResponse {
    public String invitationToken;

    public AdminInvitationCreateResponse(String token){
        invitationToken = token;
    }
}
