package PolymonialRing;

import Rings.DoubleRing;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DoublePolynomialsTester {
    private PolynomialRing<Double> doubleRing = PolynomialRing.createRing(new DoubleRing());
    @Test
    void testDoublePolynomials() {
        // Test with two polynomials of different sizes
        Polynomial<Double> poly1 = Polynomial.from(Arrays.asList(1.0, 2.0, 3.0));
        Polynomial<Double> poly2 = Polynomial.from(Arrays.asList(4.0, 5.0));
        Polynomial<Double> productResult1 = doubleRing.product(poly1, poly2);
        assertEquals("4.0 + 13.0 + 22.0 + 15.0", productResult1.toString());

        // Generic Testing
        Polynomial<Double> poly3 = Polynomial.from(Arrays.asList(1.0, 2.0, 3.0));
        Polynomial<Double> poly4 = Polynomial.from(Arrays.asList(4.0, 5.0, 6.0));

        Polynomial<Double> sumResult = doubleRing.sum(poly3, poly4);
        Polynomial<Double> productResult = doubleRing.product(poly3, poly4);

        assertEquals("5.0 + 7.0 + 9.0", sumResult.toString());
        assertEquals("4.0 + 13.0 + 28.0 + 27.0 + 18.0", productResult.toString());

        // One polynomial being the zero polynomial
        Polynomial<Double> zeroPoly = doubleRing.zero();
        Polynomial<Double> productResult2 = doubleRing.product(zeroPoly, poly1);
        assertEquals("0.0 + 0.0", productResult2.toString());

        // Both polynomials being the zero polynomial
        Polynomial<Double> productResult3 = doubleRing.product(zeroPoly, zeroPoly);
        assertEquals("", productResult3.toString());

        // Polynomial multiplied by identity polynomial
        Polynomial<Double> identityPoly = doubleRing.identity();
        Polynomial<Double> productResult4 = doubleRing.product(poly1, identityPoly);
        assertEquals("1.0 + 2.0 + 3.0", productResult4.toString());}
}
