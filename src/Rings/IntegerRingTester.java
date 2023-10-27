//package Rings;
////
////import org.junit.Test;
////
////import java.util.Optional;
////
////import static org.junit.Assert.assertEquals;
////
////public class IntegerRingTester {
////    @Test
////    public void testZero() {
////        Ring<Integer> integerRing = new IntegerRing();
////        Integer result = integerRing.zero();
////        assertEquals(Optional.of(0), result);
////    }
////
////    @Test
////    public void testIdentity() {
////        Ring<Integer> integerRing = new IntegerRing();
////        Integer result = integerRing.identity();
////        assertEquals(Optional.of(1), result);
////    }
////
////    @Test
////    public void testSum() {
////        /*Testing generic case*/
////        Ring<Integer> integerRing = new IntegerRing();
////        Integer x = 1;
////        Integer y = 2;
////        Integer result = integerRing.sum(x, y);
////        assertEquals(Optional.of(3), result);
////
////        /*Testing 0*/
////        Ring<Integer> integerRing1 = new IntegerRing();
////        Integer x1 = 0;
////        Integer y1 = 10000;
////        Integer result1 = integerRing1.sum(x1, y1);
////        assertEquals(Optional.of(10000), result1);
////
////        /*Testing negative numbers*/
////        Ring<Integer> integerRing2 = new IntegerRing();
////        Integer x2 = -3;
////        Integer y2 = -9;
////        Integer result2 = integerRing2.sum(x2, y2);
////        assertEquals(Optional.of(-12), result2);
////
////        /*Testing large numbers*/
////        Ring<Integer> integerRing3 = new IntegerRing();
////        Integer x3 = Integer.MAX_VALUE;
////        Integer y3 = 1;
////        Integer result3 = integerRing3.sum(x3, y3);
////        assertEquals(Optional.of(Integer.MIN_VALUE), result3);
////    }
////
////    @Test
////    public void testProduct() {
////        /*Testing generic case*/
////        Ring<Integer> integerRing = new IntegerRing();
////        Integer x = 2;
////        Integer y = 3;
////        Integer result = integerRing.product(x, y);
////        assertEquals(Optional.of(6), result);
////
////        /*Testing 0*/
////        Ring<Integer> integerRing1 = new IntegerRing();
////        Integer x1 = 0;
////        Integer y1 = 1234;
////        Integer result1 = integerRing1.product(x1, y1);
////        assertEquals(Optional.of(0), result1);
////
////        /*Testing negative numbers*/
////        Ring<Integer> integerRing2 = new IntegerRing();
////        Integer x2 = -2;
////        Integer y2 = -6;
////        Integer result2 = integerRing2.product(x2, y2);
////        assertEquals(Optional.of(12), result2);
////    }
////}
//
//import Rings.IntegerRing;
//import Rings.Ring;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;
//
//public class IntegerRingTester {
//
//    @Test
//    public void testZero() {
//        Ring<Integer> integerRing = new IntegerRing();
//        Integer zero = integerRing.zero();
//        assertEquals(0, zero.intValue());
//    }
//
//    @Test
//    public void testIdentity() {
//        Ring<Integer> integerRing = new IntegerRing();
//        Integer identity = integerRing.identity();
//        assertEquals(1, identity.intValue());
//    }
//
//    @Test
//    public void testSum() {
//        Ring<Integer> integerRing = new IntegerRing();
//
//        // Test valid input
//        Integer result = integerRing.sum(3, 4);
//        assertEquals(7, result.intValue());
//
//        // Test null input
//        assertThrows(NullPointerException.class, () -> {
//            integerRing.sum(5, null);
//        });
//    }
//
//    @Test
//    public void testProduct() {
//        Ring<Integer> integerRing = new IntegerRing();
//
//        // Test valid input
//        Integer result = integerRing.product(3, 4);
//        assertEquals(12, result.intValue());
//
//        // Test null input
//        assertThrows(NullPointerException.class, () -> {
//            integerRing.product(5, null);
//        });
//    }
//
//    @Test
//    public void testNegate() {
//        Ring<Integer> integerRing = new IntegerRing();
//
//        // Test valid input
//        Integer result = integerRing.negate(7);
//        assertEquals(-7, result.intValue());
//
//        // Test null input
//        assertThrows(NullPointerException.class, () -> {
//            integerRing.negate(null);
//        });
//    }
//}
