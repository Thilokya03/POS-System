public class Product {
    int code;
    double weight,price, quantity;
    String name, unit, company;

    public Product(int Code,String Name, double Quantity,double price, double Weight , String Unit, String Company){
        this.code = Code;
        this.name = Name;
        this.quantity = Quantity;
        this.price = price;
        this.weight = Weight;
        this.unit = Unit;
        this.company = Company;
    }
}