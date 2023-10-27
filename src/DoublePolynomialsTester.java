import PolymonialRing.Polynomial;
import PolymonialRing.PolynomialRing;
import org.junit.Test;
import Rings.DoubleRing;


import java.util.*;

import static org.junit.Assert.assertEquals;

public class DoublePolynomialsTester {
    private PolynomialRing<Double> doubleRing = PolynomialRing.createRing(new DoubleRing());


    /***
     * Test sum() and product() method for normal param
     */
    @Test(expected = NullPointerException.class)
    public void testDoublePolynomials() {
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
        assertEquals("1.0 + 2.0 + 3.0", productResult4.toString());

    }

    /***
     * Test sum() and product() method for null param
     */
    @Test(expected = NullPointerException.class)
    public void testDoublePolynomialsNull() {
        // Polynomial null
        Polynomial<Double> poly5 = null;
        Polynomial<Double> identityPoly1 = doubleRing.identity();
        Polynomial<Double> productResult5 = doubleRing.product(poly5, identityPoly1);
        Polynomial<Double> sumResult1 = doubleRing.sum(poly5, identityPoly1);
        assertEquals(null, productResult5);
        assertEquals(null, sumResult1);
    }

    /***
     * Test negate() method
     */
    @Test(expected = NullPointerException.class)
    public void testDoublePolynomialsNegate() {
        //Polynomial negate
        Polynomial<Double> poly6 = Polynomial.from(Arrays.asList(4.0, 5.0, 6.0));
        Polynomial<Double> negateResult = doubleRing.negate(poly6);
        Polynomial<Double> negateNullResult = doubleRing.negate(null);
        assertEquals("-4 + -5 + -6", negateResult.toString());
        assertEquals(null, negateNullResult.toString());

        List<Integer> coefficients = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial = Polynomial.from(coefficients);
        List<Integer> result = polynomial.getList();
        assertEquals(coefficients, result);

        List<Integer> coefficients1 = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial1 = Polynomial.from(coefficients1);
        List<Integer> result1 = new ArrayList<>();
        Iterator<Integer> iterator = polynomial1.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        assertEquals(coefficients1, result1);

        List<Integer> coefficients2 = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial2 = Polynomial.from(coefficients2);

        List<Integer> result2 = new ArrayList<>();
        ListIterator<Integer> listIterator = polynomial2.listIterator(0);

        while (listIterator.hasNext()) {
            result.add(listIterator.next());
        }
        assertEquals(coefficients2, result2);

        List<Integer> coefficients3 = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial3 = Polynomial.from(coefficients);

        ListIterator<Integer> listIterator2 = polynomial3.listIterator(coefficients3.size());

        // This should throw NoSuchElementException
        listIterator2.next();

    }

    /***
     * Test iterator() method
     */
    @Test
    public void testIterator() {
        List<Double> coefficients = Arrays.asList(1.0, 2.0, 3.0);
        Polynomial<Double> polynomial = Polynomial.from(coefficients);

        List<Double> result = new ArrayList<>();
        Iterator<Double> iterator = polynomial.iterator();

        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        assertEquals(coefficients, result);
    }
}
