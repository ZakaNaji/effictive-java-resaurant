public class Order{
    private String dishName;

    public Order(String dishName){
        this.dishName = dishName;
    }

    public String getDishName(){
        return dishName;
    }

    public boolean isShared(){
        return dishName.contains("for");
    }

    @Override
    public String toString() {
        return dishName;
    }
}