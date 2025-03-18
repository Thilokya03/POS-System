import java.util.Scanner;

public class Cashers {
    private String name;
    private String password;
    double totalBill;

    public Cashers(String name, String password){
        this.name = name;
        this.password = password;
    }

    public boolean checkPassword(String password){
        return this.password.equalsIgnoreCase(password);
    }
}
