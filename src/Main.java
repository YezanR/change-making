import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] denominations = new int[]{1, 5, 12};

        System.out.println("Enter amount:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        ChangeMaker changeMaker = new ChangeMaker();
        changeMaker.setDenominations(denominations);
        Change change = changeMaker.makeChange(amount);

        System.out.println(change);
    }
}
