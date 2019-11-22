public class Main {
    static Matrix A;
    static Matrix B;
    static Matrix C;
    static Matrix D;
    static Matrix E;

    public static void main(String[] args) {
        System.out.println("Matrix A:");
        A = new Matrix(4, 4);
        A.set("matrix_square_1.txt");
        A.print();
        try {
            System.out.println(A.getDeterminant());
        } catch (Exception e) {
            System.out.println("zhepa");
        }
        //try {
        //    B = A.invertibleMatrix();
        //    System.out.println("B = A^-1:");
        //    B.print();
        //    C = Matrix.multiplyMatrises(A,B);
        //    System.out.println("C = A x B:");
        //    C.print();
        //} catch (Exception e) {}

    }
}

