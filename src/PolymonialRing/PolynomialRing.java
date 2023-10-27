package PolymonialRing;

import Rings.IntegerRing;
import Rings.Ring;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PolynomialRing<T> implements Ring<Polynomial<T>> {
    private final Ring<T> ring;

    PolynomialRing(Ring<T> ring) {
        Objects.requireNonNull(ring);
        this.ring = ring;
    }

    public static <S> PolynomialRing<S> createRing(Ring<S> ring) {
        Objects.requireNonNull(ring);
        return new PolynomialRing<>(ring);
    }

    @Override
    public Polynomial<T> zero() {
        return Polynomial.from(Collections.emptyList());
    }

    @Override
    public Polynomial<T> identity() {
        return Polynomial.from(Collections.singletonList(ring.identity()));
    }

    @Override
    public Polynomial<T> sum(Polynomial<T> x, Polynomial<T> y) {
        Objects.requireNonNull(x);
        Objects.requireNonNull(y);
        return x.plus(y,ring);
    }

    @Override
    public Polynomial<T> product(Polynomial<T> x, Polynomial<T> y) {
        Objects.requireNonNull(x);
        Objects.requireNonNull(y);
        return x.times(y, ring);
    }

    @Override
    public Polynomial<T> negate(Polynomial<T> x) {
        Objects.requireNonNull(x);

        List<T> negatedCoefficients = x.getList().stream()
                .map(ring::negate)
                .collect(Collectors.toList());

        return (Polynomial<T>) negatedCoefficients;
    }
}
