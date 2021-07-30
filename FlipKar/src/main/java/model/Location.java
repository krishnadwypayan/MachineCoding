package model;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class Location {
    private double lat;
    private double lng;

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getDist(double lat, double lng) {
        return Math.sqrt(Math.pow(lat - this.lat, 2) + Math.pow(lng - this.lng, 2));
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
