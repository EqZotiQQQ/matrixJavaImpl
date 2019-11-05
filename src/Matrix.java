import java.util.Scanner;

public class Matrix {
    private int mRows;
    private int mColums;
    private int[][] mMatrix;

    public Matrix(int rows, int columns) {
        this.mRows = rows;
        this.mColums = columns;
        createMatrix();
    }

    private void createMatrix() {
        mMatrix = new int[mRows][mColums];
    }

    public void print() {
        for(int[] rows : mMatrix) {
            for(int column : rows) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public void set() {
        for(int c = 0; c < mColums; c++) {
            for(int r = 0; r < mRows; r++) {
                Scanner sc = new Scanner(System.in);
                String tmp = sc.nextLine();
                String[] splittedInpult = tmp.split(" ");
                //TODO: input like: 1 enter 2 enter 3 enter etc
                //TODO: input like: 1 2 3 4 5 etc
                //TODO: hybrid
            }
        }
    }

    public int[][] multiply(int multiplier) {
        int[][] mtx = new int[this.mRows][this.mColums];
        for(int c = 0; c < mColums; c++) {
            for (int r = 0; r < mRows; r++) {
                mtx[c][r] = this.mMatrix[c][r];
            }
        }
        return mtx;
    }

    public static void main(String[] args) {
        Matrix mtx = new Matrix(3,3);
        mtx.print();
        mtx.set();
        mtx.print();
    }
}
