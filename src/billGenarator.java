import java.util.Vector;

public class billGenarator {
    Vector<billItems> salesItems = new Vector<>();
    double totalCost = 0 ;

    public void addItem(billItems item){
        salesItems.add(item);
        totalCost =+ item.total;
    }

    public void deleteItem(billItems items){
        if(salesItems.isEmpty()){
            System.out.println("Bill is empty !!!");
            return;
        }
        else if(salesItems.contains(items)){
            System.out.println("That product was not add in the bill !!!");
            return;
        }

        for(int i = 0 ; i < salesItems.capacity();i++) {
            if (salesItems.elementAt(i) == items) {
                billItems billItems = salesItems.get(i);
                totalCost =- billItems.total;
                salesItems.remove(i);
                System.out.println("Successfully deleted.");
                System.out.println(items + "is deleted!!!");
                return;
            }
        }
    }




}
