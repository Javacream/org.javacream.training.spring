package org.javacream.training;

public class TopLevelAddressable implements Addressable{
    @Override
    public Address getAddress() {
        return new Address("irgend", "wo");
    }

    public class InnerAddressable implements Addressable{
        @Override
        public Address getAddress() {
            return new Address("irgend", "wo");
        }
    }

    public void methodWithClassDefinition(){
        class MethodAddressable implements Addressable{
            @Override
            public Address getAddress() {
                return new Address("irgend", "wo");
            }
        }
        Addressable addressable = new MethodAddressable();
        addressable.getAddress();
    }

    public void methodWithAnonymousImplementation(){
        Addressable addressable = new Addressable(){
            @Override
            public Address getAddress() {
                return new Address("irgend", "wo");
            }
        };
        addressable.getAddress();
    }

    public void methodWithLambda(){
        Addressable addressable = () -> {
                return new Address("irgend", "wo");
            };
        addressable.getAddress();
    }

}


