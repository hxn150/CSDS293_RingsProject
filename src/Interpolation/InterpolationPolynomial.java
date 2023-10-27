package Interpolation;

import Rings.Polynomial;
import Rings.Ring;

import java.util.List;
import java.util.Objects;

public class InterpolationPolynomial<T> {

    /** Psuedo Code:
     *
     * Function interpolate(dataPoints)
     * Check if dataPoints are valid
     * p ← an identity polynomial
     * For each xi in dataPoints
     * basisPolynomial ← is a Polynomial from x
     * p ← p. product (basisPolynomial)
     * End Loop
     * Return p
     * End Function
     *
     */

    public static <T> Polynomial<T> interpolate(List<T> dataPoints, Ring<T> ring) {
        Objects.requireNonNull(dataPoints);
        Objects.requireNonNull(ring);
        Polynomial<T> identityPoly = Polynomial.from(List.of(ring.identity()));

        for (T xi : dataPoints) { //1
            Polynomial<T> basisPolynomial = Polynomial.from(List.of(ring.identity(),ring.negate(xi))); //2
            identityPoly = identityPoly.times(basisPolynomial, ring); //3
        }
        return identityPoly;
    }
}

