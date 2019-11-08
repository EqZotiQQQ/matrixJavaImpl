public class Main {
    static Matrix A;
    static Matrix B;
    static Matrix C;
    public static void main(String[] args) {
        A = new Matrix(3,3);
        B = new Matrix(3,3);
        A.set("matrix_square_1.txt");
        B.set("matrix_square_2.txt");
        try {
            C = Matrix.add(A, B);
        } catch(Exception e) {
            System.out.println("ex");
        }
        C.print();

    }
}

