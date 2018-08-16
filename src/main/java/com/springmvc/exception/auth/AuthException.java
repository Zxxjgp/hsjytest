package com.springmvc.exception.auth;

import com.springmvc.constant.RestCodeConstants;
import com.springmvc.exception.BaseException;

public class AuthException extends BaseException {
    public AuthException(String message) {
        super(message, RestCodeConstants.EX_TOKEN_ERROR_CODE);
    }
}
