//TODO probable i need to use class Either or Optional to avoid throwing of exceptions
//TODO rework input from file.

import java.io.*;
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
        for(int c = 0; c < this.mColums; c++) {
            for(int r = 0; r < this.mRows; r++) {
                this.mMatrix[r][c] = mtx.mMatrix[r][c];
            }
        }
    }

    public Matrix(final int rows, final int columns) {
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
        if (!file.exists())  {              //case when i want to return matrix of 0 if file doens't exist
            for(int i = 0; i < result.length; i++) {
                result[i] = "0";
            }
            return result;
        }
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

    public static Matrix multiplyMatrixes(Matrix mtx1, Matrix mtx2) throws Exception {
        if(mtx1.mRows != mtx2.mColums) {
            throw new Exception();
        }
        Matrix resMtx = new Matrix(mtx1.mRows, mtx2.mColums);
        for (int c = 0; c < resMtx.mColums; c++) {
            for(int r = 0; r < resMtx.mRows; r++) {
                System.out.print(resMtx.mMatrix[c][r]);
            }
            System.out.println();
        }

        for(int r1 = 0; r1 < mtx1.mRows; r1++) {
            for(int c2 = 0; c2 < mtx2.mColums; c2++) {
                for(int c1 = 0; c1 < mtx1.mColums; c1++) {
                    resMtx.mMatrix[ r1 ][ c2 ] += (mtx1.mMatrix[ r1 ][ c1 ] * mtx2.mMatrix[ c1 ][ c2 ]);
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

    public static Matrix add(Matrix a, Matrix b) throws Exception {
        if((a.mColums != b.mColums) || (a.mRows != b.mRows)) {
            throw new Exception();
        }
        Matrix c = new Matrix(a.mRows, a.mColums);
        for (int col = 0; col < c.mColums; col++) {
            for(int row = 0; row <c.mRows; row++) {
                c.mMatrix[col][row] = a.mMatrix[col][row] +  b.mMatrix[col][row];
            }
        }
        return c;
    }

    public boolean isMatrixOfZeros() {
        return isMatrixOf(0);
    }

    public boolean isMatrixOf(final int value) {
        for(int c = 0; c < mColums; c++) {
            for(int r = 0; r < mRows; r++) {
                if(mMatrix[c][r] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSquareMatrix() {
        return mColums == mRows;
    }

    public int getDeterminant() throws Exception{
        if(isSquareMatrix() == false) {
            throw new Exception();
        }
        int determinant = 0;

        calcSums();

        return determinant;
    }

    private Matrix generateAdditionalMatrix() {
        Matrix mtx = new Matrix(mRows, mColums * 2 - 1);
        for(int c = 0; c < mColums; c++) {
            for(int r = 0; r < mRows; r++) {
                mtx.mMatrix[c][r] = this.mMatrix[c][r];
            }
        }
        for(int c = mColums; c < mColums * 2 - 1; c++) {
            for(int r = 0; r < mRows; r++) {
                mtx.mMatrix[c][r] = mtx.mMatrix[c][r-mColums];
            }
        }
        return mtx;
    }

    private int calcSums() {
        Matrix mtx = generateAdditionalMatrix();
        int res = 0;
        mtx.print();
        return res;
    }

}
