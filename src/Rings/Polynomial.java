package Rings;

import java.util.*;
import java.util.stream.Collectors;

public final class Polynomial<T> {
    private final List<T> coefficients;
    public Polynomial(List<T> coefficients) {
        this.coefficients = coefficients;
    }

    public static final <S> Polynomial<S> from(List<S> coefficients) {
        return new Polynomial<>(List.copyOf(coefficients));
    }

    public List<T> getList(){
        return coefficients.stream().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return coefficients.toString();
    }

    public Polynomial<T> plus( Polynomial<T> other, Ring<T> ring){
        if(other == null || ring == null){
            throw new NullPointerException();
        }

        List<T> resultCoefficients = new ArrayList<>();

        int maxSize = Math.max(coefficients.size(), other.coefficients.size());

        for (int i = 0; i < maxSize; i++) {
            T coeff1 = (i < coefficients.size()) ? coefficients.get(i) : ring.zero();
            T coeff2 = (i < other.coefficients.size()) ? other.coefficients.get(i) : ring.zero();
            T sum = ring.sum(coeff1, coeff2);
            resultCoefficients.add(sum);
        }

        return new Polynomial<>(resultCoefficients);
    }
    public Polynomial<T> times( Polynomial<T> other, Ring<T> ring){
        List<T> resultCoefficients = new ArrayList<>(Collections.nCopies(coefficients.size() + other.coefficients.size() - 1, ring.zero()));

        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < other.coefficients.size(); j++) {
                T product = ring.product(coefficients.get(i), other.coefficients.get(j));
                T currentSum = resultCoefficients.get(i + j);
                T newSum = ring.sum(currentSum, product);
                resultCoefficients.set(i + j, newSum);
            }
        }
        return new Polynomial<>(resultCoefficients);
    }
//
//    public Polynomial<T> negate(Ring<T> ring) {
//        Objects.requireNonNull(ring);
//
//        List<T> negatedCoefficients = coefficients.stream()
//                .map(ring::negate) // Negate each coefficient using the ring's negate method
//                .collect(Collectors.toList());
//
//        return new Polynomial<>(negatedCoefficients);
//    }

}
