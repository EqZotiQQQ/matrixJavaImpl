public class Main {
    static Matrix A;
    static Matrix B;
    static Matrix C;
    static Matrix D;
    static Matrix E;
    public static void main(String[] args) {
        A = new Matrix(3,3);
        B = new Matrix(3,3);
        A.set("matrix_square_1.txt");
        B.set("matrix_square_2.txt");
        try {
            C = Matrix.add(A, B);
        } catch(Exception e) {
            System.out.println("add exception");
        }
        C.print();
        System.out.println(C.isMatrixOf(0));
        try {
            A.getDeterminant();
        } catch(Exception e) {
            System.out.println("getDeterminant exception");
        }

        D = new Matrix(2,4);
        E = new Matrix(4, 2);
        D.set("not_square_matrix_1.txt");
        E.set("not_square_matrix_2.txt");
        System.out.println("D:");
        D.print();
        System.out.println("E:");
        E.print();
        Matrix F = null;
        try {
            F = Matrix.multiplyMatrixes(D, E);
        } catch (Exception e) {
            System.out.println("multiplyMatrixes exception");
        }
        System.out.println("F:");
        F.print();
    }
}

