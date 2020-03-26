package chap1;

public class TwoDice {
    public static void twoDice(int N) {
        int sizes = 6;
        double[] res = new double[2*sizes+1];
        for(int i = 1; i <= sizes; i++) {
            for(int j = 1; j <= sizes; j++) {
                res[i+j] += 1.0;
            }
        }
        for(int k = 2; k <= sizes * 2; k++) {
            res[k] /= 36.0;
        }
        System.out.println("N: " + N);
        for(int i = 1; i <= 2*sizes; i++) {
            System.out.printf("%.5f ", res[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        for(int i = 10; i < 1e6; i=i*10) {
            System.out.println("i: " + i);
            twoDice(i);
        }
    }
}
