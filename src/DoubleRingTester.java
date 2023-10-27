
import PolymonialRing.Polynomial;
import Rings.DoubleRing;
import Rings.IntegerRing;
import Rings.Ring;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static Rings.Rings.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DoubleRingTester {
    /***
     * Test zero() method for normal param
     */
    @Test
    public void testZero() {
        Ring<Double> doubleRing = new DoubleRing();
        Double result = doubleRing.zero();
        assertEquals(Optional.of(0.0), Optional.of(result));
    }

    /***
     * Test identity() method for normal param
     */
    @Test
    public void testIdentity() {
        Ring<Double> doubleRing = new DoubleRing();
        Double result = doubleRing.identity();
        assertEquals(Optional.of(1.0), Optional.of(result));
    }

    /***
     * Test sum() method for normal param
     */
    @Test
    public void testSum() {
        /*Testing generic case*/
        Ring<Double> doubleRing = new DoubleRing();
        Double x = 0.5;
        Double y = 3.5;
        Double result = doubleRing.sum(x, y);
        assertEquals(Optional.of(4.0), Optional.of(result));

        /*Testing 0*/
        Ring<Double> doubleRing1 = new DoubleRing();
        Double x1 = 0.0;
        Double y1 = 7.5;
        Double result1 = doubleRing1.sum(x1, y1);
        assertEquals(Optional.of(7.5), Optional.of(result1));

        /*Testing negative numbers*/
        Ring<Double> doubleRing2 = new DoubleRing();
        Double x2 = -0.5;
        Double y2 = -10.5;
        Double result2 = doubleRing2.sum(x2, y2);
        assertEquals(Optional.of(-11.0), Optional.of(result2));

        // Test null input
        assertThrows(NullPointerException.class, () -> {
            doubleRing.sum(5.0, null);
        });

        // Test null input
        assertThrows(NullPointerException.class, () -> {
            doubleRing.sum(null, null);
        });
    }

    /***
     * Test product() method for normal param
     */
    @Test
    public void testProduct() {
        /*Testing generic case*/
        Ring<Double> doubleRing = new DoubleRing();
        Double x = 2.0;
        Double y = 1.0;
        Double result = doubleRing.product(x, y);
        assertEquals(Optional.of(2.0), Optional.of(result));

        /*Testing 0*/
        Ring<Double> doubleRing2 = new DoubleRing();
        Double x2 = 0.0;
        Double y2 = 100.0;
        Double result2 = doubleRing2.product(x2, y2);
        assertEquals(Optional.of(0.0), Optional.of(result2));

        /*Testing negative numbers*/
        Ring<Double> doubleRing1 = new DoubleRing();
        Double x1 = -1.0;
        Double y1 = -6.0;
        Double result1 = doubleRing1.product(x1, y1);
        assertEquals(Optional.of(6.0), Optional.of(result1));

        // Test null input
        assertThrows(NullPointerException.class, () -> {
            doubleRing.product(5.0, null);
        });

        // Test null input
        assertThrows(NullPointerException.class, () -> {
            doubleRing.product(null, null);
        });
    }

    /***
     * Test reduce() method for normal param
     */
    @Test
    public void testReduce() {
        // Test reduce with integers
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        BinaryOperator<Integer> sumOperator = Integer::sum;
        Integer result = reduce(integerList, 0, sumOperator);
        assertEquals(Integer.valueOf(15), result);

        // Test reduce with doubles
        List<Double> doubleList = List.of(1.0, 2.5, 3.0, 4.5, 5.0);
        BinaryOperator<Double> productOperator = (x, y) -> x * y;
        Double result2 = reduce(doubleList, 1.0, productOperator);
        assertEquals(168.75, result2, 0.001);
    }

    /***
     * Test reduce() method for null param
     */
    @Test(expected = NullPointerException.class)
    public void testReduceWithNullArgs() {
        List<Integer> integerList = null;
        BinaryOperator<Integer> sumOperator = Integer::sum;
        reduce(integerList, 0, sumOperator);
    }

    /***
     * Test reduce() method for null operator
     */
    @Test(expected = NullPointerException.class)
    public void testReduceWithNullOperator() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        BinaryOperator<Integer> sumOperator = null;
        reduce(integerList, 0, sumOperator);
    }

    /***
     * Test sum() method for null param
     */
    @Test(expected = NullPointerException.class)
    public void testSumWithNullArgs() {
        List<Double> doubleList = null;
        Ring<Double> doubleRing = new DoubleRing();
        sum(doubleList, doubleRing);
    }

    /***
     * Test sum() method for null param
     */
    @Test(expected = NullPointerException.class)
    public void testSumWithNullRing() {
        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> nullList = null;
        Ring<Double> nullRing = null;
        Ring<Double> doubleRing = new DoubleRing();
        sum(doubleList, nullRing);
        sum(nullList,doubleRing);
    }

    /***
     * Test product() method for null param
     */
    @Test(expected = NullPointerException.class)
    public void testProductWithNullArgs() {
        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> nullList = null;
        Ring<Double> nullRing = null;
        Ring<Double> doubleRing = new DoubleRing();
        product(doubleList, nullRing);
        product(nullList,doubleRing);
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
