package com.charter.reward.exceptions;

final public class RewardException {

    private RewardException() {
        throw new IllegalStateException("Not for object creation");
    }

    public static void checkArgument(boolean expression, RuntimeException ex) {
        if (!expression) {
            throw ex;
        }
    }
}
