package com.json_handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Cars {

    private String brand;
    private String model;
    private int year;

    public Cars(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}


public class ListToJsonArray {

    public static void main(String[] args) throws Exception {

        List<Cars> cars = new ArrayList<>();
        cars.add(new Cars("Toyota", "Camry", 2022));
        cars.add(new Cars("Honda", "Civic", 2021));
        cars.add(new Cars("Tesla", "Model 3", 2023));

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = mapper.writeValueAsString(cars);

        System.out.println(jsonArray);
    }
}
