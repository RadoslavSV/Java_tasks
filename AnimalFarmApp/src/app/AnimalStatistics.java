package app;

import lib.*;
import java.util.*;

public class AnimalStatistics {
    private Animal[] animals = new Animal[10];
    List<AnimalInstance> data;

    public AnimalStatistics(List<AnimalInstance> data) {
        this.data = data;

        animals[0] = new Animal("Лъв", AnimalType.BOZAINIK, MorphType.EARTH, true);
        animals[1] = new Animal("Куче", AnimalType.BOZAINIK, MorphType.EARTH, false);
        animals[2] = new Animal("Гълъб", AnimalType.PTICA, MorphType.EARTH, false);
        animals[3] = new Animal("Змия", AnimalType.VLECHUGO, MorphType.EARTH_WATER, true);
        animals[4] = new Animal("Гущер", AnimalType.VLECHUGO, MorphType.EARTH_WATER, false);
        animals[5] = new Animal("Комар", AnimalType.BEZGRABNACHNO, MorphType.EARTH, false);
        animals[6] = new Animal("Пъстърва", AnimalType.RIBA, MorphType.WATER, false);
        animals[7] = new Animal("Акула", AnimalType.RIBA, MorphType.WATER, true);
        animals[8] = new Animal("Делфин", AnimalType.BOZAINIK, MorphType.WATER, false);
        animals[9] = new Animal("Костенурка", AnimalType.VLECHUGO, MorphType.EARTH_WATER, false);
    }

    public void generateData() {
        Random rand = new Random();
        for(int i=0; i<100; i++) {
            int idx = rand.nextInt(0, 10);
            String aName = animals[idx].getName();
            int aAge = rand.nextInt(1,6);

            AnimalInstance ai = new AnimalInstance(idx, aName, aAge);
            data.add(ai);
        }

        for(var x : data) {
            System.out.println(x);
        }
    }

    boolean hasManyPredators() {
       long cntPredators = data.stream()
               .filter(x -> (x.getAnimalName().equals("Лъв") || x.getAnimalName().equals("Змия") || x.getAnimalName().equals("Акула"))).count();
       return cntPredators > data.size()-cntPredators;
    }

    private void groupByAnimalCountingInstances() {
        for(int i=0; i<10; i++) {
            String nm = animals[i].getName();
            long cnt = data.stream().filter(x -> x.getAnimalName().equals(nm)).count();
            System.out.println("Animal " + nm + " has " + cnt + " instances in data.");
        }
    }

    String animalWitMinAge() {
        List<AnimalInstance> newData = data.stream().filter(x -> x.getAnimalAge()==1).toList();
        return newData.toString();
    }

    public static void main(String[] args) {
        List<AnimalInstance> myData = new ArrayList<>();
        AnimalStatistics as1 = new AnimalStatistics(myData);

        as1.generateData();

        System.out.println("\nAre there more predators than any others - " + as1.hasManyPredators() + '\n');

        as1.groupByAnimalCountingInstances();

        System.out.println("\nAll animals with minimum age: " + as1.animalWitMinAge());
    }
}
