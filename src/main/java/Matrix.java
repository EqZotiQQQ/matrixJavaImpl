//TODO probable i need to use class Either or Optional to avoid throwing of exceptions
//TODO rework input from file.
//TODO probably i need to leave fraction 3/5 5/22 etc instead of 3.2 2.1 etc

import java.lang.Math;
import java.io.*;
import java.util.Scanner;

public class Matrix {
    private int mRows;
    private int mColums;
<<<<<<< HEAD
=======
    private MyPair[][] mMtx;
>>>>>>> 963dac5... added common fractions
    private double[][] mMatrix;
    private int size;

    @Override
    public int hashCode() {
        //TODO

        return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int c = 0, n = 0; c < this.mColums; c++) {
            for(int r = 0; r < this.mRows; r++, n++) {
                sb.append(Double.toString(this.mMatrix[c][r]));
                if(n == (size - 1)) {
                    break;
                }
                sb.append(", ");
            }
        }
        return sb.toString();
    }


    public Matrix(Matrix mtx) {
        this.mRows = mtx.mRows;
        this.mColums = mtx.mColums;
        createMatrix();
        for(int c = 0; c < this.mColums; c++) {
            for(int r = 0; r < this.mRows; r++) {
                this.mMtx[c][r].setKey(mtx.mMtx[c][r].getKey());
                this.mMtx[c][r].setValue(mtx.mMtx[c][r].getValue());
            }
        }
    }

