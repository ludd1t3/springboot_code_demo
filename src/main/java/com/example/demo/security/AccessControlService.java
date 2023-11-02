package com.example.demo.security;

import org.springframework.stereotype.Service;

public class AccessControlService {
    public boolean hasAccess(String entityType, String entityId, String userId, String action) {
        return true;
    }
}
