import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; count < num && j < i; j++) {
                str.append(i).append(" ");
                count++;
            }
        }
        System.out.print(str);
    }
}