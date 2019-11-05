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
                System.out.println(tmp);
                mMatrix[r][c] = sc.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Matrix mtx = new Matrix(3,3);
        mtx.print();
        mtx.set();
        mtx.print();
    }
}
