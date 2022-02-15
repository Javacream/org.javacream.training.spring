package org.javacream.training.delivery.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride( name = "street", column = @Column(name = "customer_street")),
    })
    private Address customerAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride( name = "street", column = @Column(name = "shipping_street")),
    })
    private Address shippingAddress;
    @ElementCollection private List<String> items;

    @ManyToMany(cascade = CascadeType.ALL) private List<Item> itemsAsRelation;



    private DeliveryStatus deliveryStatus;
}
