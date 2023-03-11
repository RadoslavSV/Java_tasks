package lib;

public class AnimalInstance {
    private int animalKey;
    private String animalName;
    private int animalAge;

    public int getAnimalKey() {
        return animalKey;
    }

    public void setAnimalKey(int animalKey) {
        this.animalKey = animalKey;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public AnimalInstance(int animalKey, String animalName, int animalAge) {
        this.animalKey = animalKey;
        this.animalName = animalName;
        this.animalAge = animalAge;
        INSTANCE_ID = String.format("%s %03d", getAnimalName(), getAnimalKey());
    }

    public final String INSTANCE_ID;

    @Override
    public String toString() {
        return String.format("%s, Възраст: %d", this.INSTANCE_ID, getAnimalAge());
    }

//    public static void main(String[] args) {
//        AnimalInstance ai1 = new AnimalInstance(12, "Комар", 1);
//        AnimalInstance ai2 = new AnimalInstance(14, "Пъстърва", 3);
//        System.out.println(ai1);
//        System.out.println(ai2);
//    }
}
