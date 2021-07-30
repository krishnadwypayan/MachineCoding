package service;

import exceptions.CarTypeNotFoundException;
import model.CarType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class CarTypeService {

    private Map<String, CarType> carTypeMap = new HashMap<>();

    public CarType getCarType(String name) throws CarTypeNotFoundException {
        if (!carTypeMap.containsKey(name)) {
            throw new CarTypeNotFoundException();
        }
        return carTypeMap.get(name);
    }

    public CarType createCarType(String name, double charge) {
        CarType carType = new CarType(charge);
        carTypeMap.put(name, carType);
        return carType;
    }

    public Map<String, CarType> getCarTypeMap() {
        return carTypeMap;
    }
}
