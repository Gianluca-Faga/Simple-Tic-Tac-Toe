import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.next();
        double area = 0;
        switch (shape) {
            case "triangle": {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) / 2;
                area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                break;
            }
            case "rectangle": {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                area = a * b;
                break;
            }
            case "circle": {
                double r = scanner.nextDouble();
                area = Math.pow(r, 2) * 3.14;
                break;
            }
            default:
                break;
        }
        System.out.println(area);
    }
}