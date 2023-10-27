import PolymonialRing.Polynomial;
import PolymonialRing.PolynomialRing;
import Rings.DoubleRing;
import Rings.IntegerRing;
import Rings.Ring;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class IntegerPolynomialsTester {
    Ring<Integer> innerRing = new IntegerRing();
    PolynomialRing<IntegerRing> innerPolynomialRing = PolynomialRing.createRing((Ring) innerRing);
    private PolynomialRing<Polynomial<IntegerRing>> polynomialRing = PolynomialRing.createRing(innerPolynomialRing);

    /***
     * Test zero() method for normal param
     */
    @Test
    public void testZeroPolynomial() {
        Polynomial<Polynomial<IntegerRing>> zeroPoly = polynomialRing.zero();
        assertEquals("", zeroPoly.toString());
    }

    /***
     * Test identity() method for normal param
     */
    @Test
    public void testIdentityPolynomial() {
        Polynomial<Polynomial<IntegerRing>> identityPoly = polynomialRing.identity();
        assertEquals("1", identityPoly.toString());
    }

    /***
     * Test listIterator() method for normal param
     */
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

    /***
     * Test listIterator() method for out of bounds param
     */
    @Test(expected = NoSuchElementException.class)
    public void testListIteratorOutOfBounds() {
        List<Integer> coefficients = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial = Polynomial.from(coefficients);

        ListIterator<Integer> listIterator = polynomial.listIterator(coefficients.size());

        // This should throw NoSuchElementException
        listIterator.next();
    }

    /***
     * Test iterator() method for normal param
     */
    @Test
    public void testIterator() {
        List<Integer> coefficients = Arrays.asList(1, 2, 3);
        Polynomial<Integer> polynomial = Polynomial.from(coefficients);

        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = polynomial.iterator();

        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        assertEquals(coefficients, result);
    }

    /***
     * Test plus() method for same sized param
     */
    @Test
    public void testPlusSameSize() {
        Polynomial<Integer> p1 = Polynomial.from(Arrays.asList(1, 2, 3));
        Polynomial<Integer> p2 = Polynomial.from(Arrays.asList(3, 2, 1));
        Polynomial<Integer> result = p1.plus(p2, new IntegerRing());
        Polynomial<Integer> expected = Polynomial.from(Arrays.asList(4, 4, 4));
        assertEquals(expected.toString(), result.toString());
    }

    /***
     * Test plus() method for different sized param
     */
    @Test
    public void testPlusDifferentSize() {
        Polynomial<Integer> p1 = Polynomial.from(Arrays.asList(1, 2, 3, 4));
        Polynomial<Integer> p2 = Polynomial.from(Arrays.asList(3, 2, 1));
        Polynomial<Integer> result = p1.plus(p2, new IntegerRing());
        Polynomial<Integer> expected = Polynomial.from(Arrays.asList(4, 4, 4, 4));
        assertEquals(expected.toString(), result.toString());
        Polynomial<Double> p3 = Polynomial.from(Arrays.asList(1.0, 2.0, 3.0));
        Polynomial<Double> p4 = Polynomial.from(Arrays.asList(3.0, 2.0, 1.0, 4.0));
        Polynomial<Double> result1 = p3.plus(p4, new DoubleRing());
        Polynomial<Double> expected1 = Polynomial.from(Arrays.asList(4.0, 4.0, 4.0, 4.0));
        assertEquals(expected1.toString(), result1.toString());
    }

    /***
     * Test plus() method for null param
     */
    @Test
    public void testPlusEmptyAndNonEmpty() {
        Polynomial<Integer> p1 = Polynomial.from(Arrays.asList());
        Polynomial<Integer> p2 = Polynomial.from(Arrays.asList(3, 2, 1, 4));
        Polynomial<Integer> result = p1.plus(p2, new IntegerRing());
        assertEquals(p2.toString(), result.toString());
    }
}
