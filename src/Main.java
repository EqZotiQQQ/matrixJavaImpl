public class Main {
    static Matrix mtx;
    public static void main(String[] args) {
        mtx = new Matrix(3,3);


        mtx.set("matrixes.txt");
        mtx.print();



        //multiplyTst(mtx);

    }

    public static void setMatrixFromFileTst(Matrix mtx) {

    }

    public static void multiplyTst( Matrix mtx) {
        mtx.multiply(5);
        System.out.println("Matrix A * 5 = ");
        mtx.print();
        Matrix mtx2 = new Matrix(3,3);
        mtx2.set();
        Matrix res = Matrix.multiplyMatrixes(mtx, mtx2);
        System.out.println("Matrix A * Matrix B = ");
        res.print();
    }
}

