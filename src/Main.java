public class Main {
    static Matrix A;
    static Matrix B;
    static Matrix C;
    static Matrix D;
    static Matrix E;
    public static void main(String[] args) {
        System.out.println("Matrix A:");
        A = new Matrix(3,3);
        A.set("matrix_square_1.txt");
        A.print();

        System.out.println("Matrix B:");
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
    }
}

