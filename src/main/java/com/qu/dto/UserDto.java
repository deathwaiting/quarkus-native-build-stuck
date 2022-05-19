package com.qu.dto;

import java.util.List;
import java.util.Map;

public class UserDto {
    public String id;
    public String email;
    public String phone;
    public String name;
    public Long organizationId;
    public List<String> roles;
    public Map<String,String> extraDetails;
}
