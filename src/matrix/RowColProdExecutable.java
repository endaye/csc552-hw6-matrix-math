package matrix;

/**
 * Created by Yuancheng on 10/19/2015.
 */
public class RowColProdExecutable implements Runnable{

    // code to calculate entry at [row][col] of the resulting matrix
    // from a multiplication

    final private int[][] first, second;
    private int[][] result;
    private int row, col, size;

    public RowColProdExecutable(int[][]first, int[][] second, int[][]result, int row, int col, int size){

        this.first = first;
        this.second = second;
        this.result = result;
        this.row = row;
        this.col = col;
        this.size = size;
    }

    public void run(){
        for (int k = 0; k < size; k++){
            result[row][col] += first[row][k] * second[k][col];
        }
    }
}