package com.qu.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

import javax.enterprise.inject.Produces;

import static java.util.Arrays.asList;


public class KeycloakAdminClientConfig {

    @ConfigProperty(name = "quarkus.oidc.auth-server-url")
    String SERVER_URL;

    String REALM = "qu";
    String USERNAME = "admin@admin.com";
    String PASSWORD = "admin";

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String CLIENT_ID;

    @ConfigProperty(name = "quarkus.oidc.credentials.secret")
    String CLIENT_SECRET;

    @Produces
    public Keycloak createKeycloakClient(){
        var list = asList(SERVER_URL.split("/"));
//        var list = new ArrayList<String>();
        var list2 = list.subList(0,list.size() -2);
        var serverUrl = String.join("/", list2);
        return KeycloakBuilder
                .builder()
                .serverUrl(serverUrl)
                .realm(REALM)
                .username(USERNAME)
                .password(PASSWORD)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .build();
    }
}
