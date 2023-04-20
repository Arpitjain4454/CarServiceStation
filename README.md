# Car Service Station Software

This is a Java program that simulates a car service station software. The program allows the user to select a car type (hatchback, sedan, or SUV) and one or more services (basic service, engine fixing, clutch fixing, brake fixing, or gear fixing) and generates a bill with the total charges for the requested services based on the car type.

The program demonstrates several OOPs (Object-Oriented Programming) concepts, including:

- Encapsulation: Each class (Car, Service, and Bill) encapsulates its data and behavior in a self-contained unit. For example, the Car class has private fields for the car type and prices, and public getter methods to access them. Similarly, the Service class has private fields for the service code, name, and prices, and a public method to calculate the price based on the car type. The Bill class has private fields for the car and services, and public methods to calculate the total bill and print the bill details.

- Inheritance: The Car class is a superclass that defines the common properties and methods of all types of cars. The Hatchback, Sedan, and SUV classes are subclasses that inherit the properties and methods of the Car class and add their own specific properties and methods. This allows the program to use polymorphism to treat all types of cars as instances of the Car class, and to call their common and specific methods using the same syntax.

- Polymorphism: The program uses polymorphism to create Car objects based on the user input car type, and to call their methods without knowing their specific class. For example, the program creates a Car object using the `getCar` helper method based on the user input car type, and calls its `getPrice` method to calculate the price of a service for that car type.

- Composition: The Bill class is composed of a Car object and a list of Service objects, and uses them to calculate the total bill. This allows the program to reuse the Car and Service classes independently, and to create different bills with different cars and services.

To run the program, compile the `CarServiceStation.java` file using a Java compiler (e.g., `javac CarServiceStation.java`) and run the `CarServiceStation` class using a Java Virtual Machine (e.g., `java CarServiceStation`). The program will prompt the user to enter the car type and service codes, and will generate a bill with the total charges and any complimentary cleaning provided (if applicable).

Note: The program assumes that the user input is valid and follows the specified format (car type as a string and service codes as comma-separated strings). Invalid input may cause the program to fail or produce incorrect results.
