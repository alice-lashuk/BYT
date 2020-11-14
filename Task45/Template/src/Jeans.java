public class Jeans implements Item {
    @Override
    public String getName() {
        return "Jeans";
    }

    @Override
    public double getPrice() {
        return 10;
    }

    @Override
    public String getColour() {
        return "Blue";
    }
}
