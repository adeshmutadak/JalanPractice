
<h1 align="center">  Jalan Technolgies Oops Project Application(OOPs)👋</h1>

* This is simple Java application  a car service station that offers different types of services for various car types. The application allows users to generate a detailed bill based on the selected car type and service codes.

## Class  Car 
The `Car` class represents a car and has the following attributes and methods:
- `type`: A private string variable that stores the type of the car.
- `Car(String type)`: A constructor that initializes the `type` of the car.
- `getType()`: A method that returns the type of the car.

## Class CarServiceApp 
The `CarServiceApp` class is the entry point of the application. It contains the main method and handles user input for selecting the car type and service codes. It utilizes the `CarServiceStation` and `BillGenerator` classes to generate the bill.

## Class CarServiceStation 
The `CarServiceStation` class represents the car service station. It has the following attributes and methods:
- `carTypes`: A `Map` that stores the available car types and their corresponding `Car` objects.
- `services`: A `Map` that stores the available services and their corresponding `Service` objects.
- `CarServiceStation(Map<String, Car> carTypes, Map<String, Service> services)`: A constructor that initializes the car types and services.
- `getServicePrice(String serviceCode, String carType)`: A method that retrieves the price of a service for a specific car type.

## Class Service
The `Service` class represents a service offered by the car service station. It has the following attributes and methods:
- `code`: A private string variable that stores the code of the service.
- `name`: A private string variable that stores the name of the service.
- `prices`: A `Map` that stores the prices of the service for different car types.
- `Service(String code, String name)`: A constructor that initializes the code and name of the service.
- `setPrice(String carType, int price)`: A method that sets the price of the service for a specific car type.
- `getPrice(String carType)`: A method that retrieves the price of the service for a specific car type.

## Class BillGenerator
The `BillGenerator` class generates a detailed bill based on the selected car type and service codes. It has the following attributes and methods:
- `serviceStation`: A reference to the `CarServiceStation` object.
- `BillGenerator(CarServiceStation serviceStation)`: A constructor that initializes the `serviceStation` reference.
- `generateBill(String carType, String[] serviceCodes)`: A method that generates the bill by calculating the total charges for the selected services and displaying the details. It also checks if the total bill is more than ₹10,000 and displays a complimentary cleaning message if applicable.

## Use
1. Run the `CarServiceApp` class.
2. Select the car type from the provided options: Sedan, Hatchback, SUV.
3. Enter the number of services needed.
4. Enter the service codes for each service needed.
5. The application will generate a detailed bill, displaying the car type, service codes, charges for each service, total bill amount, and a complimentary cleaning message if the total bill exceeds ₹10,000.


