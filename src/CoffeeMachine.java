package machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String doIt;
        String exit = new String("original");

        //Initial Resources
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int money = 550;
        String coffee;

        //displayIngr(cups, water, milk, coffeeBeans, money);

        try {
            while (exit != "exit") {
                System.out.println("Write action (buy, fill, take, exit, remaining): ");
                doIt = scanner.next();

                switch (doIt) {
                    case "buy": {
                        if ((water >= 200) && (coffeeBeans >= 12)) {
                            System.out.print("What do you want to buy?");
                            System.out.println(" 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                            coffee = scanner.next().trim();
                            displaySteps();
                            switch (coffee) {
                                case "1": {
                                    if (water < 250) System.out.println("Sorry, not enough water!");
                                    else if(coffeeBeans < 16) System.out.println("Sorry, not enough coffee beans!");
                                    else {
                                        water -= 250;
                                        coffeeBeans -= 16;
                                        cups--;
                                        money += 4;
                                        System.out.println("I have enough resources, making you a coffee!");
                                    }
                                    break;
                                }
                                case "2": {
                                    if (water < 350) System.out.println("Sorry, not enough water!");
                                    else if (milk < 75) System.out.println("Sorry, not enough milk!");
                                    else if(coffeeBeans < 20) System.out.println("Sorry, not enough coffee beans!");
                                    else {
                                        water -= 350;
                                        milk -= 75;
                                        coffeeBeans -= 20;
                                        cups--;
                                        money += 7;
                                        System.out.println("I have enough resources, making you a coffee!");
                                    }
                                    break;
                                }
                                case "3": {
                                    if (water < 200) System.out.println("Sorry, not enough water!");
                                    else if (milk < 100) System.out.println("Sorry, not enough milk!");
                                    else if(coffeeBeans < 12) System.out.println("Sorry, not enough coffee beans!");
                                    else {
                                        water -= 200;
                                        milk -= 100;
                                        coffeeBeans -= 12;
                                        cups--;
                                        money += 6;
                                        System.out.println("I have enough resources, making you a coffee!");
                                    }
                                    break;
                                }
                                case "back": break;
                            }
                        } else System.out.println("There aren't enough supplies!\nWait for refill!\n");
                        break;
                    }
                    case "fill": {
                        try {
                            System.out.println("Write how many ml of water do you want to add:");
                            water += scanner.nextInt();

                            System.out.println("Write how many ml of milk do you want to add:");
                            milk += scanner.nextInt();
                            System.out.println("Write how many grams of coffee beans do you want to add: ");
                            coffeeBeans += scanner.nextInt();
                            System.out.println("Write how many disposable cups of coffee do you want to add:");
                            cups += scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Try again!");
                        }
                        break;
                    }
                    case "take": {
                        System.out.println("I gave you $" + money);
                        money = 0;
                        break;
                    }
                    case "exit": {exit = "exit";
                        break;}
                    case "remaining":{
                        displayIngr(cups, water, milk, coffeeBeans, money);
                        break;}
                }
            }
        } catch(Exception e){
        }
    }

    public static void displayAvailability(int cups, int water, int milk, int coffeeBeans){
        int waterAmount = 200 * cups;
        int milkAmount = 50 * cups;
        int coffeeBeansAmount = 15 * cups;
        int n = 0;

        try {
            n = Math.min(Math.min(Math.round(water / waterAmount), Math.round(milk / milkAmount)), Math.round(coffeeBeans / coffeeBeansAmount));
        } catch (Exception e) {
        }
        int n2 = Math.min(Math.min(Math.round(water/ 200), Math.round(milk/ 50)), Math.round(coffeeBeans/ 15));

        boolean condition = (water >= waterAmount) && (milk >= milkAmount) && (coffeeBeans >= coffeeBeansAmount);
        if (condition &&  ((water < 200) || (milk < 50) || (coffeeBeans < 15)))
            System.out.println("Yes, I can make that amount of coffee");
        else if (condition)
            System.out.println("Yes, I can make that amount of coffee (and even " + (n-1) + " more than that)");
        else System.out.println( "No, I can make only " + n2 + " cup(s) of coffee");
    }

    public static void displaySteps(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void displayIngr(int cups, int water, int milk, int coffeeBeans, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water+ " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
    public static void displayAmountIngr( int cups){
        System.out.println("\nFor " + cups + " cups of coffee you will need:");
        System.out.println((200 * cups) + " ml of water");
        System.out.println((50 * cups) + " ml of milk");
        System.out.println((15 * cups) + " g of coffee beans");
    }
}