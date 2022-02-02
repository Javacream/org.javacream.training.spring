package org.javacream.books.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceWebRepository {
    @Autowired private InvoiceRepository invoiceRepository;

    @GetMapping(path="api/invoices", produces = MediaType.APPLICATION_JSON_VALUE) public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }

    @PostMapping(path="api/invoices", consumes = MediaType.APPLICATION_JSON_VALUE) public void newInvoice(@RequestBody Invoice i){
        invoiceRepository.save(i);
    }

}
