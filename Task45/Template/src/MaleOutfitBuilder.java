public class MaleOutfitBuilder implements ChoosingOutfitTemplate {

    @Override
    public Outfit chooseOfficialOutfit() {
        Outfit outfit = new Outfit();
        outfit.addItem(new Blazer());
        outfit.addItem(new Trousers());
        return outfit;
    }

    @Override
    public Outfit chooseCasualOutfit() {
        Outfit outfit = new Outfit();
        outfit.addItem(new Tshirt());
        outfit.addItem(new Jeans());
        return outfit;
    }
}
