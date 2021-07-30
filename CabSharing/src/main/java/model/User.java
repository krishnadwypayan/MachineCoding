package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class User {
    private String userName;
    private Gender gender;
    private int age;
    private long phone;
    private Location location;
    private List<Ride> rides;

    public User(String userName, Gender gender, int age) {
        this.userName = userName;
        this.gender = gender;
        this.age = age;
        this.rides = new ArrayList<>();
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addRide(Ride ride) {
        this.rides.add(ride);
    }

    public String getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public long getPhone() {
        return phone;
    }

    public Location getLocation() {
        return location;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public double calculateBill() {
        double bill = 0;
        for (Ride ride : rides) {
            bill += ride.getFare();
        }
        return bill;
    }
}

