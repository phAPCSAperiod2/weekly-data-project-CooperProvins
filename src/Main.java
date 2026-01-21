import java.util.Scanner;
public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Data myWeek = new Data();
        System.out.println("Welcome to the instagram screen time tracker!");
        continueEntry();
        for (String day : Data.getDaysOfWeek()){
            System.out.print("Enter screen time (hours:mins) for " + day + ": ");
            myWeek.addTime(input.nextLine());
            clear();
        }
        clear();
        myWeek.printBarChart();
        System.out.print("\nYour screen time ");
        double slope = myWeek.getSlope();
        if (slope < -2){
            System.out.print("decreased heavily");
        }
        else if (slope < -1){
            System.out.print("decreased lightly");
        }
        else if (slope < 1){
            System.out.print("had no general trend");
        }
        else if (slope < 2){
            System.out.print("increased lightly");
        }
        else {
            System.out.print("increased heavily");
        }
        System.out.println(" over time.");
        System.out.println("Max: " + myWeek.getMax());
        System.out.println("Min: " + myWeek.getMin());
        System.out.println("Average: " + myWeek.getMean());
        System.out.println("Slope: " + myWeek.getSlope());

    }
    public static void continueEntry(){
        System.out.print("Press Enter to continue...");
        // String consumeResponse = input.nextLine();
        input.nextLine();
        clear();
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}