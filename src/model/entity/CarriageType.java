package model.entity;

public enum CarriageType {
        DeLuxe("DeLuxe", 18, 36),
        Compartment("Compartment", 36, 36),
        Seating1Class("Seating1Class",56, 50),
        Seating2Class("Seating2Class",56, 42),
        Berth("Berth", 54, 27);

    private String carriageName;
    private int passengerCapacity;
    private int luggageCapacity;

    CarriageType(String carriageName, int passengerCapacity, int luggageCapacity) {
        this.carriageName = carriageName;
        this.passengerCapacity = passengerCapacity;
        this.luggageCapacity = luggageCapacity;
    }

    public String getCarriageName() {
        return carriageName;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    @Override
    public String toString() {
        return "CarriageType{" +
                ", carriageName='" + carriageName + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", luggageCapacity=" + luggageCapacity +
                '}';
    }
}
