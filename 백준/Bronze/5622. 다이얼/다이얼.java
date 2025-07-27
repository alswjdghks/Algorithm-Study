import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] char_array = scanner.nextLine().toCharArray();
        int sum = 0;
        for (char c : char_array) {
            if (c == ' '){
                sum += 2;
            }
            else if (c < 'S' && c >= 'A'){
                sum += (c - 'A') / 3 + 3;
            }
            else if (c >= 'S' && c < 'Z'){
                sum += (c - 'A' -1) / 3 + 3;
            }
            else if (c == 'Z'){
                sum += 10;
            }
            else {
                sum += 11;
            }
        }
        System.out.println(sum);
        scanner.close();
    }
}
