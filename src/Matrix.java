import java.util.Scanner;
import java.util.regex.Pattern;

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
        int x = 0;
        for(int[] rows : mMatrix) {
            x++;
            System.out.print("| ");
            for(int column : rows) {
                System.out.print(column + " ");
            }
            System.out.println("|");
        }
    }

    public void set() {
        String[] inputValues = enterValues();
        fillMatrix(inputValues);
    }

    private String[] enterValues() {
        int elemN = mColums*mRows;
        String[] inputValues = new String[elemN];
        for (int i = 0; i < elemN; ) {
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            tmp = tmp.replaceAll("[\\s]{2,}", " ");
            String[] splittedInpult = tmp.split(" ");
            for (int k = 0; k < splittedInpult.length; k++) {
                if (i >= elemN) {
                    break;
                }
                inputValues[i] = splittedInpult[k];
                i++;
            }
        }
        return inputValues;
    }

    private void fillMatrix(String[] inputValues) {
        for (int c = 0, i = 0 ; c < mColums; c++) {
            for (int r = 0; r < mRows; r++, i++) {
                if (inputValues[i] == null) {
                    continue;
                }
                mMatrix[c][r] = Integer.parseInt(inputValues[i]);
            }
        }
    }

    public int[][] multiply(int multiplier) {
        int[][] mtx = new int[this.mRows][this.mColums];
        for (int c = 0; c < mColums; c++) {
            for (int r = 0; r < mRows; r++) {
                mtx[c][r] = this.mMatrix[c][r];
            }
        }
        return mtx;
    }
}
