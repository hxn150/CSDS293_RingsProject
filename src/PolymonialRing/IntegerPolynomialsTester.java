//package PolymonialRing;
//
//import Rings.IntegerRing;
//import Rings.Ring;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//
//public class IntegerPolynomialsTester {
//    Ring<Integer> innerRing = new IntegerRing();
//    PolynomialRing<IntegerRing> innerPolynomialRing = PolynomialRing.createRing((Ring) innerRing);
//    private PolynomialRing<Polynomial<IntegerRing>> polynomialRing = PolynomialRing.createRing(innerPolynomialRing);
//
//    @Test
//    void testZeroPolynomial() {
//        Polynomial<Polynomial<IntegerRing>> zeroPoly = polynomialRing.zero();
//        assertEquals("", zeroPoly.toString());
//    }
//
//    @Test
//    void testIdentityPolynomial() {
//        Polynomial<Polynomial<IntegerRing>> identityPoly = polynomialRing.identity();
//        assertEquals("1", identityPoly.toString());
//    }
//}
