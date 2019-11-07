public class Main {
    static Matrix mtx1;
    static Matrix mtx2;
    public static void main(String[] args) {
        mtx1 = new Matrix(3,3);
        mtx2 = new Matrix(3,3);
        mtx1.set("matrix1.txt");
        mtx2.set("matrix2.txt");

        System.out.println("Matrix A:");
        mtx1.print();
        System.out.println("Matrix B:");
        mtx2.print();
    }
}

