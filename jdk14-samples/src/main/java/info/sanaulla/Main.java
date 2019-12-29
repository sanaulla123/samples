package info.sanaulla;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Fruit is %s\n" , isHealthy("Fruit"));
        System.out.printf("Pizze is %s\n", isHealthEnumVersion(Food.Pizza));

        System.out.printf("Your food received %d points\n",
                evaluateLunch(Food.Burger));
        System.out.printf("Your food received %d points\n",
                evaluateLunchOldWay(Food.Fruit));


        switch ("hello"){
            case "hello":
                System.out.println("Hello");
                break;
                default:
                    System.out.println("default");
        }

        PreparedFood preparedFood = prepareFoodOldSyntax(Food.Pizza);
        System.out.println(preparedFood);
    }

    public static boolean isHealthy(String food){
        return switch (food){
            case "Fruit"  -> true;
            case "Vegetable" -> true;
            case "Pizza" -> false;
            case "Burger" -> false;
            case "Pulses" -> true;
            case "Soft Drink" -> false;
            default -> false;
        };
    }

    public static Boolean isHealthEnumVersion(Food food){
        return switch (food){
            case Fruit -> true;
            case Vegetable -> true;
            case Pizza -> false;
            case Burger -> false;
            case Pulses -> true;
            case Soft_Drink -> false;
        };
    }

    public static int evaluateLunch(Food food){
        return switch (isHealthEnumVersion(food).toString()){
            case "true" -> 10;
            case "false" -> 5;
            default -> 0;
        };
    }

    public static int evaluateLunchOldWay(Food food){
        return switch (isHealthEnumVersion(food).toString()){
            case "true": yield 10;
            case "false":  yield 5;
            default: yield 0;
        };
    }

    public static PreparedFood prepareFood(Food food){
        return switch (food){
            case Pizza -> {
                System.out.println("doing pizza related operations");
                yield new PreparedFood(food);
            }
            case Burger -> {
                System.out.println("Doing burger related operations ");
                yield new PreparedFood(food);
            }
            default -> {
                System.out.printf("Doing %s related operations\n", food.toString());
                yield new PreparedFood(food);
            }
        };

    }

    public static PreparedFood prepareFoodOldSyntax(Food food){
        return switch (food){
            case Pizza:
                System.out.println("doing pizza related operations");
                yield new PreparedFood(food);
            case Burger:
                System.out.println("Doing burger related operations ");
                yield new PreparedFood(food);
            default:
                System.out.printf("Doing %s related operations\n", food.toString());
                yield new PreparedFood(food);
        };

    }
}

enum Season{
    Summer, Winter, Rainy;
}
enum Food {
    Fruit, Vegetable, Pizza, Burger, Pulses, Soft_Drink
}

class PreparedFood {
    private Food food;
    PreparedFood(Food food){
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
