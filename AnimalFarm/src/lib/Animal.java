package lib;

public class Animal {
    private String name;
    private AnimalType animalType;
    private MorphType morphType;
    private boolean predator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public MorphType getMorphType() {
        return morphType;
    }

    public void setMorphType(MorphType morphType) {
        this.morphType = morphType;
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public Animal(String name, AnimalType animalType, MorphType morphType, boolean predator) {
        this.name = name;
        this.animalType = animalType;
        this.morphType = morphType;
        this.predator = predator;
    }

    public Animal(Animal a) {
        this.name = a.getName();
        this.animalType = a.getAnimalType();
        this.morphType = a.getMorphType();
        this.predator = a.isPredator();
    }

    @Override
    public String toString() {
        String isPred = (isPredator()) ? "Да" : "Не";
        return String.format("Животно{%s, тип = %s, морфология = %s, хищник = %s}",
                name, animalType.getTypeName(), morphType.getMorphType(), isPred);
    }

//    public static void main(String[] args) {
//        Animal a1 = new Animal("Колибри", AnimalType.PTICA, MorphType.EARTH, false);
//        Animal a2 = new Animal("Крокодил", AnimalType.VLECHUGO, MorphType.EARTH_WATER, true);
//        System.out.println(a1);
//        System.out.println(a2);
//    }
}
