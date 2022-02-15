package org.javacream.training.delivery.impl;

import org.javacream.training.delivery.api.*;
import org.javacream.training.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;
    @Override
    public Long create(Address shippingAddress, Address customerAddress, List<String> items) {
        List<Item> itemList = items.stream().map(s -> new Item(null, s)).collect(Collectors.toList());
        Delivery delivery = new Delivery(null, customerAddress, shippingAddress, items, itemList, DeliveryStatus.START);
        deliveryRepository.save(delivery);
        return delivery.getDeliveryId();
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).get();
    }

    @Override
    public void update(Long id, DeliveryStatus status) {
        deliveryRepository.updateStatus(id, status);
    }
}
