
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class Table {
    private int numberOfSeats;
    private Map<String,Order> customersAndTheirOrders;

    public Table(int numberOfSeats){
        this.numberOfSeats = numberOfSeats;
        this.customersAndTheirOrders = new LinkedHashMap<String, Order>();
    }

    public void addOrderToTable(String customer, Order order){
        if(order.getDishName().equals("Same")){
            order = getPreviousOrder();
        }
        adjustNumberOfSeats(customer);
        customersAndTheirOrders.put(customer,order);
    }

    private void adjustNumberOfSeats(String customer) {
        if(!customersAndTheirOrders.containsKey(customer)){
            numberOfSeats--;
        }
    }

    public Order getPreviousOrder() {
        String previousCustomer = null;
        for (String customer : customersAndTheirOrders.keySet()){
            previousCustomer = customer;
        }
        return customersAndTheirOrders.get(previousCustomer);
    }

    public String getOrderAsString(){
        if (everyOneWasServed()){
            if(orderContainSharedDish()){
                return getOrderAsStringWithSharedDish();
            }else{
                return getOrderAsStringWithIndividualDish();
            }
        }else{
            return shouldCompleteOrder();
        }
    }

    public boolean everyOneWasServed(){
        return (numberOfSeats == 0);
    }

    public String shouldCompleteOrder(){
        return "MISSING "+ numberOfSeats;
    }

    private boolean orderContainSharedDish() {
        for (String customer : customersAndTheirOrders.keySet()){
            if(customersAndTheirOrders.get(customer).isShared()) return true;
        }
        return false;
    }

    private String getOrderAsStringWithSharedDish() {
        int difference = sharedDishExpectedCustomersNumber() - sharedDishActualCustomersNumber();
        if(difference == 0){
            return getOrderAsStringWithIndividualDish();
        }
        return "MISSING "+difference+" for " + getTheSharedOrder().getDishName();
    }

    private int sharedDishActualCustomersNumber() {
        int i = 0;
        for (String customer : customersAndTheirOrders.keySet()){
            if(customersAndTheirOrders.get(customer).getDishName().equals(getTheSharedOrder().getDishName())) i++;
        }
        return i;
    }

    private int sharedDishExpectedCustomersNumber() {
        Parser parser = new ForParser();
        return parser.numberOfCustomers(getTheSharedOrder().getDishName());
    }

    private String getOrderAsStringWithIndividualDish() {
        return customersAndTheirOrders.values().stream().map(Objects::toString).collect(Collectors.joining(", "));
    }
    public Order getTheSharedOrder(){
        for (String customer : customersAndTheirOrders.keySet()){
            if(customersAndTheirOrders.get(customer).isShared()) return customersAndTheirOrders.get(customer);
        }
        return null;
    }
}
