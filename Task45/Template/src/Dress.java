public class Dress implements Item{
    @Override
    public String getName() {
        return "Dress";
    }

    @Override
    public double getPrice() {
        return 20;
    }

    @Override
    public String getColour() {
        return "Black";
    }
}
