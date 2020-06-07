package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    public static void main(String[] args) {

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printCurrentState();
                    break;
                case "exit":
                    System.exit(0);
            }
        }




    }
    public static void printCurrentState() {
        System.out.println("The coffee machine has:");
        System.out.println(
                water + " of water\n" +
                        milk + " of milk\n" +
                        beans + " of coffee beans\n" +
                        cups + " of disposable cups\n$" +
                        money + " of money"
        );
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String command = scanner.nextLine();
        int flavor = 0;
        if (command.equals("back")) {
            return;
        } else {
            flavor = Integer.parseInt(command);
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cup!");
            return;
        }
        if (flavor == 1) {
            buyEspresso();
        } else if (flavor == 2) {
            buyLatte();
        } else if (flavor == 3) {
            buyCappuccino();
        }
    }
    static void buyEspresso() {
        if (water < 250){
            System.out.println("Sorry, not enough water!");
        } else if (beans < 16) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            beans -= 16;
            money += 4;
            cups--;
        }
    }
    static void buyLatte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 20) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            beans -= 20;
            money += 7;
            cups--;
        }
    }
    static void buyCappuccino(){
        if (water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 12) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            beans -= 12;
            money += 6;
            cups--;
        }
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(scanner.nextLine());

    }

    public static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

}
