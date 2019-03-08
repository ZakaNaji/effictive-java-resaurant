public class ForParser implements Parser {

    @Override
    public String parseCustomer(String strToParse) {
        return strToParse.split(" for ")[0];
    }

    @Override
    public int numberOfCustomers(String strToParse) {
        return Integer.parseInt(strToParse.split(" for ")[1]);
    }

    @Override
    public Order parseOrder(String strToParse) {
        return null;
    }
}
