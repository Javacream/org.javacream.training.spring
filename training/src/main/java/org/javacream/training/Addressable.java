package org.javacream.training;

import java.util.Optional;

@FunctionalInterface public interface Addressable {

    Optional<Address> getAddress();
}

