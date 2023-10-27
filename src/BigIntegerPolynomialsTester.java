import PolymonialRing.Polynomial;
import PolymonialRing.PolynomialRing;
import Rings.BigIntegerRing;
import org.junit.Test;
import java.math.BigInteger;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class BigIntegerPolynomialsTester {
    private PolynomialRing<BigInteger> bigIntegerRing = PolynomialRing.createRing(new BigIntegerRing());

    @Test
    public void testBigIntegerPolynomials() {

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

    @Test(expected = NullPointerException.class)
    public void testBigIntegerPolynomialsNull() {  // Polynomial null
        Polynomial<BigInteger> poly5 = null;
        Polynomial<BigInteger> identityPoly1 = bigIntegerRing.identity();
        Polynomial<BigInteger> productResult5 = bigIntegerRing.product(poly5, identityPoly1);
        Polynomial<BigInteger> sumResult1 = bigIntegerRing.sum(poly5, identityPoly1);
        assertEquals(null, productResult5);
        assertEquals(null, sumResult1);
    }

    @Test
    public void testListIterator() {
        List<Integer> coefficients = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial = Polynomial.from(coefficients);

        List<Integer> result = new ArrayList<>();
        ListIterator<Integer> listIterator = polynomial.listIterator(0);

        while (listIterator.hasNext()) {
            result.add(listIterator.next());
        }
        assertEquals(coefficients, result);
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorOutOfBounds() {
        List<Integer> coefficients = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial = Polynomial.from(coefficients);

        ListIterator<Integer> listIterator = polynomial.listIterator(coefficients.size());

        // This should throw NoSuchElementException
        listIterator.next();
    }

    @Test
    public void testIterator() {
        List<BigInteger> coefficients = Arrays.asList(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));
        Polynomial<BigInteger> polynomial = Polynomial.from(coefficients);

        List<BigInteger> result = new ArrayList<>();
        Iterator<BigInteger> iterator = polynomial.iterator();

        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        assertEquals(coefficients, result);
    }
}
