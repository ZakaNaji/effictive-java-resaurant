public class ColonParser implements Parser {
    public String parseCustomer(String strToParse) {
        return strToParse.split(": ")[0];
    }

    public Order parseOrder(String strToParse) {
        return new Order(strToParse.split(": ")[1]);
    }

    @Override
    public int numberOfCustomers(String strToParse) {
        return 0;
    }
}
