public class Main {
    static Matrix A;
    static Matrix B;
    static Matrix C;
    static Matrix D;
    static Matrix E;
    public static void main(String[] args) {
        System.out.println("Matrix A:");
        A = new Matrix(4,4);
        A.set("matrix_square_1.txt");
        A.printRound();
        //String str = A.toString();
        //System.out.println(str);
        /*System.out.println("Matrix B:");
        B = new Matrix(3,3);
        B.set("matrix_square_2.txt");
        B.print();

        System.out.println("Matrix C:");
        C = new Matrix(2,4);
        C.set("not_square_matrix_1.txt");
        C.print();

        System.out.println("Matrix D:");
        D = new Matrix(4,2);
        D.set("not_square_matrix_2.txt");
        D.print();

        System.out.println("Matrix E:");
        E = new Matrix(2,4);
        E.set("matrix_for_transponation.txt");
        E.print();

        System.out.println("A*5=");
        A.multiply(5);
        A.print();

        System.out.println("E*5=");
        E.multiply(5);
        E.print();

        System.out.println("D*5=");
        D.multiply(5);
        D.print();

        System.out.println("Transponation A:");
        Matrix T_A = A.transposition();
        T_A.print();

        System.out.println("Transponation E:");
        Matrix T_E = E.transposition();
        T_E.print();

        try {
            System.out.println("Multiplication AxB:");
            Matrix AB = Matrix.multiplyMatrixes(A, B);
            AB.print();
        } catch(Exception e) {
            System.out.println("Multiply Exception");
        }

        try {
            System.out.println("Multiplication ExD:");
            Matrix ED = Matrix.multiplyMatrixes(E, D);
            ED.print();
        } catch(Exception e) {
            System.out.println("Multiply Exception");
        }

        try {
            System.out.println("Multiplication AxD:");
            Matrix ED = Matrix.multiplyMatrixes(A, D);
            ED.print();
        } catch(Exception e) {
            System.out.println("Multiply Exception AxD");
        }

        try {
            System.out.print("Determinant of A = ");
            int det = A.getDeterminant();
            System.out.println(det);
        } catch (Exception e) {
            System.out.println("Determinant Exception");
        }*/
        System.out.println("Revers matrix for A:");
        Matrix G = A.invertibleMatrix();
        G.print();
        try {
          Matrix H = Matrix.multiplyMatrixes(A, G);
          System.out.println("Matrix H:");
          H.printRound();
        } catch (Exception e) {

        }
    }
}

