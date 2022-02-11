package org.javacream.training.delivery.web;

import org.javacream.training.delivery.api.Delivery;
import org.javacream.training.delivery.api.DeliveryService;
import org.javacream.training.delivery.api.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryWebService {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping(path="api/delivery", consumes = MediaType.APPLICATION_JSON_VALUE) public Long newDelivery(@RequestBody CreateDelivery createDelivery){
        return deliveryService.create(createDelivery.getCustomerAddress(), createDelivery.getShippingAddress(), createDelivery.getItems());
    }

    @PutMapping(path="api/delivery/{id}/{status}") public void updateStatus(@PathVariable("id") Long id, @PathVariable("status") DeliveryStatus status){
        deliveryService.update(id, status);
    }

    @GetMapping (path="api/delivery/{id}", produces = MediaType.APPLICATION_JSON_VALUE) public Delivery findById(@PathVariable("id") Long id){
        return deliveryService.findById(id);
    }
}
