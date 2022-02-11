package org.javacream.training.delivery.api;

import java.util.List;

public interface DeliveryService {
    Long create(Address shippingAddress, Address customerAddress, List<String> items);
    Delivery findById(Long id);
    void update(Long id, DeliveryStatus status);
}
