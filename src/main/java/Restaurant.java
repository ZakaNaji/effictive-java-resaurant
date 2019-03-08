import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int tablesCount ;
    private List<Table> restaurantListOfTables;

    public Restaurant(){
        restaurantListOfTables = new ArrayList<>();
    }

    public int initTable(int numberOfSeats){
        Table tableToAdd = new Table(numberOfSeats);
        restaurantListOfTables.add(tableToAdd);
        return tablesCount++;
    }

    public void customerSays(int tableId,String customerOrder){
        Parser parser = new ColonParser();
        String customer = parser.parseCustomer(customerOrder);
        Order order = parser.parseOrder(customerOrder);
        Table tableToAddOrderTo = restaurantListOfTables.get(tableId);
        tableToAddOrderTo.addOrderToTable(customer,order);
    }

    public String createOrder(int tableId){
        Table specifiedTable = restaurantListOfTables.get(tableId);
        return (String) specifiedTable.getOrderAsString();
    }

}
