import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String message = null;
        switch (n) {
            case 1:
                message = "You have chosen a square";
                break;
            case 2:
                message = "You have chosen a circle";
                break;
            case 3:
                message = "You have chosen a triangle";
                break;
            case 4:
                message = "You have chosen a rhombus";
                break;
            default:
                message = "There is no such shape!";
                break;
        }
        System.out.println(message);
    }
}
