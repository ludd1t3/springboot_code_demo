package com.example.demo.services;

import com.example.demo.model.Invoice;

import java.util.List;
import java.util.stream.LongStream;

public class InvoiceService {
    public List<Invoice> getInvoices(long count) {
        return LongStream.range(0, count)
                .mapToObj(i -> new Invoice(
                        "invoice-" + i,
                        "ab-7793-5"
                ))
                .toList();
    }

    public Invoice getInvoice(String invoiceId) {
        return new Invoice(invoiceId, "ab-7793-5");
    }
}
