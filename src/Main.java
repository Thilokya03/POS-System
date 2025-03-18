import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Product> productList = new HashMap<>();
    static Map<String, Cashers> cashersMap = new HashMap<>();

    public static void loadingCashiers(String filePath){
        try (BufferedReader readFile = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = readFile.readLine()) != null) {
                String[] Line = line.split(",");
                if(Line.length != 2){
                    continue;
                }
                Cashers casher = new Cashers(Line[0] , Line[1]);
                cashersMap.put(Line[0] , casher);
            }
            System.out.println("All cashiers are Loaded !!!");
        } catch (IOException e) {
            System.out.println("Error reading file : " + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("CSV file have errors !!!");
        }
    }

    public static void loadingProduct(String filePath){
        try (BufferedReader readFile = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = readFile.readLine()) != null) {
                String[] Line = line.split(",");
                if(Line.length != 7){
                    continue;
                }
                Product product = new Product(Integer.parseInt(Line[0]),Line[1],Double.parseDouble(Line[2]),Double.parseDouble(Line[3]), Double.parseDouble(Line[4]),
                        Line[5], Line[6]);
                productList.put(Line[0] , product);
            }
            System.out.println("All products are Loaded !!!");
        } catch (IOException e) {
            System.out.println("Error reading file : " + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("CSV file have errors !!!");
        }
    }

    public static void sales(Cashers name){
        Scanner scanner = new Scanner(System.in);
        System.out.println("These following products are in the stock.");
        for(String key : productList.keySet()){
            Product product = productList.get(key);
            System.out.println(key + " : " + product.name + " : " + "Rs. " + product.price);
        }
        System.out.println("\nIf you are finished enter 'Done'.\n");
        billGenarator bill = new billGenarator();
        while (true){
            System.out.print("What do you want to buy (Enter product Code): ");
            String item = scanner.nextLine();
            if(item.equals("Done")){
                System.out.println("All products are added successfully.");
                break;
            }
            else if(!productList.containsKey(item)){
                System.out.println("Invalid Product Code! \n Please Enter Valid product code.");
                continue;
            }
            System.out.print("How many " +item+" do you want to buy (quantity) : " );
            double quantity = scanner.nextDouble();
            scanner.nextLine();
            Product product = productList.get(item);
            billItems billItems = new billItems(product , quantity);
            bill.addItem(billItems);
        }
        double payment;
        do {
            System.out.printf("Your total bill is %.2f \n", bill.totalCost);
            System.out.print("Payments : ");
            payment =+ scanner.nextDouble();
            scanner.nextLine();
            if(payment < bill.totalCost){
                System.out.println("Your payment is not enough!!!");
            }
        }while(payment < bill.totalCost);

        if(payment != bill.totalCost){
            System.out.printf("Exchange is: %.2f\n", (payment - bill.totalCost));

        }
        name.totalBill +=bill.totalCost;
        System.out.println("Thank you!!!");
        System.out.println("Have a nice Day");
    }

    public static void main(String[] args) {
        loadingCashiers("Cashiers.csv");
        loadingProduct("Product.csv");
        System.out.println("***** Welcome to POS System ***** \n");

        int oparation;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println(" 1  -  Register new cashiers");
                System.out.println(" 2  -  Loging to the POS system");
                System.out.println(" 3  -  Exit");
                System.out.print("Chose number : ");
                oparation = scanner.nextInt();
                scanner.nextLine();
                String name;
                String password;
                switch (oparation){
                    case 1:
                        System.out.print("Enter cashiers name : ");
                        name = scanner.nextLine();
                        if(cashersMap.containsKey(name)){
                            System.out.println(name + " is already registered!");
                            continue;
                        }
                        System.out.print("Enter password : ");
                        password = scanner.nextLine();
                        Cashers newCasher = new Cashers(name ,password);
                        cashersMap.put(name , newCasher);
                        System.out.println("Cashier " + name + " registered successful !!!");
                        break;

                    case 2:
                        System.out.print("Enter cashiers name : ");
                        name = scanner.nextLine();
                        if(!cashersMap.containsKey(name)){
                            System.out.println(name + " is not registered!");
                            continue;
                        }
                        Cashers casher = cashersMap.get(name);
                        int count = 0;
                        do {
                            count ++;
                            System.out.print("Enter your password : " );
                            password = scanner.nextLine();
                            if(!casher.checkPassword(password)){
                                System.out.println("Enter Valid Password !!!");
                            } else{
                                System.out.println("successful loging on "+ name + " cashier account.");
                                sales(casher);
                                break;
                            }
                        }while(!casher.checkPassword(name) && count < 3);
                        break;
                    case 3:
                        System.out.println("Thank you for using POS System.");
                        System.out.println("*****   Than you   *****");
                        System.exit(0);

                    default:
                        System.out.println("Enter valid operation");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter Valid Operation");
                scanner.nextLine();
            }
        }
    }
}