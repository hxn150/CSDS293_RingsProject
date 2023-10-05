import Matrix.MatrixMap;
import Rings.IntegerRing;
import Indexes.Indexes;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the dimensions of the first matrix (rows columns):");
//        int rows1 = scanner.nextInt();
//        int cols1 = scanner.nextInt();
//        System.out.println("Enter the dimensions of the second matrix (rows columns):");
//        int rows2 = scanner.nextInt();
//        int cols2 = scanner.nextInt();
//
//        if (cols1 != rows2) {
//            System.out.println("Matrix sizes are not compatible for multiplication.");
//            return;
//        }
//
//        System.out.println("Enter elements for the first matrix:");
//        MatrixMap<Integer> matrix1 = readMatrix(rows1, cols1, scanner);
//        System.out.println("Enter elements for the second matrix:");
//        MatrixMap<Integer> matrix2 = readMatrix(rows2, cols2, scanner);
//
//        System.out.println("Choose operation:");
//        System.out.println("1. Matrix Addition");
//        System.out.println("2. Matrix Multiplication");
//        int operationChoice = scanner.nextInt();
//
//        if (operationChoice == 1) {
//            // Perform matrix addition
//          MatrixMap<Integer> result = matrix1.plus(matrix2, (BinaryOperator<Integer>) new IntegerRing());
//          System.out.println("Matrix Addition Result:");
//          System.out.println(result.toString());
//        } else if (operationChoice == 2) {
//            // Perform matrix multiplication
//            MatrixMap<Integer> result = matrix1.times(matrix2, new IntegerRing());
//            System.out.println("Matrix Multiplication Result:");
//            System.out.println(result.toString());
//        } else {
//            System.out.println("Invalid choice. Please choose 1 or 2.");
//        }
//
//        scanner.close();
//    }
//
//    private static MatrixMap<Integer> readMatrix(int rows, int cols, Scanner scanner) {
//        Map<Indexes, Integer> matrixData = IntStream.range(0, rows)
//                .boxed()
//                .flatMap(i -> IntStream.range(0, cols)
//                        .boxed()
//                        .map(j -> new Indexes(i, j))
//                        .collect(Collectors.toList()
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        return new MatrixMap<Integer>(matrixData);
//    }
}

