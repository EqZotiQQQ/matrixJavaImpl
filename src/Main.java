public class Main {
    public static void main(String[] args) {
        Matrix mtx = new Matrix(3,3);
        //  mtx.print();
        mtx.set();
        mtx.print();
        Matrix mtx2 = new Matrix(mtx);
        mtx2.print();
        //mtx.multiply(5);
       // mtx.print();
        //Matrix mtx2 = new Matrix(3,3);
        //mtx2.set();
        //mtx2.print();
        //Matrix res = Matrix.multiplyMatrixes(mtx, mtx2);
        //res.print();
    }
}

