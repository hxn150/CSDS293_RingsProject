package Rings;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class DoubleRingTester {
    @Test
    public void testZero() {
        Ring<Double> doubleRing = new DoubleRing();
        Double result = doubleRing.zero();
        assertEquals(Optional.of(0.0), result);
    }

    @Test
    public void testIdentity() {
        Ring<Double> doubleRing = new DoubleRing();
        Double result = doubleRing.identity();
        assertEquals(Optional.of(1.0), result);
    }
    @Test
    public void testSum() {
        /*Testing generic case*/
        Ring<Double> doubleRing = new DoubleRing();
        Double x = 0.5;
        Double y = 3.5;
        Double result = doubleRing.sum(x, y);
        assertEquals(Optional.of(4.0), result);

        /*Testing 0*/
        Ring<Double> doubleRing1 = new DoubleRing();
        Double x1 = 0.0;
        Double y1 = 7.5;
        Double result1 = doubleRing1.sum(x1, y1);
        assertEquals(Optional.of(7.5), result1);

        /*Testing negative numbers*/
        Ring<Double> doubleRing2 = new DoubleRing();
        Double x2 = -0.5;
        Double y2 = -10.5;
        Double result2 = doubleRing2.sum(x2, y2);
        assertEquals(Optional.of(-11.0), result2);
    }
    @Test
    public void testProduct() {
        /*Testing generic case*/
        Ring<Double> doubleRing = new DoubleRing();
        Double x = 2.0;
        Double y = 1.0;
        Double result = doubleRing.product(x, y);
        assertEquals(Optional.of(2.0), result);

        /*Testing 0*/
        Ring<Double> doubleRing2 = new DoubleRing();
        Double x2 = 0.0;
        Double y2 = 100.0;
        Double result2 = doubleRing2.product(x2, y2);
        assertEquals(Optional.of(0.0), result2);

        /*Testing negative numbers*/
        Ring<Double> doubleRing1 = new DoubleRing();
        Double x1 = -1.0;
        Double y1 = -6.0;
        Double result1 = doubleRing1.product(x1, y1);
        assertEquals(Optional.of(6.0), result1);
    }
}
