import java.util.Scanner;
import java.lang.Math;
public class CoffeeMachine {
    final static Scanner scn = new Scanner(System.in);
//    final static int reqWater = 200;
//    final static int reqMilk = 50;
//    final static int reqBeans = 15;

    static int water,milk,beans,disCups;
    static int wallet;

    private static void getInitState(int w,int m,int b,int c,int money){
        water = w;
        milk = m;
        beans = b;
        disCups = c;
        wallet = money;
    }

    public static void displayFunc(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scn.next();
        switch (action.toLowerCase()){
            case "buy": makeCoffee(); break;
            case "fill": fillMachine(); break;
            case "take": giveMoney(); break;
            case "remaining": currentState(); break;
            case "exit":System.exit(0); break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void currentState(){
        System.out.println("The coffee machine has:\n"+water+" of water\n"+milk+" of milk\n"+beans+" of coffee beans\n"+disCups+" of disposable cups\n$"+wallet+" of money");
    }

    public static void makeCoffee(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = scn.next();
        if (disCups>0) {
            switch (choice){
                case "1": makeEspresso(); break;
                case "2": makeLatte(); break;
                case "3": makeCappuccino(); break;
                case "back": break;
                default:
                    System.out.println("Invalid Choice");
            }
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    private static void makeEspresso(){
        if(water>=250){
            if(beans>=16){
                water-=250;beans-=16;
                wallet+=4;disCups-=1;
                System.out.println("I have enough resources, making you a coffee!");
            }else{
                System.out.println("Sorry, not enough beans!");
            }
        }
        else{
            System.out.println("Sorry, not enough water!");
        }
    }
    private static void makeLatte(){
        if(water>=350){
            if(milk>=75){
                if(beans>=20){
                    water-=350;milk-=75;beans-=20;
                    wallet+=7;disCups-=1;
                    System.out.println("I have enough resources, making you a coffee!");
                }else{
                    System.out.println("Sorry, not enough beans!");
                }
            }else{
                System.out.println("Sorry, not enough milk!");
            }
        }
        else{
            System.out.println("Sorry, not enough water!");
        }
    }
    private static void makeCappuccino(){
        if(water>=200){
            if(milk>=100){
                if(beans>=12){
                    water-=200;milk-=100;beans-=12;
                    wallet+=6;disCups-=1;
                    System.out.println("I have enough resources, making you a coffee!");
                }else{
                    System.out.println("Sorry, not enough beans!");
                }
            }else{
                System.out.println("Sorry, not enough milk!");
            }
        }
        else{
            System.out.println("Sorry, not enough water!");
        }
    }

    protected static void fillMachine(){
        System.out.println("Write how many ml of water do you want to add:");
        water+=scn.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk+=scn.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans+=scn.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disCups+=scn.nextInt();

    }

    private static void giveMoney(){
        System.out.println("I gave you $"+wallet);
        wallet=0;
    }

    public static void main(String[] args) {
        //System.out.println("Hello World!");
//        System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
//
//        int numCupsOfCofee = scn.nextInt();
//        String req = String.format("%s\n%s\n%s\n%s",
//                "For " + numCupsOfCofee + "cups of coffee you will need:",
//                reqWater * numCupsOfCofee + " ml of water",
//                reqMilk * numCupsOfCofee + " ml of milk",
//                reqBeans * numCupsOfCofee + " g of coffee beans");
//        System.out.println(req);
//
//        System.out.println("Write how many ml of water the coffee machine has:");
//        int sWater = scn.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int sMilk = scn.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int sBeans = scn.nextInt();
//        System.out.println("Write how many cups of coffee you will need:");
//        int coffeeAmount = scn.nextInt();
//
//        int rWater = sWater-(reqWater*coffeeAmount);
//        int rMilk = sMilk-(reqMilk*coffeeAmount);
//        int rBeans = sBeans-(reqBeans*coffeeAmount);
//        if (rWater>-1 && rMilk>-1 && rBeans>-1) {
//            System.out.print("Yes, I can make that amount of coffee");
//            if(rWater>=reqWater && rMilk>=reqMilk && rBeans>=reqBeans) {
//                int xtCups = makeCups(rWater,rMilk,rBeans);
//                System.out.println(" (and even " + xtCups + " more that that)");
//            }
//        } else {
//            System.out.print("No");
//            if(sWater>=reqWater && sMilk>=reqMilk && sBeans>=reqBeans){
//                int onlyCups = makeCups(sWater,sMilk,sBeans);
//                System.out.println(", I can make only "+onlyCups+" cup(s) of coffee");
//            }else {
//                System.out.println(", I can make only 0 cup(s) of coffee");
//            }
//        }
//        System.out.println();

        getInitState(400,540,120,9,550);
        while (true) {
            System.out.println();
            displayFunc();
            System.out.println();
        }
    }
//    public static int makeCups(int rWater,int rMilk,int rBeans){
//        int xtWater = rWater / reqWater;
//        int xtMilk = rMilk / reqMilk;
//        int xtBeans = rBeans / reqBeans;
//        return Math.min(Math.min(xtWater, xtMilk), Math.min(xtMilk, xtBeans));
//    }

}
