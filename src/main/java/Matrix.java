//TODO probable i need to use class Either or Optional to avoid throwing of exceptions
//TODO rework input from file.
// сломался, когда спереди были пробелы
// ломается на размере матрицы больше, чем 4

import java.lang.Math;
import java.io.*;
import java.util.Scanner;

import org.apache.commons.math3.fraction.Fraction;


public class Matrix {
    private int mRows;
    private int mColumns;
    private Fraction[][] mMatrix;
    private int mSize;

    public Matrix(final int rows, final int columns) {
        this.mRows = rows;
        this.mColumns = columns;
        mSize = mRows*mColumns;
        createMatrix();
    }

    public Matrix(Matrix mtx) {
        this.mRows = mtx.mRows;
        this.mColumns = mtx.mColumns;
        mSize = mRows*mColumns;
        createMatrix();
        for(int r = 0; r < this.mRows; r++) {
            for(int c = 0; c < this.mColumns; c++) {
                this.mMatrix[r][c] = mtx.mMatrix[r][c];
            }
        }
    }

    private void createMatrix() {
        this.mMatrix = new Fraction[mRows][mColumns];
        for(int r = 0; r < mRows; r++) {
            for(int c = 0; c < mColumns; c++) {
                this.mMatrix[r][c] = new Fraction(0,1);
            }
        }
    }

    public int getRows() {
        return mRows;
    }

    public int getColumns() {
        return mColumns;
    }

    public boolean isSquareMatrix() {
        return mColumns == mRows;
    }

