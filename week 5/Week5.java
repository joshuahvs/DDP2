public class Week5 {
    public static void main(String[] args) {
        Car aCar = new Car("Honda", "v", "1 u", "merah", 4, 100);
        Car bCar = new Car("Honda", "v", "11 u", "merah", 4, 100);
        Car cCar = new Car("Honda", "v", "111 u", "merah", 4, 100);
        Car dCar = new Car("Honda", "v", "1111 u", "kuning", 4, 100);
        ParkingLot myParkingLot = new ParkingLot(100);
        System.out.println(myParkingLot);
        myParkingLot.numParkACar(aCar);
        myParkingLot.numParkACar(bCar);
        myParkingLot.numParkACar(cCar);
        myParkingLot.numParkACar(dCar);
        System.out.println(myParkingLot);
    }
}

class Car {
    private String brand;
    private String type;
    private String platNo;
    private String warna;
    private int noOfDoors;
    private double maxSpeed;

    public Car() {
    }

    public Car(String brand, String type, String platNo, String warna, int noOfDoors, double maxSpeed) {
        this.brand = brand;
        this.type = type;
        this.platNo = platNo;
        this.warna = warna;
        this.noOfDoors = noOfDoors;
        this.maxSpeed = maxSpeed;

    }

    public String toString() {
        return String.format("%s %s %s %s %d %f", this.brand, this.type, this.platNo, this.warna, this.noOfDoors, this.maxSpeed);
    }
}

class ParkingLot {
    private Car[] listOfCar;
    private int capacity;
    private int noOfParkedCars;

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.listOfCar = new Car[this.capacity];
    }

    public void numParkACar(Car newCar) {
        this.listOfCar[noOfParkedCars] = newCar;
        this.noOfParkedCars += 1;
        System.out.println(newCar.toString() + " Has just Parked.");
    }

    public String toString() {
        return String.format("this parking lot has %d", this.noOfParkedCars);
    }
}