package lecture4;

public class CountFactors {
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
    public static void main(String[] args) {
      int result = new CountFactors().factors(24);
      System.out.println("Factor count of 24 is: " + result);
    }
}
