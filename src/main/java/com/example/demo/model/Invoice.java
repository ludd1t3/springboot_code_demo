package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;

public record Invoice(String invoiceId,
                      Customer customer,
                      Address shippingAddress,
                      Address billingAddress,
                      List<Product> products,
                      BigDecimal subtotal,
                      BigDecimal tax,
                      BigDecimal total) {
}
