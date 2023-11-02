package com.example.demo.security;

public class AccessControlService {
    public boolean hasAccess(String entityType, String entityId, String userId, String action) {
        return true;
    }
}
