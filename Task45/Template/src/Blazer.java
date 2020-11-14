public class Blazer implements Item {
    @Override
    public String getName() {
       return "Blazer";
    }

    @Override
    public double getPrice() {
        return 15;
    }

    @Override
    public String getColour() {
        return "Black";
    }
}
