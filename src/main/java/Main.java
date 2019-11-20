public class Main {
    static Matrix A;
    static Matrix B;
    static Matrix C;
    static Matrix D;
    static Matrix E;

    public static void main(String[] args) {
        System.out.println("Matrix A:");
        A = new Matrix(5, 5);
        A.set("matrix_square_1.txt");
        A.printRound();
        try {
            double x = A.getDeterminant();
            System.out.println("det = " + x);
        } catch (Exception e) {

        }

    }
}

