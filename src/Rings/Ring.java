package Rings;

public interface Ring<T> {
    //Object z = null;
    T zero();
    T identity();
    T sum(T x, T y);
    T product(T x, T y);
    T negate(T x);
}
