package com.example.demo.model;

public record Address(String number,
                      String street,
                      String city,
                      String providence,
                      String postalCode,
                      String country) {
}
