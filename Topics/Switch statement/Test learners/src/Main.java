import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chosenLanguage = scanner.nextInt();
        String output = null;
        switch (chosenLanguage) {
            case 1:
                output = "Yes!";
                break;
            case 2:
            case 3:
            case 4:
                output = "No!";
                break;
            default:
                output = "Unknown number";
                break;
        }
        System.out.println(output);
    }
}