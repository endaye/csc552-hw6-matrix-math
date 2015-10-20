package matrix;
import java.util.Arrays;
/**
 * Created by Yuancheng on 10/19/2015.
 */

public class MatMathImpl implements MatMath {
    private RowColPlusExecutable[][] PlusGrid;
    private RowColProdExecutable[][] ProdGrid;
    private Thread[][] PlusThreadGrid;
    private Thread[][] ProdThreadGrid;
    private int size;

    // add A and B into C
    public void add(int[][]A, int[][]B, int[][]C) throws InterruptedException {
        PlusGrid = new RowColPlusExecutable[A.length][A[0].length];
        PlusThreadGrid = new Thread[A.length][A[0].length];

        for(int i = 0; i < PlusGrid.length; i++) {
            for(int j = 0; j < PlusGrid[0].length; j++) {
                PlusGrid[i][j] = new RowColPlusExecutable(A, B, C, i, j);
                PlusThreadGrid[i][j] = new Thread(PlusGrid[i][j]);
            }
        }
        for(int i = 0; i < PlusThreadGrid.length; i++) {
            for (int j = 0; j < PlusThreadGrid[0].length; j++) {
                PlusThreadGrid[i][j].start();
                PlusThreadGrid[i][j].join();
            }
        }
    }

    // multiply A and B into C
    public void multiply(int[][] A, int[][]B, int[][]C) throws InterruptedException {
        ProdGrid = new RowColProdExecutable[A.length][B[0].length];
        ProdThreadGrid = new Thread[A.length][B[0].length];
        size = A[0].length;

        for(int i = 0; i < ProdGrid.length; i++) {
            for(int j = 0; j < ProdGrid[0].length; j++) {
                ProdGrid[i][j] = new RowColProdExecutable(A, B, C, i, j, size);
                ProdThreadGrid[i][j] = new Thread(ProdGrid[i][j]);
            }
        }
        for(int i = 0; i < ProdThreadGrid.length; i++) {
            for (int j = 0; j < ProdThreadGrid[0].length; j++) {
                ProdThreadGrid[i][j].start();
                ProdThreadGrid[i][j].join();
            }
        }

    }

    // pretty print A
    public void print(int[][]A){
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
