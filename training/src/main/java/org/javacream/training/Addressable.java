package org.javacream.training;

@FunctionalInterface public interface Addressable {
/* das wäre eigentlich ganz schön gewesen...
    private Address address;
    public Address getAddress() {
        return address;
    }
*/
    Address getAddress();
}

