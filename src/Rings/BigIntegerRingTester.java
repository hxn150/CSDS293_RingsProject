//package Rings;
//import org.junit.Test;
//
//import java.math.BigInteger;
//
//import static org.junit.Assert.assertEquals;
//
//
//public class BigIntegerRingTester {
//    @Test
//    public void testZero() {
//        Ring<BigInteger> bigIntegerRing = new BigIntegerRing();
//        BigInteger result = bigIntegerRing.zero();
//        assertEquals(BigInteger.ZERO, result);
//    }
//
//    @Test
//    public void testIdentity() {
//        Ring<BigInteger> bigIntegerRing = new BigIntegerRing();
//        BigInteger result = bigIntegerRing.identity();
//        assertEquals(BigInteger.ONE, result);
//    }
//
//    @Test
//    public void testSum() {
//        /*Testing generic case*/
//        Ring<BigInteger> bigIntegerRing = new BigIntegerRing();
//        BigInteger x = new BigInteger("12");
//        BigInteger y = new BigInteger("1");
//        BigInteger result = bigIntegerRing.sum(x, y);
//        assertEquals(new BigInteger("13"), result);
//
//        /*Testing 0*/
//        Ring<BigInteger> bigIntegerRing1 = new BigIntegerRing();
//        BigInteger x1 = new BigInteger("0");
//        BigInteger y1 = new BigInteger("1234");
//        BigInteger result1 = bigIntegerRing1.sum(x1, y1);
//        assertEquals(new BigInteger("1234"), result1);
//
//        /*Testing negative numbers*/
//        Ring<BigInteger> bigIntegerRing2 = new BigIntegerRing();
//        BigInteger x2 = new BigInteger("-12");
//        BigInteger y2 = new BigInteger("-12");
//        BigInteger result2 = bigIntegerRing2.sum(x2, y2);
//        assertEquals(new BigInteger("-24"), result2);
//    }
//
//    @Test
//    public void testProduct() {
//
//        /*Testing generic case*/
//        Ring<BigInteger> bigIntegerRing = new BigIntegerRing();
//        BigInteger x = new BigInteger("12");
//        BigInteger y = new BigInteger("2");
//        BigInteger result = bigIntegerRing.product(x, y);
//        assertEquals(new BigInteger("24"), result);
//
//        /*Testing 0*/
//        Ring<BigInteger> bigIntegerRing1 = new BigIntegerRing();
//        BigInteger x1 = new BigInteger("0");
//        BigInteger y1 = new BigInteger("1234");
//        BigInteger result1 = bigIntegerRing1.product(x1, y1);
//        assertEquals(BigInteger.ZERO, result1);
//
//        /*Testing negative numbers*/
//        Ring<BigInteger> bigIntegerRing2 = new BigIntegerRing();
//        BigInteger x2 = new BigInteger("-12");
//        BigInteger y2 = new BigInteger("-2");
//        BigInteger result2 = bigIntegerRing2.product(x2, y2);
//        assertEquals(new BigInteger("24"), result2.abs());
//    }
//}
//
