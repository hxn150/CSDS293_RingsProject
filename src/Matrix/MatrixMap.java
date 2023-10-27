//package Matrix;
//
//import Indexes.Indexes;
//import Rings.Ring;
//
//import java.util.Map;
//import java.util.Objects;
//import java.util.function.BinaryOperator;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public final class MatrixMap<T> {
//
//    private final Map<Indexes, T> matrix;
//
//    /** Constructor **/
//    MatrixMap(Map<Indexes, T> matrix) {
//        this.matrix = matrix;
//    }
//
//    /** Matrix size **/
//    public Indexes size(){
//        Objects.requireNonNull(matrix);
//        Indexes firstIndex = matrix.keySet().iterator().next();
//        return new Indexes(firstIndex.row() + 1, firstIndex.column() + 1);
//    }
//
//    public String toString(){
//        return matrix.entrySet().stream()
//                .map(entry -> "Indexes[row=" + entry.getKey().row() + ", column=" + entry.getKey().column() + "] = " + entry.getValue())
//                .collect(Collectors.joining("\n"));
//    }
//
//    /** Value Method **/
//    public T value(Indexes indexes){
//        Objects.requireNonNull(indexes);
//        return matrix.get(indexes);
//    }
//    public T value(int rows, int columns){
//        Objects.requireNonNull(rows);
//        Objects.requireNonNull(columns);
//        return value(new Indexes(rows, columns));
//    }
//
//    public static <S> S value(MatrixMap<S> matrix, Indexes indexes) {
//        Objects.requireNonNull(matrix);
//        Objects.requireNonNull(indexes);
//        return matrix.value(indexes);
//    }
//
//    public static <S> MatrixMap<S> instance(int rows, int columns, Function<Indexes,S> valueMapper){
//        Objects.requireNonNull(rows);
//        Objects.requireNonNull(columns);
//        Objects.requireNonNull(valueMapper);
//
//        InvalidLengthException.requireNonEmpty(InvalidLengthException.Cause.ROW, rows);
//        InvalidLengthException.requireNonEmpty(InvalidLengthException.Cause.COLUMN, columns);
//
//        Map<Indexes, S> matrix = IntStream.range(0, rows)
//                .boxed()
//                .flatMap(i -> IntStream.range(0, columns)
//                        .mapToObj(j -> new Indexes(i, j)))
//                .collect(Collectors.toMap(Function.identity(), valueMapper));
//        return new MatrixMap<S>(matrix);
//    }
//
//    public static <S> MatrixMap<S> instance(Indexes size, Function<Indexes, S> valueMapper){
//        Objects.requireNonNull(size);
//        Objects.requireNonNull(valueMapper);
//
//        int rows = size.row();
//        int columns = size.column();
//
//        if(rows <= 0 || columns <= 0){
//            throw new InvalidLengthException(InvalidLengthException.Cause.ROW, rows);
//        }
//        return instance(rows, columns, valueMapper);
//    }
//
//    public static <S> MatrixMap<S> constant(int size, S value) {
//        Objects.requireNonNull(size);
//        Objects.requireNonNull(value);
//
//        if(size <= 0){
//            throw new InvalidLengthException(InvalidLengthException.Cause.ROW, size);
//        }
//        return instance(new Indexes(size, size), indexes -> value);
//    }
//
//    public static <S> MatrixMap<S> identity(int size, S zero, S identity) {
//        Objects.requireNonNull(size);
//        Objects.requireNonNull(zero);
//        Objects.requireNonNull(identity);
//
//        if(size <= 0){
//            throw new InvalidLengthException(InvalidLengthException.Cause.ROW, size);
//        }
//
//        return instance(new Indexes(size, size), indexes -> indexes.areDiagonal() ? identity : zero);
//    }
//
//    public static <S> MatrixMap<S> from(S[][] matrix){
//        Objects.requireNonNull(matrix);
//        int rows = matrix.length;
//        int columns = matrix.length;
//
//        return instance(rows, columns, indexes -> matrix[indexes.row()][indexes.column()]);
//    }
//
//    public MatrixMap<T> plus(MatrixMap<T> other, BinaryOperator<T> plus){
//        NonSquareException.requireDiagonal(this.size());
//        NonSquareException.requireDiagonal(other.size());
//        InconsistentSizeException.requireMatchingSize(this, other);
//
//        Map<Indexes, T> resultMatrix = matrix.entrySet()
//                .stream()
//                .collect(Collectors.toMap(Map.Entry :: getKey, entry -> plus.apply(entry.getValue(), other.matrix.get(entry.getKey()))
//                ));
//        return new MatrixMap<T>(resultMatrix);
//    }
//
//    public MatrixMap<T> times(MatrixMap<T> other, Ring<T> ring) {
//        NonSquareException.requireDiagonal(this.size());
//        NonSquareException.requireDiagonal(other.size());
//        InconsistentSizeException.requireMatchingSize(this, other);
//        Indexes in = new Indexes(size().row() +1, size().column()+1);
//
//        return MatrixMap.instance(in, (indexes) -> calculateMatrixElement(indexes.row(), indexes.column(), other, ring));
//    }
//
//    private T calculateMatrixElement(int i, int j, MatrixMap<T> other, Ring<T> ring) {
//        int n = size().row();
//        T element = IntStream.range(0, n+1)
//                .mapToObj(k -> ring.product(value(i, k), other.value(k, j)))
//                .reduce(ring.zero(), ring::sum);
//        System.out.println(n);
//        return element;
//    }
//
//    private void checkIfSquare() {
//        if (size().row() != size().column()) {
//            throw new NonSquareException(size());
//        }
//    }
//
//    /** Nested InvalidLengthException Class **/
//    public static class InvalidLengthException extends IllegalArgumentException{
//        private static final long serialVersionUID = 1;
//        public enum Cause{
//            ROW, COLUMN
//        }
//        private final Cause cause;
//        private final int length;
//        public InvalidLengthException(Cause cause, int length){
//            super("Invalid length for " + cause + " with length: " + length);
//            this.cause = cause;
//            this.length = length;
//        }
//        public Cause getCauseType(){
//            return this.cause;
//        }
//
//        public int getLength(){
//            return this.length;
//        }
//        public static int requireNonEmpty(Cause cause, int length) {
//            if(invalidLength(length)){
//                throw new IllegalArgumentException(new InvalidLengthException(cause, length));
//            }
//            return length;
//        }
//
//        /** Helper Method **/
//        private static boolean invalidLength(int val) {
//            return val <= 0;
//        }
//    }
//
//    /** Nested InconsistentSizeException Class **/
//    public static class InconsistentSizeException extends IllegalArgumentException{
//        private final Indexes thisIndexes;
//        private final Indexes otherIndexes;
//        public InconsistentSizeException(Indexes thisIndexes, Indexes otherIndexes) {
//            super("Mismatched matrix size.");
//            this.thisIndexes = thisIndexes;
//            this.otherIndexes = otherIndexes;
//        }
//        public Indexes getThisIndexes(){
//            return this.thisIndexes;
//        }
//        public Indexes getOtherIndexes(){
//            return this.otherIndexes;
//        }
//        public static <T> Indexes requireMatchingSize(MatrixMap<T> thisMatrix, MatrixMap<T> otherMatrix){
//            Objects.requireNonNull(thisMatrix);
//            Objects.requireNonNull(otherMatrix);
//
//            Indexes thisSize = thisMatrix.size();
//            Indexes otherSize = otherMatrix.size();
//
//            if(!thisSize.equals(otherSize)){
//                throw new InconsistentSizeException(thisSize,otherSize);
//            }
//            return thisSize;
//        }
//    }
//
//    /** Nested NonSquareException Class **/
//    public static class NonSquareException extends IllegalStateException{
//        private final Indexes indexes;
//
//        public NonSquareException(Indexes indexes) {
//            super("Indexes are not on the diagonal");
//            this.indexes = indexes;
//        }
//
//        public Indexes getIndexes(){
//            return this.indexes;
//        }
//
//        public static Indexes requireDiagonal(Indexes indexes){
//            if(!indexes.areDiagonal()){
//                throw new NonSquareException(indexes);
//            }
//            return indexes;
//        }
//    }
//
//}
