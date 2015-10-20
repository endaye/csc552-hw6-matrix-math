package matrix;
import java.util.concurrent.*;
/**
 * Created by Yuancheng on 10/19/2015.
 */
public class RowColPlusExecutable implements Runnable{

    // code to calculate entry at [row][col] of the resulting matrix
    // from an addition

    final private int[][] first, second;
    private int[][] result;
    private int row, col;

    public RowColPlusExecutable(int[][]first, int[][] second, int[][]result, int row, int col){
        this.first = first;
        this.second = second;
        this.result = result;
        this.row = row;
        this.col = col;
    }

    public void run(){
        result[row][col] = first[row][col] + second[row][col];
    }
}
