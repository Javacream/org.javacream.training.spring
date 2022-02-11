package org.javacream.training.delivery.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javacream.training.delivery.api.Address;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDelivery {
    private Address shippingAddress;
    private Address customerAddress;
    private List<String> items;

}