    public void print() {
        for(int r = 0; r < mRows; r++) {
            System.out.print(" |\t");
            for(int c = 0; c < mColumns; c++) {
                if(mMatrix[r][c].getDenominator() != 1) {
                    System.out.print(mMatrix[r][c].getNumerator() + "/" + mMatrix[r][c].getDenominator() + "\t");
                } else {
                    System.out.print(mMatrix[r][c].getNumerator() + "\t");
                }
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
            for (int c = 0; c < mColumns; c++, i++) {
                mMatrix[r][c] = new Fraction(Double.valueOf(inputValues[i]));
            }
        }
    }

    private String[] fileInput(String filePath) {
        String[] result = new String[mSize];
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
            while ((tempStr != null) && (i < mSize)) {
                String[] temp = tempStr.split("[\\s]{1,}");
                for(int j = 0; j < temp.length; j++) {
                    result[i] = temp[j];
                    i++;
                }
                tempStr = reader.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("ioex");
        }
        return result;
    }

    private String[] enterValues() {
        String[] inputValues = new String[mSize];
        for (int i = 0; i < mSize; ) {
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            String[] splittedInpult = tmp.split("[\\s]{1,}");
            for (int k = 0; k < splittedInpult.length; k++) {
                if (i >= mSize) {
                    break;
                }
                inputValues[i] = splittedInpult[k];
                i++;
            }
        }
        return inputValues;
    }

    public Matrix transposition() {
        Matrix mtx = new Matrix(mColumns, mRows);
        for(int r = 0; r < mRows; ++r) {
            for(int c = 0; c < mRows; ++c) {
                mtx.mMatrix[c][r] = this.mMatrix[r][c];
            }
        }
        return mtx;
    }

    public void multiply(int multiplier) {
        for (int r = 0; r < mRows; r++) {
            for (int c = 0; c < mColumns; c++) {
                mMatrix[r][c] = mMatrix[r][c].multiply(multiplier);
            }
        }
    }

    public static Matrix multiply(Matrix mtx, double multiplier) {
        Matrix resMtx = new Matrix(mtx.mRows, mtx.mColumns);
        for (int c = 0; c < mtx.mColumns; c++) {
            for (int r = 0; r < mtx.mRows; r++) {;
                resMtx.mMatrix[r][c] = mtx.mMatrix[r][c].multiply(new Fraction(multiplier));
            }
        }
        return resMtx;
    }

    public static Matrix multiplyMatrises(Matrix mtx1, Matrix mtx2) throws Exception {
        if(mtx1.mRows != mtx2.mColumns) {
            throw new Exception();
        }
        Matrix resMtx = new Matrix(mtx1.mRows, mtx2.mColumns);
        for(int r1 = 0; r1 < mtx1.mRows; r1++) {
            for(int c2 = 0; c2 < mtx2.mColumns; c2++) {
                for(int c1 = 0; c1 < mtx1.mColumns; c1++) {
                    resMtx.mMatrix[r1][c2] = resMtx.mMatrix[r1][c2].add(mtx1.mMatrix[r1][c1].multiply(mtx2.mMatrix[c1][c2]));
                }
            }
        }
        return resMtx;
    }

    public static Matrix add(Matrix a, Matrix b) throws Exception {
        if((a.mColumns != b.mColumns) || (a.mRows != b.mRows)) {
            throw new Exception();
        }
        Matrix c = new Matrix(a.mRows, a.mColumns);
        for (int col = 0; col < c.mColumns; col++) {
            for(int row = 0; row <c.mRows; row++) {
                c.mMatrix[row][col] = a.mMatrix[row][col].add(b.mMatrix[row][col]);
            }
        }
        return c;
    }

    public boolean isMatrixOfZeros() {
        return isMatrixOf(0);
    }

    public boolean isMatrixOf(final int value) {
        for(int c = 0; c < mColumns; c++) {
            for(int r = 0; r < mRows; r++) {
                if(mMatrix[r][c].intValue() != value) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        //TODO

        return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int c = 0, n = 0; c < this.mColumns; c++) {
            for(int r = 0; r < this.mRows; r++, n++) {
                sb.append(this.mMatrix[c][r].toString());
                if(n == (mSize - 1)) {
                    break;
                }
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public Fraction getDeterminant() throws Exception{
        if(!isSquareMatrix()) {
            throw new Exception();
        }
        Fraction determinant = new Fraction(0);
        if (this.mColumns == 1) {
            determinant = singleElementMatrixDeterminant();
        } else if (this.mColumns == 2) {
            determinant = quadElementsMatrixDeterminant();
        } else if (this.mColumns == 3) {
            determinant = methodOfTriangles();
        } else {
            determinant = methodForN();
        }
        return determinant;
    }

    private Fraction singleElementMatrixDeterminant() {
        return mMatrix[0][0];
    }

    private Fraction quadElementsMatrixDeterminant() {
        return (mMatrix[0][0].multiply(mMatrix[1][1])).subtract(mMatrix[0][1].multiply(mMatrix[1][0]));
    }

    private Fraction methodOfTriangles() {
        Matrix mtx = generateAdditionalMatrix();
        Fraction res = new Fraction(0);
        for(int i = 0; i < mColumns; i++) {
            Fraction addPart = new Fraction(1);
            for(int k = 0; k < mColumns; k++) {
                addPart = addPart.multiply(mtx.mMatrix[k][k+i]);
            }
            res = res.add(addPart);
        }
        for(int i = 0; i < mColumns; i++) {
            Fraction subtractPart = new Fraction(1);
            for(int k = this.mColumns-1, j = this.mColumns-1; k < mtx.mColumns; k++, j--) {
                subtractPart = subtractPart.multiply(mtx.mMatrix[this.mRows - 1 - j][mtx.mColumns - 1 - k + i]);
            }
            res = res.subtract(subtractPart);
        }
        return res;
    }

    private Fraction methodForN() {
        Matrix mtx = new Matrix(this);
        Fraction determinant = new Fraction(1);
        for(int r = 1; r < mRows; r++) {
            for(int i = 0; i < r; i++) {
                Fraction coeff = mtx.mMatrix[r][i].divide(mtx.mMatrix[i][i]);
                if(coeff.equals(0)) {
                    boolean check = false;
                    for(int index = 0; index < mRows; index++) {
                        if(!mMatrix[r][i].equals(0)) {
                            check = true;
                        }
                    }
                    if(check == false) {
                        return new Fraction(0);
                    }
                }
                Fraction coefficient = coeff;
                boolean minus =  mtx.mMatrix[i][i].multiply(coefficient).doubleValue() > mtx.mMatrix[r][i].doubleValue();
                if(!minus) {
                    for(int c = 0; c < mColumns; c++) {
                        if(mtx.mMatrix[i][c].equals(0)) {
                            continue;
                        }
                        mtx.mMatrix[r][c] = mtx.mMatrix[r][c].subtract(mtx.mMatrix[i][c].multiply(coefficient));
                    }
                } else {
                    for(int c = 0; c < mColumns; c++) {
                        if (mtx.mMatrix[i][c].equals(0)) {
                            continue;
                        }
                        mtx.mMatrix[r][c] = mtx.mMatrix[r][c].add(mtx.mMatrix[i][c].multiply(coefficient));
                    }
                }
            }
            System.out.println("local determ = " + determinant);
            determinant = determinant.multiply(mtx.mMatrix[r][r]);
        }
        return determinant;
    }

    private Matrix generateAdditionalMatrix() {
        Matrix mtx = new Matrix(mRows, mColumns * 2 - 1);
        for(int c = 0; c < mColumns; c++) {
            for(int r = 0; r < mRows; r++) {
                mtx.mMatrix[r][c] = this.mMatrix[r][c];
            }
        }
        for(int c = mColumns; c < mColumns * 2 - 1; c++) {
            for(int r = 0; r < mRows; r++) {
                mtx.mMatrix[r][c] = mtx.mMatrix[r][c-mColumns];
            }
        }
        return mtx;
    }

    private Matrix calculateMatrixOfMinor() {
        Matrix matrixOfMinors = new Matrix(this.mRows, this.mColumns);
        for(int c = 0; c < mColumns; c++) {
            for( int r = 0; r < mRows; r++) {
                System.out.print("value for A " + c + " " + r + " ");
                matrixOfMinors.mMatrix[c][r] = this.calculateMinorValue(c, r);
            }
        }
        return matrixOfMinors;
    }

    private Fraction calculateMinorValue(int remColumn, int remRow) {
        Fraction minor = new Fraction(0);
        Matrix minorsSubmatrix = new Matrix(this.mRows-1, this.mColumns-1);
        for(int c = 0, mc = 0; c < this.mColumns; c++) {
            if(c == remColumn) {
                continue;
            }
            for (int r = 0, mr = 0; r < this.mRows; r++) {
                if(r == remRow)
                {
                    continue;
                }
                minorsSubmatrix.mMatrix[mc][mr] = this.mMatrix[c][r];
                mr++;
            }
            mc++;
        }
        try {
            minor = minorsSubmatrix.getDeterminant();
        } catch(Exception e) {
            System.out.println("Exception in getDeterminant-calculateMinorValue-calculateMatrixOfMinor-getReverseMatrix");
        }
        return minor;
    }

    private Matrix MatrixOfAlgebraicAddtitions() {
        Matrix maa = new Matrix(this);
        for(int c = 0; c < this.mColumns; c++) {
            for(int r = 0; r < this.mRows; r++) {
                if (c % 2 == 0) {
                    if (r % 2 != 0) {
                        maa.mMatrix[c][r] = maa.mMatrix[c][r].negate();
                    }
                } else {
                    if (r % 2 == 0) {
                        maa.mMatrix[c][r] = this.mMatrix[c][r].negate();
                    }
                }
            }
        }
        return maa;
    }

    public Matrix invertibleMatrix() {
        Matrix resMatrix;
        Fraction detResMatrix = new Fraction(0);
        try {
            detResMatrix = this.getDeterminant();
            System.out.println("determinant of A: " + detResMatrix);
            if(detResMatrix.equals(0)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("getDetterminant exception in reverse Matrix");
        }
        Matrix matrixOfMinors = calculateMatrixOfMinor();
        System.out.println("matrix of minors: ");
        matrixOfMinors.print();
        Matrix matrixOfAdditionals = matrixOfMinors.MatrixOfAlgebraicAddtitions();
        Matrix tMatrixOfAdditionals = matrixOfAdditionals.transposition();
        Fraction one = new Fraction(1);
        resMatrix = Matrix.multiply(tMatrixOfAdditionals, 1);
        return resMatrix;
    }
}
