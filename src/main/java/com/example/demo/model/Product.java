package com.example.demo.model;

import java.math.BigDecimal;

public record Product(String sku,
                      String productName,
                      String productDescription,
                      BigDecimal unitPrice,
                      int quantity,
                      BigDecimal price) {
}
