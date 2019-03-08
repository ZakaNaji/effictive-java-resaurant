public class TEST {
    public static void main(String[] args) {
        /*final Restaurant restaurant = new Restaurant();
        final int tableId = restaurant.initTable(4);
        restaurant.customerSays(tableId, "Joe: Soup");
        restaurant.customerSays(tableId, "Jim: Same");
        restaurant.customerSays(tableId, "Jack: Chips");
        restaurant.customerSays(tableId, "John: Chips");
        restaurant.toTest();*/

        Table table = new Table(4);
        table.addOrderToTable("zaka",new Order("chips"));
        table.addOrderToTable("zaka1",new Order("hot dog"));
        table.addOrderToTable("zaka2",new Order("asomthing"));
        table.addOrderToTable("zaka3",new Order("same"));
        System.out.println(table.getOrderAsString());
    }
}
