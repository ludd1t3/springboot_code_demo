package com.example.demo.services;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.LongStream;

import static java.math.BigDecimal.valueOf;

public class InvoiceService {
    public List<Invoice> getInvoices(long count) {
        final List<Address> shippingAddresses = List.of(
                new Address("8197", "Baker Street", "Femont", "OH", "43420", "USA"),
                new Address("7", "Blackburn", "Springfield Gardens", "NY", "11413", "USA"),
                new Address("325", "Bear Hill Drive", "Council Bluffs", "A", "51501", "USA"),
                new Address("8593", "Summit Lane", "Fort Lauderdale", "FL", "33308", "USA"),
                new Address("11", "Beechwood Road", "Wyandotte", "MI", "48192", "USA")
        );

        final List<Product> products =  List.of(
                new Product("bd-3693-ag9", "Red widget", "We don't know what this does.", valueOf(101.57), 10, valueOf(1015.70)),
                new Product("ka-4439-ul8", "Kale bowl", "Not just any bowl, but a kale bowl.", valueOf(45.99), 8, valueOf(367.92)),
                new Product("rm-293T-zh3", "Green door nob", "For homes trying to capture 1970s USA.", valueOf(13.95), 19, valueOf(265.05)),
                new Product("rf-g11e-tm6", "Warped plate", "We have too many of these and they don't sell.", valueOf(300.00), 17, valueOf(5100.00)),
                new Product("um-3929-cf9", "False nails", "They don't hammer very well.", valueOf(0.15), 5000, valueOf(750.00)),
                new Product("lt-mm83-v3n", "Blue milk", "Obligatory Star Wars reference.", valueOf(59.99), 10, valueOf(599.90)),
                new Product("xo-88CD-8rh", "Half chair", "Someone watched Willy Wonka and the Chocolate Factory too many times.", valueOf(8.00), 1, valueOf(8.00)),
                new Product("op-4mn9-lyx", "Liminal space", "Do not enter.", valueOf(100.00), 2, valueOf(200.00))
        );
        final BigDecimal subtotal = products.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        final BigDecimal tax = subtotal.multiply(valueOf(0.07)).setScale(2, RoundingMode.HALF_EVEN);

        return LongStream.range(0, count)
                .mapToObj(i -> new Invoice(
                        String.valueOf(i),
                        new Customer("ab-7793-5", "ACME Inc.", "kipper.jones@greentea.invalid"),
                        shippingAddresses.get((int) (i % shippingAddresses.size())),
                        new Address("2 E", "Morris Court", "Morgantown", "WV", "26508", "USA"),
                        products,
                        subtotal,
                        subtotal.multiply(valueOf(0.07)).setScale(2, RoundingMode.HALF_EVEN),
                        subtotal.add(tax)
                ))
                .toList();
    }
}
