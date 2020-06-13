import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scn = new Scanner(System.in);

    final static int reqWater = 200;
    final static int reqMilk = 50;
    final static int reqBeans = 15;

    public static void main(String[] args) {
        System.out.println("Heyy! Its Coffee time...");
        System.out.println("Enter number of cups need - ");
        int numCupsOfCofee = scn.nextInt();
        String req = String.format("%s\n%s\n%s\n%s",
                "For " + numCupsOfCofee + "cups of coffee you will need:",
                reqWater * numCupsOfCofee + " ml of water",
                reqMilk * numCupsOfCofee + " ml of milk",
                reqBeans * numCupsOfCofee + " g of coffee beans");
        System.out.println(req);
        System.out.println();
    }
}

