package com.qu.commons.enums;

import com.qu.commons.constants.Roles;

import java.util.HashSet;
import java.util.Set;

import static com.qu.commons.constants.Roles.*;

public enum UserGroup {
    CLIENT(Roles.CLIENT, TURN_INFO_READER)
    , SERVER(QUEUE_MANAGER, TURN_INFO_READER)
    , ADMIN( getAdminRoles())
    , OWNER( getOwnerRoles());

    private final Set<String> roles ;

    UserGroup(String... roles){
        this.roles = Set.of(roles);
    }


    UserGroup(Set<String> roles){
        this.roles = roles;
    }


    private static Set<String> getAdminRoles(){
        var roles = new HashSet<>(SERVER.roles);
        roles.add(QUEUE_ADMIN);
        return roles;
    }


    private static Set<String> getOwnerRoles(){
        var roles = new HashSet<>(ADMIN.roles);
        roles.add(USER_MANAGER);
        return roles;
    }
}
