package PolymonialRing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import PolymonialRing.Polynomial;
import PolymonialRing.PolynomialRing;
import Rings.IntegerRing;
import Rings.Ring;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerPolynomialsTester {
    Ring<Integer> innerRing = new IntegerRing();
    PolynomialRing<IntegerRing> innerPolynomialRing = PolynomialRing.createRing((Ring) innerRing);
    private PolynomialRing<Polynomial<IntegerRing>> polynomialRing = PolynomialRing.createRing(innerPolynomialRing);

    @Test
    void testZeroPolynomial() {
        Polynomial<Polynomial<IntegerRing>> zeroPoly = polynomialRing.zero();
        assertEquals("", zeroPoly.toString());
    }

    @Test
    void testIdentityPolynomial() {
        Polynomial<Polynomial<IntegerRing>> identityPoly = polynomialRing.identity();
        assertEquals("1", identityPoly.toString());
    }
}