<<<<<<< HEAD
    public Matrix(final int rows, final int columns) {
        this.mRows = rows;
        this.mColums = columns;
        createMatrix();
    }

    public Matrix transposition() {
        Matrix mtx = new Matrix(mColums, mRows);
        for(int r = 0; r < mColums; ++r) {
            for(int c = 0; c < mRows; ++c) {
                mtx.mMatrix[r][c] = this.mMatrix[c][r];
=======
    private void createMatrix() {
        this.mMtx = new MyPair[mRows][mColums];
        for(int r = 0; r < mRows; r++) {
            for(int c = 0; c < mColums; c++) {
                this.mMtx[r][c] = new MyPair();
>>>>>>> 963dac5... added common fractions
            }
        }
        return mtx;
    }

<<<<<<< HEAD
    private void createMatrix() {
        this.mMatrix = new double[mRows][mColums];
        this.size = mColums*mRows;
    }

    public void printRound() {
        for(int r = 0; r < mRows; r++) {
            System.out.print(" | ");
            for(int c = 0; c < mColums; c++) {
                System.out.print((int)mMatrix[r][c] + " ");
            }
            System.out.println("|");
        }
    }

=======
>>>>>>> 963dac5... added common fractions
    public void print() {
        for(int r = 0; r < mRows; r++) {
            System.out.print(" | ");
            for(int c = 0; c < mColums; c++) {
<<<<<<< HEAD
                System.out.print(mMatrix[r][c] + " ");
=======
                if(mMtx[r][c].getValue() == 1) {
                    System.out.print(mMtx[r][c].key + " ");
                } else {
                    System.out.print(mMtx[r][c].key + "/" + mMtx[r][c].value + " ");
                }
>>>>>>> 963dac5... added common fractions
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

    private void fillMatrix(String[] inputValues) {
        for (int r = 0, i = 0 ; r < mRows; r++) {
            for (int c = 0; c < mColums; c++, i++) {
                mMtx[r][c].key = Integer.parseInt(inputValues[ i ]);
                mMtx[r][c].value = 1;
            }
        }
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
                inputValues[i] = splittedInpult[k];
                i++;
            }
        }
        return inputValues;
    }

    public int getRows() {
        return mRows;
    }

    public int getColumns() {
        return mColums;
    }

    public Matrix transposition() {
        Matrix mtx = new Matrix(mColums, mRows);
        for(int r = 0; r < mColums; ++r) {
            for(int c = 0; c < mRows; ++c) {
                mtx.mMtx[r][c].key = this.mMtx[c][r].key;
                mtx.mMtx[r][c].value = this.mMtx[c][r].value;
            }
        }
        return mtx;
    }

    public void multiply(int multiplier) {
        for (int r = 0; r < mRows; r++) {
            for (int c = 0; c < mColums; c++) {
                mMtx[r][c].key *= multiplier;
            }
        }
    }

    //TODO probably there should be "double multiplier"... dunno
    public static Matrix multiply(Matrix mtx, int multiplier) {
        Matrix resMtx = new Matrix(mtx.mRows, mtx.mColums);
        for (int c = 0; c < mtx.mColums; c++) {
            for (int r = 0; r < mtx.mRows; r++) {
                resMtx.mMtx[r][c].key = mtx.mMtx[r][c].key * multiplier;
            }
        }
        return resMtx;
    }

    public static Matrix multiplyMatrixes(Matrix mtx1, Matrix mtx2) throws Exception {
        if(mtx1.mRows != mtx2.mColums) {
            throw new Exception();
        }
        Matrix resMtx = new Matrix(mtx1.mRows, mtx2.mColums);
        for(int r1 = 0; r1 < mtx1.mRows; r1++) {
            for(int c2 = 0; c2 < mtx2.mColums; c2++) {
                for(int c1 = 0; c1 < mtx1.mColums; c1++) {
                    resMtx.mMtx[r1][c2].value += mtx1.mMtx[r1][c1].value * mtx2.mMtx[c1][c2].value;
                    resMtx.mMtx[r1][c2].key += mtx1.mMtx[r1][c1].key * mtx2.mMtx[c1][c2].key;
                }
            }
        }
        return resMtx;
    }

    public static Matrix add(Matrix a, Matrix b) throws Exception {
        if((a.mColums != b.mColums) || (a.mRows != b.mRows)) {
            throw new Exception();
        }
        Matrix c = new Matrix(a.mRows, a.mColums);
        for (int col = 0; col < c.mColums; col++) {
            for(int row = 0; row <c.mRows; row++) {
                c.mMatrix[row][col] = a.mMatrix[row][col] +  b.mMatrix[row][col];
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
                if(mMatrix[r][c] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSquareMatrix() {
        return mColums == mRows;
    }

    public double getDeterminant() throws Exception{
        if(!isSquareMatrix()) {
            throw new Exception();
        }
        double determinant = 0;
        if (this.mColums == 1) {
            determinant = singleElementMatrixDeterminant();
        } else if (this.mColums == 2) {
            determinant = quadElementsMatrixDeterminant();
        } else if (this.mColums == 3) {
            determinant = methodOfTriangles();
        } else {
            determinant = methodForN();
        }

        return determinant;
    }

    private int methodForN() {

        Matrix mtx = new Matrix(this);
        int determinant = 1;

        for(int r = 1; r < mRows; r++) {
            for(int i = 0; i < r; i++) {
                double coefficient = mtx.mMatrix[r][i] / mtx.mMatrix[i][i];
                boolean minus =  mtx.mMatrix[i][i] * coefficient > mtx.mMatrix[r][i];
                if(!minus) {
                    for(int c = 0; c < mColums; c++) {
                        if(mtx.mMatrix[i][c] == 0) {
                            continue;
                        }
                        mtx.mMatrix[r][c] = mtx.mMatrix[r][c] - mtx.mMatrix[i][c] * coefficient;
                    }
                } else {
                    for(int c = 0; c < mColums; c++) {
                        if (mtx.mMatrix[i][c] == 0) {
                            continue;
                        }
                        mtx.mMatrix[r][c] = mtx.mMatrix[r][c] + mtx.mMatrix[i][c] * coefficient;
                    }
                }
            }
            determinant *= mtx.mMatrix[r][r];
        }
        return determinant;
    }


    private Matrix generateAdditionalMatrix() {
        Matrix mtx = new Matrix(mRows, mColums * 2 - 1);
        for(int c = 0; c < mColums; c++) {
            for(int r = 0; r < mRows; r++) {
                mtx.mMatrix[r][c] = this.mMatrix[r][c];
            }
        }
        for(int c = mColums; c < mColums * 2 - 1; c++) {
            for(int r = 0; r < mRows; r++) {
                mtx.mMatrix[r][c] = mtx.mMatrix[r][c-mColums];
            }
        }
        return mtx;
    }

    private double singleElementMatrixDeterminant() {
        return mMatrix[0][0];
    }

    private double quadElementsMatrixDeterminant() {
        return mMatrix[0][0] * mMatrix[1][1] - mMatrix[0][1] * mMatrix[1][0];
    }

    private double methodOfTriangles() {
        Matrix mtx = generateAdditionalMatrix();

        int res = 0;
        for(int i = 0; i < mColums; i++) {
            int mult = 1;
            for(int k = 0; k < mColums; k++) {
                mult *= mtx.mMatrix[k][k+i];
            }
            res += mult;
        }
        for(int i = 0; i < mColums; i++) {
            int mult = 1;
            for(int k = this.mColums-1, j = this.mColums-1; k < mtx.mColums; k++, j--) {
                mult *= mtx.mMatrix[this.mRows - 1 - j][mtx.mColums - 1 - k + i];
            }
            res -= mult;
        }
        return res;
    }

    private Matrix calculateMatrixOfMinor() {
        Matrix matrixOfMinor = new Matrix(this.mRows, this.mColums);
        for(int c = 0; c < mColums; c++) {
            for( int r = 0; r < mRows; r++) {
                matrixOfMinor.mMatrix[c][r] = this.calculateMinorValue(c, r);
            }
        }
        return matrixOfMinor;
    }

    private double calculateMinorValue(int c, int r) {
        double minor = 0;
        Matrix minorMatrix = new Matrix(this.mRows-1, this.mColums-1);
        for(int cc = 0, mc = 0; cc < this.mColums; cc++) {
            if(cc == c) {
                continue;
            }
            for (int rr = 0, mr = 0; rr < this.mRows; rr++) {
                if(rr == r)
                {
                    continue;
                }
                minorMatrix.mMatrix[mc][mr] = this.mMatrix[cc][rr];
                mr++;
            }
            mc++;
        }
        try {
            minor = minorMatrix.getDeterminant();
        } catch(Exception e) {
            System.out.println("Exception in getDeterminant-calculateMinorValue-calculateMatrixOfMinor-getReveseMatrix");
        }
        return minor;
    }

    private Matrix MatrixOfAlgebraicAddtitions() {
        Matrix maa = new Matrix(this);
        for(int c = 0; c < this.mColums; c++) {
            for(int r = 0; r < this.mRows; r++) {
                if (c % 2 == 0) {
                    if (r % 2 != 0) {
                        maa.mMatrix[c][r] = -this.mMatrix[c][r];
                    }
                } else {
                    if (r % 2 == 0) {
                        maa.mMatrix[c][r] = -this.mMatrix[c][r];
                    }
                }
            }
        }
        return maa;
    }

    public void invertibleMatrix() {
        Matrix resMatrix;
        double detResMatrix = 0;
        try {
            detResMatrix = this.getDeterminant();
            if(detResMatrix == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("getDetterminant exception in reverse Matrix");
        }
        Matrix matrixOfMinors = calculateMatrixOfMinor();
        Matrix matrixOfAdditionals = matrixOfMinors.MatrixOfAlgebraicAddtitions();
        Matrix tMatrixOfAdditionals = matrixOfAdditionals.transposition();
        //resMatrix = Matrix.multiply(tMatrixOfAdditionals, 1/detResMatrix);
        return;// TODO Because here now I used int - I need to multiply
        //return resMatrix;
    }



}
