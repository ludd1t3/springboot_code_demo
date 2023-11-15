package com.example.demo.services;

import com.example.demo.model.Invoice;

import java.util.List;
import java.util.stream.LongStream;

public class InvoiceService {
    public List<Invoice> getInvoices(long pos, long count) {
        return LongStream.range(pos, pos + count)
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
