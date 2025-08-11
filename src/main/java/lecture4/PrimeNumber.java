package lecture4;

import java.util.concurrent.ScheduledExecutorService;

public class PrimeNumber {
    public int factors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if(i == n/i) {
                    count++;
                } else {
                    count = count + 2;
                }
            }
        }
        return count;
    }
    public boolean checkPrime(int n) {
        int factorsCount = factors(n);
        return factorsCount <= 2;
    }
    public static void main(String[] args) {
      boolean result = new PrimeNumber().checkPrime(7);
      System.out.println("Is 7 prime? " + result);
    }
}
