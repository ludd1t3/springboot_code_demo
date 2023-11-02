package com.example.demo.security;

import java.util.List;

public class AuthenticationContext {
    public String userId() {
        return "fa7d5b9e-8e5a-4b0e-9b0a-8b1f1b5c8e2e";
    }

    public List<String> grants() {
        return List.of("read:invoices", "write:invoices");
    }
}
