public class Main {

    public static void main(String[] args) {
        ChoosingOutfitTemplate builder1 = new FemaleOutfitBuilder();
        ChoosingOutfitTemplate builder2 = new FemaleOutfitBuilder();

        Outfit outfit1 = builder1.chooseCasualOutfit();
        Outfit outfit2 = builder1.chooseCasualOutfit();
        Outfit outfit3 = builder2.chooseOfficialOutfit();
        Outfit outfit4 = builder2.chooseCasualOutfit();

        outfit1.getItems();
        System.out.println("-----------");
        System.out.println("Total: " + outfit1.getTotalCost());

        System.out.println();

        outfit2.getItems();
        System.out.println("------------");
        System.out.println("Total: " + outfit2.getTotalCost());
        System.out.println();

        outfit3.getItems();
        System.out.println("-----------");
        System.out.println("Total: " + outfit3.getTotalCost());
        System.out.println();

        outfit4.getItems();
        System.out.println("-----------");
        System.out.println("Total: " + outfit4.getTotalCost());


    }
}
