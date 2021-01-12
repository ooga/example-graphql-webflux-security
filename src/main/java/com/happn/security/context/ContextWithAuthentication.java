package com.happn.security.context;

import org.springframework.security.core.Authentication;

public interface ContextWithAuthentication {

    Authentication getAuthentication();
}
