public class FemaleOutfitBuilder implements ChoosingOutfitTemplate {
    @Override
    public Outfit chooseOfficialOutfit() {
        Outfit outfit = new Outfit();
        outfit.addItem(new Dress());
        return outfit;
    }

    @Override
    public Outfit chooseCasualOutfit() {
        Outfit outfit = new Outfit();
        outfit.addItem(new Top());
        outfit.addItem(new Skirt());
        return outfit;
    }
}
