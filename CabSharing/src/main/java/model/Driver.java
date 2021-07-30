package model;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class Driver {
    private String name;
    private Gender gender;
    private int age;
    private Car car;
    private Location location;
    private double earning;
    private boolean status;

    public Driver(String name, Gender gender, int age, Car car, Location location) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.car = car;
        this.location = location;
        this.earning = 0;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void updateEarning(double earning) {
        this.earning += earning;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Car getCar() {
        return car;
    }

    public Location getLocation() {
        return location;
    }

    public boolean getStatus() {
        return status;
    }

    public double getEarning() {
        return earning;
    }

    private class Car {
        private String type;
        private String carNumber;

        public Car(String type, String carNumber) {
            this.type = type;
            this.carNumber = carNumber;
        }

        public String getType() {
            return type;
        }

        public String getCarNumber() {
            return carNumber;
        }
    }
}
