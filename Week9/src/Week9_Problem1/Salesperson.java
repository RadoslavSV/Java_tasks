/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week9_Problem1;

//import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author echrk
 */
@FunctionalInterface
interface Adder<T extends Salesperson>{
    T add (T op1, T op2);
    default String printNumSales (T obj){
        return "Adder " + obj.getNumSales() ;
    }
    static void printSales(Salesperson s)
    {
        System.out.println(s.getNumSales());
    }
}
public class Salesperson implements Adder<Salesperson>
{
   private String name;
   private double salary;
   private int numsales;

  public Salesperson(String name, double salary, int numsales)
   {
      this.name = name;
      this.salary = salary;
      this.numsales = numsales;
   }

  public void addBonus(double amount)
   {
      salary += amount;
   }

  public int getNumSales()
   {
      return numsales;
   }
  public double getSalary()
   {
      return salary;
   }
  public String printNumSales (Salesperson obj){
       
        return String.format("%s Sales: %d",Adder.super.printNumSales(obj),
                   obj.getNumSales());
    }
  
    public static Set<Salesperson> distinct (List<Salesperson> list) {
        if(list==null) return null;
        return new HashSet<>(list);
    }
   @Override
   public String toString()
   {
      return String.format("name: %s, salary: %.2f numsales: %d ", 
                              name, salary, numsales);
}

    @Override
    public Salesperson add(Salesperson op1, Salesperson op2) {
        return new Salesperson(op1.name, op1.salary, op1.numsales+ op2.numsales); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesperson that = (Salesperson) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, numsales);
    }
}
 class LambdaDemo
{
   public static void main(String[] args)
   {
      Predicate<Salesperson> predicate1 = (a) -> a.getNumSales()>1200; // да се инициализира
      Predicate<Salesperson> predicate2 = (a) -> a.getNumSales()<=900; // да се инициализира
      Predicate<Salesperson> predicate = predicate1.or(predicate2); // -> true 1 или 2

      Consumer<Salesperson> consumer1 = (a) -> {
          a.addBonus(a.getSalary()*0.05);
//          System.out.println(a);
      }; // да се инициализира
      Consumer<Salesperson> consumer2 = (a) -> {
          if(predicate1.test(a)) {
              a.addBonus(a.getSalary()*0.02);
          } else {
              a.addBonus(-(a.getSalary()*0.02));
          }
//          System.out.println(a);
      }; // да се инициализира

      Comparator<Salesperson> comparator1 = (o1, o2) -> {
          return Double.compare(o2.getSalary(), o1.getSalary());
      }; // да се инициализира
      Comparator<Salesperson> comparator2 = (o1, o2) -> {
          int cmp = Double.compare(o2.getSalary(), o1.getSalary());
          if(cmp==0) {
              return o1.getNumSales() - o2.getNumSales();
          } else {
              return cmp;
          }
      }; // да се инициализира

       Random random = new Random();
      Salesperson[] salespersons =
      {
         new Salesperson("John Doe", 2100, 949),
         new Salesperson("Jane Doe", 3900, 1500),

         new Salesperson("Ann", 2100, 939),
         new Salesperson("Ban", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Sam", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Van", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Dan", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Rob", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Bob", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Mary", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Bill", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
         new Salesperson("Mark", random.nextInt(1000,10_001), random.nextInt(1000,4_001)),
      };

      Salesperson added = salespersons[0].add(salespersons[0],salespersons[1]);
      System.out.println("Using add: " + added.toString());

      List<Salesperson> listOfSalespersons = new ArrayList<>();
       listOfSalespersons.addAll(Arrays.asList(salespersons));
      // обектите на salespersons да се запишат в listOfSalespersons
       System.out.println("\nApply bonus: ");
      for (Salesperson salesperson: salespersons)
      {
         applyBonus(salesperson, predicate1, consumer1);
         System.out.println(salesperson);
         salesperson.printNumSales(salesperson);
      }
       System.out.println("\nApply bonus2: ");
      for (Salesperson salesperson: salespersons) {
          applyBonus(salesperson, predicate2, consumer2);
          System.out.println(salesperson);
      }

       System.out.println("Sort using comparator1: ");
      sort(listOfSalespersons, comparator1);
      System.out.println(listOfSalespersons);

       System.out.println("Sort using comparator2: ");
      sort(listOfSalespersons, comparator2);
      System.out.println(listOfSalespersons);
      
   }
     
   public static void applyBonus(Salesperson salesperson,
                                 Predicate<Salesperson> predicate,
                                 Consumer<Salesperson> consumer)
   {
      // Напишете if  команда, където използвайте predicate 
      //    за да определите дали да изпълните consumer
      // Изпълнете consumer, когато условието на if  командата е изпълнено
       if(salesperson==null || predicate==null || consumer==null) return;

       if(predicate.test(salesperson)) {
           consumer.accept(salesperson);
       }
   }
 
   public static void applyBonus(List<Salesperson> salespersons,
                                 Predicate<Salesperson> predicate,
                                 Consumer<Salesperson> consumer)
   {
      // Напишете if  команда, където използвайте predicate 
      //    за да определите дали да изпълните consumer
      // Изпълнете consumer, когато условието на if  командата е изпълнено
       if(salespersons==null || predicate==null || consumer==null) return;

       for(int i=0; i<salespersons.size(); i++) {
           if(salespersons.get(i) == null) continue;
           if (predicate.test(salespersons.get(i))) {
               consumer.accept(salespersons.get(i));
           }
       }
   }

   public static void sort(List<Salesperson> salespersons,
                                 Comparator<Salesperson> comparator)
   {
      // Сортирайте  salespersons като използвате  comparator
       if(salespersons == null || comparator == null) return;
       salespersons.sort(comparator);
   }

}

