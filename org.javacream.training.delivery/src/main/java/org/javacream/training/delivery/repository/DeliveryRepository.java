package org.javacream.training.delivery.repository;

import org.javacream.training.delivery.api.Delivery;
import org.javacream.training.delivery.api.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Transactional
    @Modifying
    @Query("update Delivery as delivery set delivery.deliveryStatus = :status where delivery.deliveryId = :id")
    void updateStatus(@Param("id") Long id, @Param("status") DeliveryStatus newStatus);
}
