import java.util.Scanner;
import java.lang.Math;
public class CoffeeMachine {
    final static Scanner scn = new Scanner(System.in);

    final static int reqWater = 200;
    final static int reqMilk = 50;
    final static int reqBeans = 15;


    public static void main(String[] args) {
        System.out.println("Tell me the quantity of resources...");
        System.out.println("Write how many ml of water the coffee machine has:");
        int sWater = scn.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int sMilk = scn.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int sBeans = scn.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeAmount = scn.nextInt();

        int rWater = sWater-(reqWater*coffeeAmount);
        int rMilk = sMilk-(reqMilk*coffeeAmount);
        int rBeans = sBeans-(reqBeans*coffeeAmount);
        if (rWater>-1 && rMilk>-1 && rBeans>-1) {
            System.out.print("Yes, I can make that amount of coffee");
            if(rWater>=reqWater && rMilk>=reqMilk && rBeans>=reqBeans) {
                int xtCups = makeCups(rWater,rMilk,rBeans);
                System.out.println(" (and even " + xtCups + " more that that)");
            }
        } else {
            System.out.print("Not enough resources");
            if(sWater>=reqWater && sMilk>=reqMilk && sBeans>=reqBeans){
                int onlyCups = makeCups(sWater,sMilk,sBeans);
                System.out.println(", I can make only "+onlyCups+" cup(s) of coffee");
            }
        }
        System.out.println();

    }
    public static int makeCups(int rWater,int rMilk,int rBeans){
        int xtWater = rWater / reqWater;
        int xtMilk = rMilk / reqMilk;
        int xtBeans = rBeans / reqBeans;
        return Math.min(Math.min(xtWater, xtMilk), Math.min(xtMilk, xtBeans));
    }

}
