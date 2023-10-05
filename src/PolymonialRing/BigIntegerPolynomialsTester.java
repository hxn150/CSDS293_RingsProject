package PolymonialRing;

import Rings.BigIntegerRing;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigIntegerPolynomialsTester {
    private PolynomialRing<BigInteger> bigIntegerRing = PolynomialRing.createRing(new BigIntegerRing());

    @Test
    void testBigIntegerPolynomials() {

        // Test with two polynomials of different sizes
        Polynomial<BigInteger> poly1 = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)
        ));
        Polynomial<BigInteger> poly2 = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(4), BigInteger.valueOf(5)
        ));
        Polynomial<BigInteger> productResult1 = bigIntegerRing.product(poly1, poly2);
        assertEquals("4 + 13 + 22 + 15", productResult1.toString());

        // Generic Testing
        Polynomial<BigInteger> poly3 = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)
        ));
        Polynomial<BigInteger> poly4 = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(4), BigInteger.valueOf(5), BigInteger.valueOf(6)
        ));

        Polynomial<BigInteger> sumResult = bigIntegerRing.sum(poly3, poly4);
        Polynomial<BigInteger> productResult = bigIntegerRing.product(poly3, poly4);

        assertEquals("5 + 7 + 9", sumResult.toString());
        assertEquals("4 + 13 + 28 + 27 + 18", productResult.toString());

        // One polynomial being the zero polynomial
        Polynomial<BigInteger> zeroPoly = bigIntegerRing.zero();
        Polynomial<BigInteger> productResult2 = bigIntegerRing.product(zeroPoly, poly1);
        assertEquals("0 + 0", productResult2.toString());

        // Both polynomials being the zero polynomial
        Polynomial<BigInteger> productResult3 = bigIntegerRing.product(zeroPoly, zeroPoly);
        assertEquals("", productResult3.toString());

        // Polynomial multiplied by identity polynomial
        Polynomial<BigInteger> identityPoly = bigIntegerRing.identity();
        Polynomial<BigInteger> productResult4 = bigIntegerRing.product(poly1, identityPoly);
        assertEquals("1 + 2 + 3", productResult4.toString());
    }
}
