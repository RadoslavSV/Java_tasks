package lab3aProblem1;

import java.util.Scanner;
import static java.lang.Math.*;

public class ComputeByMenu {
    private double x;
    private Scanner input = new Scanner(System.in);

    public ComputeByMenu(double x) {
        this.x = x;
    }

    public void displayMenu() {
        for(int i=0; i<55; i++) {
            System.out.println();
        }
        System.out.println("1. Input double number\n2. exp(x)\n3. sin(x)\n4. floor(x)\n5. End");
    }

    public void doSelection(int choice) {

        if(choice==1) {
            System.out.print("Input x: ");
            this.x = Double.parseDouble(input.nextLine());
        } else if(choice==2) {
            System.out.printf("exp(%.2f)=%.2f\n", x, Math.exp(x));
        } else if(choice==3) {
            System.out.printf("sin(%.2f)=%.2f\n", x, Math.sin(x));
        } else if(choice==4) {
            System.out.printf("floor(%.2f)=%.2f\n", x, Math.floor(x));
        } else if(choice==5) {
            System.exit(0);
        }
    }

    public void getUserChoice() {
        int choice;
        while(true) {
            do {
                displayMenu();
                System.out.print("Choose an option from 1 to 5: ");
                choice = Integer.parseInt(input.nextLine());
            } while (choice < 1 || choice > 5);
            doSelection(choice);
            System.out.println("Press Enter to choose again");
            input.nextLine();
        }
    }
}
