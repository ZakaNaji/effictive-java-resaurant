public interface Parser {
    String parseCustomer(String strToParse);
    Order parseOrder(String strToParse);
    int numberOfCustomers(String strToParse);
}
