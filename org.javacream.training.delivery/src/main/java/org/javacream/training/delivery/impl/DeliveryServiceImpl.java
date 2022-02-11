package org.javacream.training.delivery.impl;

import org.javacream.training.delivery.api.Address;
import org.javacream.training.delivery.api.Delivery;
import org.javacream.training.delivery.api.DeliveryService;
import org.javacream.training.delivery.api.DeliveryStatus;
import org.javacream.training.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;
    @Override
    public Long create(Address shippingAddress, Address customerAddress, List<String> items) {
        Delivery delivery = new Delivery(null, customerAddress, shippingAddress, items, DeliveryStatus.START);
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
