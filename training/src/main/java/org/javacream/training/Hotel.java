package org.javacream.training;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hotel implements Addressable{
    private String name;

    public Set<Person> getCheckedIn() {
        return checkedIn;
    }

    private Set<Person> checkedIn = new HashSet<>();
    public Boolean checkIn(Person guest){
        if (checkedIn.contains(guest)){
            return false;
        }else{
            if (checkedIn.size() == roomCount){
                return false;
            }else{
                checkedIn.add(guest);
                return true;
            }
        }

    }

    public boolean checkOut(Person guest){
        if (!checkedIn.contains(guest)){
            return false;
        }else{
            checkedIn.remove(guest);
            return true;
        }
    }
    public String getName() {
        return name;
    }



    public Integer getRoomCount() {
        return roomCount;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", roomCount=" + roomCount +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) && Objects.equals(roomCount, hotel.roomCount) && Objects.equals(address, hotel.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roomCount, address);
    }

    public Hotel(String name, Integer roomCount, Address address) {
        this.name = name;
        this.roomCount = roomCount;
        this.address = address;
    }

    private Integer roomCount;
    private Address address;
}
