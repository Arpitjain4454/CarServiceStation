package org.example;

import java.util.*;

// Car class representing different types of cars
class Car {
    String type;
    int hatchbackPrice;
    int sedanPrice;
    int suvPrice;

    public Car(String type, int hatchbackPrice, int sedanPrice, int suvPrice) {
        this.type = type;
        this.hatchbackPrice = hatchbackPrice;
        this.sedanPrice = sedanPrice;
        this.suvPrice = suvPrice;
    }
}

// Service class representing different types of services
class Service {
    String serviceCode;
    String serviceName;
    int hatchbackPrice;
    int sedanPrice;
    int suvPrice;

    public Service(String serviceCode, String serviceName, int hatchbackPrice, int sedanPrice, int suvPrice) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.hatchbackPrice = hatchbackPrice;
        this.sedanPrice = sedanPrice;
        this.suvPrice = suvPrice;
    }
}

// Bill class representing the bill for a service request
class Bill {
    Car car;
    List<Service> services;
    int totalBill;

    public Bill(Car car, List<Service> services) {
        this.car = car;
        this.services = services;
        this.totalBill = 0;
    }

    public void calculateBill() {
        for (Service service : services) {
            if (car.type.equals("Hatchback")) {
                totalBill += service.hatchbackPrice;
            } else if (car.type.equals("Sedan")) {
                totalBill += service.sedanPrice;
            } else if (car.type.equals("SUV")) {
                totalBill += service.suvPrice;
            }
        }
    }

    public void printBill() {
        System.out.println("Type of Car: " + car.type);
        System.out.println("Service Requested:");
        for (Service service : services) {
            System.out.println(service.serviceName + " - " + getServicePrice(service));
        }
        System.out.println("Total Bill: " + totalBill);
        if (totalBill > 10000) {
            System.out.println("Complimentary Cleaning Provided");
        }
    }

    private String getServicePrice(Service service) {
        if (car.type.equals("Hatchback")) {
            return "₹ " + service.hatchbackPrice;
        } else if (car.type.equals("Sedan")) {
            return "₹ " + service.sedanPrice;
        } else if (car.type.equals("SUV")) {
            return "₹ " + service.suvPrice;
        }
        return "";
    }
}

public class CarServiceStation {
    public static void main(String[] args) {
        // Create Car objects for different types of cars
        Car hatchback = new Car("Hatchback", 2000, 4000, 5000);
        Car sedan = new Car("Sedan", 2000, 4000, 6000);
        Car suv = new Car("SUV", 3000, 6000, 8000);

        // Create Service objects for different types of services
        Service basicService = new Service("BS01", "Basic Servicing", 2000, 4000, 5000);
        Service engineFixing = new Service("EF01", "Engine Fixing", 5000, 8000, 10000);
        Service clutchFixing = new Service("CF01", "Clutch Fixing", 2000, 4000, 6000);
        Service brakeFixing = new Service("BF01", "Brake Fixing", 1000, 1500, 2500);
        Service gearFixing = new Service("GF01", "Gear Fixing", 3000, 6000, 8000);

        // Take input for car type and service codes
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Car Type (Hatchback/Sedan/SUV): ");
        String carType = scanner.nextLine();

        System.out.print("Enter Service Codes (separated by comma): ");
        String[] serviceCodes = scanner.nextLine().split(",");

        // Create a list of Service objects based on input service codes
        List<Service> services = new ArrayList<>();
        for (String code : serviceCodes) {
            switch (code.trim()) {
                case "BS01":
                    services.add(basicService);
                    break;
                case "EF01":
                    services.add(engineFixing);
                    break;
                case "CF01":
                    services.add(clutchFixing);
                    break;
                case "BF01":
                    services.add(brakeFixing);
                    break;
                case "GF01":
                    services.add(gearFixing);
                    break;
                default:
                    System.out.println("Invalid Service Code: " + code);
            }
        }

        // Create a Bill object and calculate the bill
        Bill bill = new Bill(getCar(carType, hatchback, sedan, suv), services);
        bill.calculateBill();

        // Print the bill
        bill.printBill();
    }

    // Helper function to get the Car object based on input car type
    private static Car getCar(String carType, Car hatchback, Car sedan, Car suv) {
        switch (carType.trim().toLowerCase()) {
            case "hatchback":
                return hatchback;
            case "sedan":
                return sedan;
            case "suv":
                return suv;
            default:
                return null;
        }
    }
}