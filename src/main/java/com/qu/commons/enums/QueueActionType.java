package com.qu.commons.enums;

import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Map.entry;

public enum QueueActionType {
    HOLD, START, END, CREATE;

    private static final Map<QueueActionType, Set<QueueActionType>> acceptedNextStatus =
            Map.ofEntries(
              entry(HOLD, Set.of(START, END)),
              entry(CREATE, Set.of(START, END, HOLD)),
              entry(START, Set.of(HOLD, END)),
              entry(END, emptySet())
            );



    public boolean canHaveNextStatusOf(QueueActionType nextStatus){
        return acceptedNextStatus.get(this).contains(nextStatus);
    }
}
