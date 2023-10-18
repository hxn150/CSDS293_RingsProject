package PolymonialRing;
import Rings.Ring;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Polynomial<T> implements Iterable<T>{
    private final List<T> coefficients;
    private Polynomial(List<T> coefficients) {
        Objects.requireNonNull(coefficients);
        this.coefficients = coefficients;
    }
    public static final <S> Polynomial<S> from(List<S> coefficients) {
        Objects.requireNonNull(coefficients);
        List<S> copy = Collections.unmodifiableList(new ArrayList<>(coefficients));
        return new Polynomial<>(copy);
    }
    public List<T> getList(){
        return coefficients.stream().collect(Collectors.toList());
    }

    public Iterator<T> iterator() {
        return getList().iterator();
    }
    public ListIterator<T> listIterator(int i) {
        return getList().listIterator(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (T coefficient : coefficients) {
            if (!first) {
                sb.append(" + ");
            }
            sb.append(coefficient);
            first = false;
        }
        return sb.toString();
    }

    public Polynomial<T> plus(Polynomial<T> other, Ring<T> ring) {
        int maxSize = Math.max(coefficients.size(), other.coefficients.size());

        List<T> resultCoefficients = IntStream.range(0, maxSize)
                .mapToObj(i -> {
                    T thisCoefficient = (i < coefficients.size()) ? coefficients.get(i) : ring.zero();
                    T otherCoefficient = (i < other.coefficients.size()) ? other.coefficients.get(i) : ring.zero();
                    return ring.sum(thisCoefficient, otherCoefficient);
                })
                .collect(Collectors.toList());
        return new Polynomial<>(resultCoefficients);
    }

    public Polynomial<T> times(Polynomial<T> other, Ring<T> ring) {
        int totalSize = coefficients.size() + other.coefficients.size() - 1;

        List<T> resultCoefficients = IntStream.range(0, totalSize)
                .mapToObj(i -> IntStream.range(0, coefficients.size())
                        .mapToObj(j -> {
                            int currentInd = i - j;
                            return (currentInd >= 0 && currentInd < other.coefficients.size())
                                    ? ring.product(coefficients.get(j), other.coefficients.get(currentInd))
                                    : ring.zero();
                        })
                        .reduce(ring.zero(), ring::sum))
                .collect(Collectors.toList());

        return new Polynomial<>(resultCoefficients);
    }
}
