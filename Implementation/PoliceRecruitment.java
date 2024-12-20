import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int untreatedCrimes = 0, availableOfficers = 0;

        for (int i = 0; i < n; i++) {
            int event = scanner.nextInt();
            if (event == -1) {
                if (availableOfficers > 0) {
                    availableOfficers--;
                } else {
                    untreatedCrimes++;
                }
            } else {
                availableOfficers += event;
            }
        }
        
        System.out.println(untreatedCrimes);
    }
}
