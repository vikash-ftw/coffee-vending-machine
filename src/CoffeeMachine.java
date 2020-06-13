import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scn = new Scanner(System.in);

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
   
        getInitState(400,540,120,9,550);
        while (true) {
            System.out.println();
            displayFunc();
            System.out.println();
        }
    }

}
