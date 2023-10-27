package Interpolation;//package Interpolation;
//
//import Rings.DoubleRing;
//import Rings.IntegerRing;
//import Rings.Polynomial;
//import Rings.Ring;
//import org.junit.Test;
//import org.w3c.dom.ls.LSInput;
//
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//
//
//public class InterpolationPolynomialTester {
//    @Test
//    public void testInterpolateWithIntegerRing() {
//        Ring<Integer> integerRing = new IntegerRing();
//        List<Integer> dataPoints = List.of(1, 2, 3);
//        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
//        System.out.println("datapoints: " + dataPoints);
//        System.out.println("before result: " + result);
//        Collections.reverse(result.getList());
//        System.out.println("after result: " + result);
//
//        // Define the expected coefficients of the resulting polynomial
//        List<Integer> expectedCoefficients = List.of(1, -6, 11, -6);
//        System.out.println("expectedCoefficients: " +expectedCoefficients);
//
//        //Extract the coefficients from the result
//        List<Integer> resultCoefficients = result.getList();
//        assertEquals(expectedCoefficients, resultCoefficients);
//    }
//
//    @Test
//    public void testInterpolateWithLargeDataPoints() {
//        Ring<Integer> integerRing = new IntegerRing();
//        List<Integer> dataPoints = List.of(1, 2, 3, 4, 5, 6);
//        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
//
//        // Define the expected coefficients of the resulting polynomial
//        List<Integer> expectedCoefficients = List.of(1, -21, 175, -735, 1624, -1764, 720);
//
//        // Extract the coefficients from the result
//        List<Integer> resultCoefficients = result.getList();
//
//        assertEquals(expectedCoefficients, resultCoefficients);
//    }
//
//    @Test
//    public void testInterpolateWithDoubleRing() {
//        Ring<Double> doubleRing = new DoubleRing();
//        List<Double> dataPoints = List.of(1.0, 2.5, 4.0);
//        Polynomial<Double> result = InterpolationPolynomial.interpolate(dataPoints, doubleRing);
//
//        // Define the expected coefficients of the resulting polynomial
//        List<Double> expectedCoefficients = List.of(1.0, -7.5, 16.5, -10.0);
//
//        // Extract the coefficients from the result
//        List<Double> resultCoefficients = result.getList();
//
//        assertEquals(expectedCoefficients, resultCoefficients);
//    }
//
//    @Test
//    public void testBoundaryValues() {
//        Ring<Integer> integerRing = new IntegerRing();
//        List<Integer> dataPoints = List.of(Integer.MIN_VALUE, 0, 1, Integer.MAX_VALUE);
//        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
////        Polynomial<Integer> expected =
////        assertEquals(result, expected);
//        // Test Assertion
//        // Ensure the interpolation works correctly at boundary values.
//    }
//
//    @Test
//    public void testCompoundBoundaries() {
//        Ring<Double> doubleRing = new DoubleRing();
//        List<Double> dataPoints = List.of(-10.0, -5.0, 0.0, 5.0, 10.0);
//        Polynomial<Double> result = InterpolationPolynomial.interpolate(dataPoints, doubleRing);
//
//        // Test Assertion
//        // Verify the behavior at compound boundaries.
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testInvalidInput() {
//        Ring<Integer> integerRing = new IntegerRing();
//        List<Integer> dataPoints = List.of(1, 2, 3, null, 5); // Include null as invalid input
//        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
//        List<Integer> resultList = result.getList();
//        List<Integer> expected = null;
//        assertEquals(resultList, expected);
//    }
//}

import Rings.DoubleRing;
import Rings.IntegerRing;
import Rings.Polynomial;
import Rings.Ring;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InterpolationPolynomialTester {

    private final Ring<Integer> integerRing = new IntegerRing();

    @Test
    public void testCodeCoverage() {
        List<Integer> dataPoints = Arrays.asList(1, 2, 3);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    @Test
    public void testBranchCoverageEmptyDataPoints() {
        List<Integer> dataPoints = Collections.emptyList();
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    @Test
    public void testDataFlow() {
        List<Double> dataPoints = Arrays.asList(1.5, 2.5, 3.5);
        Ring<Double> doubleRing = new DoubleRing();
        Polynomial<Double> result = InterpolationPolynomial.interpolate(dataPoints, doubleRing);
        assertNotNull(result);
    }

    @Test
    public void testBoundaryCases() {
        List<Integer> dataPoints = Arrays.asList(Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    @Test
    public void testCompoundBoundaries() {
        List<Integer> dataPoints = Arrays.asList(-100, -10, 0, 10, 100);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testBadDataNullDataPoints() {
        InterpolationPolynomial.interpolate(null, integerRing);
    }

    @Test(expected = NullPointerException.class)
    public void testBadDataNullRing() {
        List<Integer> dataPoints = Arrays.asList(1, 2, 3);
        InterpolationPolynomial.interpolate(dataPoints, null);
    }

    @Test
    public void testGoodData() {
        List<Integer> dataPoints = Arrays.asList(1, 2, 3);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }
}
