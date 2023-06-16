package org.example;

import java.util.*;

public class CarServiceApp {
    public static void main(String[] args) {
       Map<String ,Car>carTypes=new HashMap<>();
        carTypes.put("Hatchback",new Car("Hatchback"));
        carTypes.put("Sedan",new Car("Sedan"));
        carTypes.put("SUV",new Car("SUV"));

        Map<String, Service> services = new HashMap<>();
       Service basicService=new Service("BS01", "Basic Servicing ");
       basicService.setPrices("Hatchback" , 2000);
       basicService.setPrices("Sedan", 4000);
       basicService.setPrices("SUV",5000);
       services.put("BS01",basicService);

       Service engineService=new Service("EF01","Engine Service");
       engineService.setPrices("Hatchback", 2000);
       engineService.setPrices("Sedan", 3000);
       engineService.setPrices("SUV",1000);
       services.put("EF01",engineService);

       Service clutchFixing =new Service("CF01","clutchFixing");
       clutchFixing.setPrices("Hatchback" ,3000);
       clutchFixing.setPrices("Sedan",5000);
       clutchFixing.setPrices("SUV",6000);
       services.put("CF01",clutchFixing);

       Service breakFixing=new Service("BF01", "BreakFixing");
       breakFixing.setPrices("HatchBack",2000);
       breakFixing.setPrices("Sedan",4000);
       breakFixing.setPrices("SUV",1000);
       services.put("BF01",breakFixing);

      Service gearFixing =new Service("GF01", "Gear Fixing");
      gearFixing.setPrices("HatchBack", 5000);
      gearFixing.setPrices("Sedan",500);
      gearFixing.setPrices("SUV",1000);
      services.put("GF01",gearFixing);
        CarServiceStation serviceStation = new CarServiceStation(carTypes, services);
        BillGenerator billGenerator = new BillGenerator(serviceStation);
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose car type from below:" + "\n" + "Sedan" + "\n" + "Hatchback" + "\n" + "SUV");
        String carType = sc.next();
        System.out.println("Enter number of service needed :");
        int numberOfService = sc.nextInt();
        System.out.println("Avaliable Service and their code: ");
        System.out.println("Basic Servicing --> BS01");
        System.out.println("Engine Fixing --> EF01");
        System.out.println("Clutch Fixing --> CF01");
        System.out.println("Brake Fixing --> BF01");
        System.out.println("Gear Fixing --> GF01");
        System.out.println();

        String [] serviceCode=new String[numberOfService];
        for(int i=0;i<numberOfService;i++){
            System.out.println("Enter Service Code" + (i + 1));
               serviceCode[i]= sc.next();
        }
        billGenerator.genrateBill(carType, serviceCode);
    }
}
class  Car{
    private  String carTyped;

    public  Car(String carTyped){
        this.carTyped=carTyped;
    }
}
// -------------------------------------------------------------------------------------------------//
class
Service{
    private String code;
    private  String name;
  private Map<String,Integer >prices;

  public Service(String  code, String name) {
      this.code=code;
      this.name=name;
     this.prices=new HashMap<>();
  }
     public String getCode(){
      return code;
  }
   public String getName(){
      return name;
   }
     public void setPrices(String carType, int price) {
      prices.put(carType,price);
     }
   public int getPrice(String carType) {
      return prices.get(carType);
   }

}
//--------------------------------------------------------------------------------------//
class CarServiceStation {
    private Map<String , Car> carType;
    private Map<String , Service>services;

    public CarServiceStation (Map<String,Car> carType, Map<String ,Service>services) {
        this.carType=carType;
        this.services=services;
    }
  public int getService(String  serviceCode, String carType){
        Service service=services.get(serviceCode);
        return service.getPrice(carType);
  }
}
class BillGenerator {
    private CarServiceStation carServiceStation;

    public BillGenerator(CarServiceStation carServiceStation) {

        this.carServiceStation = carServiceStation;
    }

    public void genrateBill(String carType, String[] serviceCode) {
        System.out.println("Type of Car: " + carType);
        System.out.println("Service Codes: " + String.join(", ", serviceCode));

        int totalBill = 0;
        for (String serviceCodee : serviceCode) {
            int servicePrice = carServiceStation.getService(serviceCodee, carType);
            System.out.println("Charges for " + servicePrice + " - ₹ " + servicePrice);
            totalBill += servicePrice;
        }
        System.out.println("Total Bill - ₹ " + totalBill);

        if (totalBill > 10000) {
            System.out.println("Complimentary cleaning provided.");
        }
    }
}
