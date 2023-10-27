//package Indexes;
//
//import java.util.Objects;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public record Indexes(int row, int column) implements Comparable<Indexes> {
//
//    @Override
//    public int compareTo(Indexes other) {
//        Objects.requireNonNull(other);
//        return (this.row != other.row) ? Integer.compare(this.row, other.row) : Integer.compare(this.column, other.column);
//    }
//
//    /**
//     * Value Method
//     **/
//    public <S> S value(S[][] matrix) {
//        Objects.requireNonNull(matrix);
//        if (lengthOutOfBoundCheck(row, column)) throw new IndexOutOfBoundsException();
//        return matrix[row][column];
//    }
//
//
//    /**
//     * areDiagonal Method
//     **/
//    public boolean areDiagonal() {
//        return this.row == this.column;
//    }
//
//
//    /**
//     * Stream Method: Indexes from, Indexes to
//     **/
//    public static Stream<Indexes> stream(Indexes from, Indexes to) {
//        Objects.requireNonNull(from);
//        Objects.requireNonNull(to);
//
//        return IntStream.rangeClosed(from.row(), to.row())
//                .boxed()
//                .flatMap(row ->
//                        IntStream.rangeClosed(from.column(), to.column())
//                                .mapToObj(column -> new Indexes(row, column))
//                );
//    }
//
//    /**
//     * Stream Method: Indexes size
//     **/
//    public static Stream<Indexes> stream(Indexes size) {
//        Objects.requireNonNull(size);
//        if (lengthOutOfBoundCheck(size.row(), size.column())) throw new IndexOutOfBoundsException();
//        return stream(new Indexes(0, 0), size);
//    }
//
//    /**
//     * Stream Method: int rows, int columns
//     **/
//    public static Stream<Indexes> stream(int rows, int columns) {
//        Objects.requireNonNull(rows);
//        Objects.requireNonNull(columns);
//        if (lengthOutOfBoundCheck(rows, columns)) throw new IndexOutOfBoundsException();
//        return stream(new Indexes(0, 0), new Indexes(rows, columns));
//    }
//
//    /**
//     * Helper Method: length out of bound check
//     **/
//    private static boolean lengthOutOfBoundCheck(int row, int col) {
//        return (row < 0 || col < 0) ? true : false;
//    }
//
//}
//
