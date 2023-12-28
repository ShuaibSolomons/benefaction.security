package com.benefaction.security.util;

public class ResponseException {

    public static class UserAlreadyCreated extends BaseRuntimeException {
        public UserAlreadyCreated(String errorMessage) {
            super(errorMessage);
        }
    }
}
