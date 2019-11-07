import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private int mRows;
    private int mColums;
    private int[][] mMatrix;
    private int size;

    public Matrix(Matrix mtx) {
        this.mRows = mtx.mRows;
        this.mColums = mtx.mColums;
        createMatrix();
        for(int i = 0; i < this.mRows; i++) {
            for(int j = 0; j < this.mColums; j++) {
                this.mMatrix[j][i] = mtx.mMatrix[j][i];
            }
        }
    }

    public Matrix(int rows, int columns) {
        this.mRows = rows;
        this.mColums = columns;
        createMatrix();
    }

    private void createMatrix() {
        this.mMatrix = new int[mRows][mColums];
        this.size = mColums*mRows;
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

    public void set(String... args) {
        String[] inputValues;
        if(args.length != 0) {
            inputValues = fileInput(args[0]);
        } else {
            inputValues = enterValues();
        }
        fillMatrix(inputValues);
    }

    private String[] fileInput(String filePath) {
        String[] result = new String[size];
        File file = new File(filePath);
        if (!file.exists()) return null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int i = 0;
            String tempStr = reader.readLine();
            while ((tempStr != null) && (i < size)) {
                String[] temp = tempStr.split("[\\s]{1,}");
                for(int j = 0; j < temp.length; j++) {
                    result[i] = temp[j];
                    i++;
                }
                tempStr = reader.readLine();
            }
        } catch (IOException ioe) {}
        return result;
    }

    private String[] enterValues() {
        String[] inputValues = new String[size];
        for (int i = 0; i < size; ) {
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            String[] splittedInpult = tmp.split("[\\s]{1,}");
            for (int k = 0; k < splittedInpult.length; k++) {
                if (i >= size) {
                    break;
                }
                inputValues[ i ] = splittedInpult[ k ];
                i++;
            }
        }
        return inputValues;
    }

    private void fillMatrix(String[] inputValues) {
        for (int r = 0, i = 0 ; r < mRows; r++) {
            for (int c = 0; c < mColums; c++, i++) {
                System.out.println(Integer.parseInt(inputValues[ i ]));
                mMatrix[ r ][ c ] = Integer.parseInt(inputValues[ i ]);
            }
        }
    }

    public int getRows() {
        return mRows;
    }

    public int getColumns() {
        return mColums;
    }

    public void multiply(int multiplier) {
        for (int c = 0; c < mColums; c++) {
            for (int r = 0; r < mRows; r++) {
                mMatrix[ c ][ r ] *= multiplier;
            }
        }
    }

    public static Matrix multiplyMatrixes(Matrix mtx1, Matrix mtx2) {
        if(mtx1.mRows != mtx2.mColums) {
            return null;
        }
        Matrix resMtx = new Matrix(mtx1.mRows, mtx2.mColums);

        for(int i = 0; i < mtx1.mRows; i++) {
            for(int j = 0; j < mtx2.mColums; j++) {
                for(int m = 0; m < mtx1.mColums; m++) {
                    resMtx.mMatrix[ i ][ j ] += (mtx1.mMatrix[ i ][ m ] * mtx2.mMatrix[ m ][ j ]);
                }
            }
        }
        return resMtx;
    }

    public Matrix transposition() {
        Matrix mtx = new Matrix(mColums, mRows);
        for(int i = 0; i < mColums; ++i) {
            for(int j = 0; j < mRows; ++j) {
                mtx.mMatrix[i][j] = this.mMatrix[j][i];
            }
        }
        return mtx;
    }
}
