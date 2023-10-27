//package Rings;
//
//import org.junit.Test;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.BinaryOperator;
//
//import static org.junit.Assert.assertEquals;
//
//public class DoubleRingTester {
//    @Test
//    public void testZero() {
//        Ring<Double> doubleRing = new DoubleRing();
//        Double result = doubleRing.zero();
//        assertEquals(Optional.of(0.0), result);
//    }
//
//    @Test
//    public void testIdentity() {
//        Ring<Double> doubleRing = new DoubleRing();
//        Double result = doubleRing.identity();
//        assertEquals(Optional.of(1.0), result);
//    }
//    @Test
//    public void testSum() {
//        /*Testing generic case*/
//        Ring<Double> doubleRing = new DoubleRing();
//        Double x = 0.5;
//        Double y = 3.5;
//        Double result = doubleRing.sum(x, y);
//        assertEquals(Optional.of(4.0), result);
//
//        /*Testing 0*/
//        Ring<Double> doubleRing1 = new DoubleRing();
//        Double x1 = 0.0;
//        Double y1 = 7.5;
//        Double result1 = doubleRing1.sum(x1, y1);
//        assertEquals(Optional.of(7.5), result1);
//
//        /*Testing negative numbers*/
//        Ring<Double> doubleRing2 = new DoubleRing();
//        Double x2 = -0.5;
//        Double y2 = -10.5;
//        Double result2 = doubleRing2.sum(x2, y2);
//        assertEquals(Optional.of(-11.0), result2);
//    }
//    @Test
//    public void testProduct() {
//        /*Testing generic case*/
//        Ring<Double> doubleRing = new DoubleRing();
//        Double x = 2.0;
//        Double y = 1.0;
//        Double result = doubleRing.product(x, y);
//        assertEquals(Optional.of(2.0), result);
//
//        /*Testing 0*/
//        Ring<Double> doubleRing2 = new DoubleRing();
//        Double x2 = 0.0;
//        Double y2 = 100.0;
//        Double result2 = doubleRing2.product(x2, y2);
//        assertEquals(Optional.of(0.0), result2);
//
//        /*Testing negative numbers*/
//        Ring<Double> doubleRing1 = new DoubleRing();
//        Double x1 = -1.0;
//        Double y1 = -6.0;
//        Double result1 = doubleRing1.product(x1, y1);
//        assertEquals(Optional.of(6.0), result1);
//    }
//    @Test
//    public void testReduce() {
//        // Test reduce with integers
//        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
//        BinaryOperator<Integer> sumOperator = Integer::sum;
//        Integer result = Rings.reduce(integerList, 0, sumOperator);
//        assertEquals(Integer.valueOf(15), result);
//
//        // Test reduce with doubles
//        List<Double> doubleList = List.of(1.0, 2.5, 3.0, 4.5, 5.0);
//        BinaryOperator<Double> productOperator = (x, y) -> x * y;
//        Double result2 = Rings.reduce(doubleList, 1.0, productOperator);
//        assertEquals(67.5, result2, 0.001);
//    }
//
//    @Test
//    public void testSum1() {
//        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
//        Ring<Double> doubleRing = new DoubleRing();
//        Double result = Rings.sum(doubleList, doubleRing);
//        assertEquals(Double.valueOf(15.0), result);
//    }
//
//    @Test
//    public void testProduct1() {
//        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
//        Ring<Double> doubleRing = new DoubleRing();
//        Double result = Rings.product(doubleList, doubleRing);
//        assertEquals(Double.valueOf(120.0), result);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testReduceWithNullArgs() {
//        List<Integer> integerList = null;
//        BinaryOperator<Integer> sumOperator = Integer::sum;
//        Rings.reduce(integerList, 0, sumOperator);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testReduceWithNullOperator() {
//        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
//        BinaryOperator<Integer> sumOperator = null;
//        Rings.reduce(integerList, 0, sumOperator);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testSumWithNullArgs() {
//        List<Double> doubleList = null;
//        Ring<Double> doubleRing = new DoubleRing();
//        Rings.sum(doubleList, doubleRing);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testSumWithNullRing() {
//        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
//        Ring<Double> doubleRing = null;
//        Rings.sum(doubleList, doubleRing);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testProductWithNullArgs() {
//        List<Double> doubleList = null;
//        Ring<Double> doubleRing = new DoubleRing();
//        Rings.product(doubleList, doubleRing);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testProductWithNullRing() {
//        List<Double> doubleList = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
//        Ring<Double> doubleRing = null;
//        Rings.product(doubleList, doubleRing);
//    }
//}
