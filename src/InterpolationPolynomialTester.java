import Rings.DoubleRing;
import Rings.IntegerRing;
import Rings.Polynomial;
import Rings.Ring;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class InterpolationPolynomialTester {

    private final Ring<Integer> integerRing = new IntegerRing();


    /***
     * Test interpolate() method for normal param
     */
    @Test
    public void testCodeCoverage() {
        List<Integer> dataPoints = Arrays.asList(1, 2, 3);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    /***
     * Test interpolate() method for null param
     */
    @Test
    public void testBranchCoverageEmptyDataPoints() {
        List<Integer> dataPoints = Collections.emptyList();
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    /***
     * Test interpolate() method for different types of param
     */
    @Test
    public void testDataFlow() {
        List<Double> dataPoints = Arrays.asList(1.5, 2.5, 3.5);
        Ring<Double> doubleRing = new DoubleRing();
        Polynomial<Double> result = InterpolationPolynomial.interpolate(dataPoints, doubleRing);
        assertNotNull(result);
    }

    /***
     * Test interpolate() method for boundaries cases
     */
    @Test
    public void testBoundaryCases() {
        List<Integer> dataPoints = Arrays.asList(Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    /***
     * Test interpolate() method for compound boundaries cases
     */
    @Test
    public void testCompoundBoundaries() {
        List<Integer> dataPoints = Arrays.asList(-100, -10, 0, 10, 100);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
    }

    /***
     * Test interpolate() method for null datapoints
     */
    @Test(expected = NullPointerException.class)
    public void testBadDataNullDataPoints() {
        InterpolationPolynomial.interpolate(null, integerRing);
    }

    /***
     * Test interpolate() method for null rings
     */
    @Test(expected = NullPointerException.class)
    public void testBadDataNullRing() {
        List<Integer> dataPoints = Arrays.asList(1, 2, 3);
        InterpolationPolynomial.interpolate(dataPoints, null);
    }

    /***
     * Test interpolate() method for normal data
     */
    @Test
    public void testGoodData() {
        List<Integer> dataPoints = Arrays.asList(1, 2, 3);
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        assertNotNull(result);
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

    /***
     * Test interpolation() method with stres test
     */
    @Test
    public void stressTestInterpolation() {
        List<Integer> dataPoints = new ArrayList<>();

        // Generate a large dataset, e.g., 1 million data points
        int dataSize = 1000;
        for (int i = 1; i <= dataSize; i++) {
            dataPoints.add(i);
        }

        // Measure the execution time
        long startTime = System.currentTimeMillis();
        Polynomial<Integer> result = InterpolationPolynomial.interpolate(dataPoints, integerRing);
        long endTime = System.currentTimeMillis();

        // Assert that the result is not null and execution time is reasonable
        assertNotNull(result);
        long executionTime = endTime - startTime;
        assertTrue("Stress test execution time is reasonable", executionTime < 1000); // Adjust the threshold as needed
    }
}
