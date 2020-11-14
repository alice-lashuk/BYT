public class Tshirt implements Item{
    @Override
    public String getName() {
        return "Tshirt";
    }

    @Override
    public double getPrice() {
        return 6;
    }

    @Override
    public String getColour() {
        return "Orange";
    }
}
