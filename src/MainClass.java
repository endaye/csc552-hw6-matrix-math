import matrix.*;

/**
 *
 * 1.
 * Finish up a parallel implementation of class MatMath using threads.
 * Your answer will be evaluated on correctness and on the degree of parallelization.
 * (eg. a correct implementation that does not use threads at all will get a ZERO,
 * as will an incorrect implementation that uses threads.)
 * 2.
 * Finish up a parallel implementation of class MatMath using parallel streams from Java 8.
 * This version of the program should NOT use ANY explicit threads.
 * 3.
 * I will test both your programs using the following driver that
 * calculates ((A + B) * C) * D for given matrices A,B,C.
 *
 * Created by Yuancheng on 10/19/2015.
 */
public class MainClass {
    public static void main(String args[]) throws InterruptedException {
        //int[][] A,B,C,D, r,s,t;
        int[][]A = {{4,6,5,7,0},{6,5,0,7,1},{2,6,7,0,6}};
        int[][]B = {{2,2,7,0,8},{2,6,7,8,9},{5,6,4,1,7}};
        int[][]C = {{1,9,0,3},{2,9,7,8},{5,0,5,9},{2,5,1,7},{5,0,1,7}};
        int[][]D = {{0,5},{1,7},{5,1},{9,3}};
        MatMathImpl u = new MatMathImpl();
        // code to initialize A,B,C,D
        int[][]r = new int[A.length][A[0].length];
        int[][]s = new int[r.length][C[0].length];
        int[][]t = new int[s.length][D[0].length];
        u.add(A,B,r);
        u.multiply(r,C,s);
        u.multiply(s,D,t);
        System.out.println("A");
        u.print(A);
        System.out.println("B");
        u.print(B);
        System.out.println("r = A + B");
        u.print(r);
        System.out.println("C");
        u.print(C);
        System.out.println("s = r * C");
        u.print(s);
        System.out.println("D");
        u.print(D);
        System.out.println("t = s * D");
        u.print(t);
    }
}
