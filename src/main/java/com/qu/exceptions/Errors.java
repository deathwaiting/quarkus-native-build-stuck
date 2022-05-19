package com.qu.exceptions;

public enum Errors {
    E$GEN$00001("Missing required data!"),
    E$GEN$00002("No Organization found for the user!"),
    E$GEN$00003("Failed to write object as json string! object[%s]"),
    E$GEN$00004("Failed to parse json string! string[%s]"),
    E$GEN$00005("Failed to fetch current user!"),


    E$USR$00001("Invalid roles [%s]!"),
    E$USR$00002("Passwords didn't match!"),
    E$USR$00003("Invalid invitation token!"),
    E$USR$00004("Failed to parse JWT token!"),
    E$USR$00005("Failed to perform operation on keycloak server!"),

    E$QUE$00001("Failed to create Queue type! cause: %s"),
    E$QUE$00002("Queue type doesn't exists!"),
    E$QUE$00003("Queue with Id[%d] doesn't exist!"),
    E$QUE$00004("Cannot change queue state from [%s] to [%s]!"),
    E$QUE$00005("Failed to create queue turn!"),
    E$QUE$00006("Cannot request Turns for that Queue! Queue is not accepting requests!"),
    E$QUE$00007("Cannot request Turns for that Queue! Queue is Full!"),
    E$QUE$00008("Cannot find turn request!"),
    E$QUE$00009("Invalid turn request! Already handled!"),
    E$QUE$00010("Failed to pick the queue turn!"),
    E$QUE$00011("Queue has no more turns!"),
    E$QUE$00012("Invalid Queue status!"),
    E$QUE$00013("Failed to cancel Turn!"),
    E$QUE$00014("Queue cannot start or end in the past!"),
    E$QUE$00015("Queue Turn with Id[%d] doesn't exist!"),
    E$QUE$00016("Turn must be in service first in order to end it!"),
    E$QUE$00017("Cannot Cancel turn request! already handled by admins!"),
    E$QUE$00018("Queue Turn with UUID[%s] doesn't exist!"),
    E$QUE$00019("Failed to calculate queue stats!"),
    E$QUE$00020("Queue Turn with UID[%s] doesn't exist!"),
    ;

    private String msg;

    Errors(String msg){
        this.msg = msg;
    }

    String getMessage(){
        return msg;
    }
}
