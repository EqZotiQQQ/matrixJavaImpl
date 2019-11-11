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
        A.print();
        A.multiply(5);
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

        D = new Matrix(4,2);
        E = new Matrix(2, 4);
        D.set("not_square_matrix_1.txt");

        System.out.println("D:");
        D.print();
        System.out.println("D:");
        D.multiply(5);
        D.print();
        E.set("not_square_matrix_2.txt");
        System.out.println("D:");
        D.print();
        System.out.println("E:");
        E.print();
        Matrix F = null;
        try {
            F = Matrix.multiplyMatrixes(D, E);
            System.out.println("F:");
            F.print();
        } catch (Exception e) {
            System.out.println("multiplyMatrixes exception");
        }
    }
}

