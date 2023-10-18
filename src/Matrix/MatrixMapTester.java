package Matrix;

import Indexes.Indexes;
import Rings.BigIntegerRing;
import Rings.IntegerRing;
import Rings.Polynomial;
import Rings.Ring;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class MatrixMapTester {
    @Test
    void testSize() {
        Integer[][] matrix = new Integer[][]{
                {1, 1, 1, 6, 1},
                {2, 2, 2, 200, 0},
                {3, 3, 3, 82, 0},
                {4, 5, 6, 7, 0},
                {6, 2, 50, 4, 8, 0}
        };
        assertTrue(new Indexes(1, 1).compareTo(MatrixMap.from(matrix).size()) == 0);
    }

    @Test
    void testValueIndexes() {
        Integer[][] matrix = new Integer[][]{
                {2, 1, 1},
                {2, -3, 4}
        };
        assertEquals(-3, MatrixMap.from(matrix).value(new Indexes(1, 1)).intValue());
    }

    @Test
    void testValueIndexesNull() {
        String message = "Null found in value() - MatrixMap";
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.from(new Integer[1][1]).value(null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testValueRowAndCol() {
        Integer[][] matrix = new Integer[][]{
                {1, -2, -3},
                {3, 4, 0},
                {5, -6, 0}
        };
        assertEquals(1, MatrixMap.from(matrix).value(0, 0).intValue());
    }

    @Test
    void testValueRowAndColNull() {
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.from(new Integer[3][2]).value(null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testInstanceRowsAndColumns() {
        MatrixMap<Integer> matrixMap = MatrixMap.instance(3, 2, indexes -> indexes.row() + indexes.column());
        assertEquals("Indexes[row=0, column=0] = 0\n" +
                        "Indexes[row=1, column=1] = 2\n" +
                        "Indexes[row=0, column=1] = 1\n" +
                        "Indexes[row=2, column=0] = 2\n" +
                        "Indexes[row=1, column=0] = 1\n" +
                        "Indexes[row=2, column=1] = 3",
                matrixMap.toString());
    }

    @Test
    void testInstanceRowsAndColumnsNull() {
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.instance(3,2, null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testInstanceRowsAndColumnsOutOfBound() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                MatrixMap.instance(-3,2, indexes -> indexes.row() + indexes.column()));
        assertEquals(MatrixMap.InvalidLengthException.class, exception.getCause().getClass());
    }

    @Test
    void testInstanceSize() {
        MatrixMap<Integer> matrixMap = MatrixMap.instance(new Indexes(2,1), indexes -> indexes.row() + indexes.column());
        assertEquals("Indexes[row=0, column=0] = 0\n" +
                        "Indexes[row=1, column=0] = 1",
                matrixMap.toString());
    }

    @Test
    void testInstanceSizeNull() {
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.instance(new Indexes(3,2), null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testInstanceSizeOutOfBound() {
        assertThrows(IllegalArgumentException.class, () ->
                MatrixMap.instance(new Indexes(-3,2), indexes -> indexes.row())
        );
    }

    @Test
    void testConstant() {
        MatrixMap<Integer> map1 = MatrixMap.constant(2, 10);
        assertEquals(
                "Indexes[row=0, column=0] = 10\n" +
                        "Indexes[row=1, column=1] = 10\n" +
                        "Indexes[row=0, column=1] = 10\n" +
                        "Indexes[row=1, column=0] = 10",
                map1.toString());

        MatrixMap<Integer> matrixMap2 = MatrixMap.constant(2, 2000);
        assertEquals("Indexes[row=0, column=0] = 2000\n" +
                        "Indexes[row=1, column=1] = 2000\n" +
                        "Indexes[row=0, column=1] = 2000\n" +
                        "Indexes[row=1, column=0] = 2000",
                matrixMap2.toString());
    }

    @Test
    void testConstantNull() {
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.constant(3, null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testConstantOutOfBound() {
        assertThrows(IllegalArgumentException.class, () ->
                MatrixMap.constant(-3, 1000)
        );
    }

    @Test
    void testIdentity() {
        MatrixMap<Integer> matrixMap = MatrixMap.identity(3, 0, 1);
        System.out.println(matrixMap);
        assertEquals("Indexes[row=0, column=0] = 1\n" +
                        "Indexes[row=1, column=1] = 1\n" +
                        "Indexes[row=2, column=2] = 1\n" +
                        "Indexes[row=0, column=1] = 0\n" +
                        "Indexes[row=1, column=2] = 0\n" +
                        "Indexes[row=0, column=2] = 0\n" +
                        "Indexes[row=2, column=0] = 0\n" +
                        "Indexes[row=1, column=0] = 0\n" +
                        "Indexes[row=2, column=1] = 0",
                matrixMap.toString());
    }

    @Test
    void testIdentityNull() {
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.identity(3,1, null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testIdentityOutOfBound() {
        assertThrows(IllegalArgumentException.class, () ->
                MatrixMap.identity(-3, 1, 1)
        );
    }

    @Test
    void testFrom() {
        Integer[][] matrix = new Integer[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        assertEquals("Indexes[row=0, column=0] = 1\n" +
                        "Indexes[row=1, column=1] = 1\n" +
                        "Indexes[row=2, column=2] = 1\n" +
                        "Indexes[row=0, column=1] = 0\n" +
                        "Indexes[row=1, column=2] = 0\n" +
                        "Indexes[row=0, column=2] = 0\n" +
                        "Indexes[row=2, column=0] = 0\n" +
                        "Indexes[row=1, column=0] = 0\n" +
                        "Indexes[row=2, column=1] = 0",
                MatrixMap.from(matrix).toString());
    }

    @Test
    void testFromNull() {
        Throwable exception = assertThrows(NullPointerException.class, () ->
                MatrixMap.from(null));
    }

    @Test
    public void testBigIntegerMatrixMultiplication() {
        BigInteger[][] data1 = {{BigInteger.valueOf(1), BigInteger.valueOf(2)},
                {BigInteger.valueOf(3), BigInteger.valueOf(4)}};
        BigInteger[][] data2 = {{BigInteger.valueOf(5), BigInteger.valueOf(6)},
                {BigInteger.valueOf(7), BigInteger.valueOf(8)}};

        BigInteger[][] expectedData = {{BigInteger.valueOf(19), BigInteger.valueOf(22)},
                {BigInteger.valueOf(43), BigInteger.valueOf(50)}};

        MatrixMap<BigInteger> matrix1 = MatrixMap.instance(2, 2, (indexes) -> data1[indexes.row()][indexes.column()]);
        MatrixMap<BigInteger> matrix2 = MatrixMap.instance(2, 2, (indexes) -> data2[indexes.row()][indexes.column()]);

        MatrixMap<BigInteger> result = matrix1.times(matrix2, new BigIntegerRing());
        MatrixMap<BigInteger> expected = MatrixMap.instance(2, 2, (indexes) -> expectedData[indexes.row()][indexes.column()]);
        assertEquals(result.toString(), expected.toString());
    }

    @Test
    public void testBigIntegerMatrixAddition() {
        // Test matrices with different sizes
        MatrixMap<BigInteger> matrix1 = MatrixMap.constant(2, BigInteger.ONE);
        MatrixMap<BigInteger> matrix2 = MatrixMap.constant(3, BigInteger.TEN);

        try {
            MatrixMap<BigInteger> result1 = matrix1.plus(matrix2, BigInteger::add);
            System.out.println("Edge Case Test Failed: Adding matrices with different sizes");
        } catch (IllegalArgumentException e) {
            System.out.println("Edge Case Test Passed: Adding matrices with different sizes");
        }

        // Test overflow case
        BigInteger[][] data3 = {{BigInteger.valueOf(Long.MAX_VALUE), BigInteger.valueOf(Long.MAX_VALUE)}};
        MatrixMap<BigInteger> matrix3 = MatrixMap.from(data3);

        try {
            MatrixMap<BigInteger> result = matrix3.plus(matrix3, BigInteger::add);
            System.out.println("Edge Case Test Failed: Overflow case");
        } catch (ArithmeticException e) {
            System.out.println("Edge Case Test Passed: Overflow case");
        }

        // Add a matrix to itself (identity property)
        BigInteger[][] data1 ={{BigInteger.valueOf(1), BigInteger.valueOf(2)},
                {BigInteger.valueOf(3), BigInteger.valueOf(4)}};
        BigInteger[][] result1 ={{BigInteger.valueOf(2), BigInteger.valueOf(4)},
                {BigInteger.valueOf(6), BigInteger.valueOf(8)}};
        MatrixMap<BigInteger> matrix4 = MatrixMap.from(data1);
        MatrixMap<BigInteger> matrix5 = MatrixMap.from(result1);
        MatrixMap<BigInteger> result4 = matrix4.plus(matrix4, BigInteger::add);
        assertEquals(matrix5.toString(), result4.toString());

        // Add a matrix to a matrix of all zeros (zero property)
        MatrixMap<BigInteger> matrix6 = MatrixMap.constant(2, BigInteger.ZERO);
        MatrixMap<BigInteger> result5 = matrix1.plus(matrix6, BigInteger::add);
        assertEquals(result5.toString(), matrix1.toString());

        BigInteger[][] data2 = {{BigInteger.valueOf(5), BigInteger.valueOf(6)},
                {BigInteger.valueOf(7), BigInteger.valueOf(8)}};

        BigInteger[][] expectedData = {{BigInteger.valueOf(6), BigInteger.valueOf(8)},
                {BigInteger.valueOf(10), BigInteger.valueOf(12)}};

        MatrixMap<BigInteger> matrix7 = MatrixMap.from(data1);
        MatrixMap<BigInteger> matrix8 = MatrixMap.from(data2);

        MatrixMap<BigInteger> result = matrix7.plus(matrix8, BigInteger::add);
        MatrixMap<BigInteger> expected = MatrixMap.from(expectedData);

        assertEquals(result.toString(), expected.toString());
    }

    @Test
    void test() {
        BigInteger[][] data1 ={{BigInteger.valueOf(1), BigInteger.valueOf(2)},
                {BigInteger.valueOf(3), BigInteger.valueOf(4)}};
        BigInteger[][] data2 ={{BigInteger.valueOf(5), BigInteger.valueOf(6)},
                {BigInteger.valueOf(7), BigInteger.valueOf(8)}};

        BigInteger[][] expected ={{BigInteger.valueOf(19), BigInteger.valueOf(22)},
                {BigInteger.valueOf(43), BigInteger.valueOf(50)}};

        MatrixMap<BigInteger> matrix1 = MatrixMap.from(data1);
        MatrixMap<BigInteger> matrix2 = MatrixMap.from(data2);
        MatrixMap<BigInteger> expectedResult = MatrixMap.from(expected);

        MatrixMap<BigInteger> result = matrix1.times(matrix2, new BigIntegerRing());
        assertEquals(expectedResult.toString(), result.toString());
    }

    @Test
    void testPolynomialAddition() {
        List<BigInteger> coefficients1 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(2));
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(3), BigInteger.ONE, BigInteger.ZERO);

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(4), BigInteger.ONE, BigInteger.valueOf(2)
        ));

        Polynomial<BigInteger> result = poly1.plus(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testPolynomialMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(2));
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(3), BigInteger.ONE, BigInteger.ZERO);

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(3), BigInteger.valueOf(1), BigInteger.valueOf(6),
                BigInteger.valueOf(2), BigInteger.ZERO
        ));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testZeroPolynomialMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO);
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(3), BigInteger.ONE, BigInteger.ZERO);

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(3), BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO,BigInteger.ZERO
        ));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testHigherDegreePolynomialMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList(BigInteger.valueOf(1), BigInteger.ZERO, BigInteger.ZERO, BigInteger.valueOf(2));
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(3), BigInteger.ONE, BigInteger.ZERO);

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(3), BigInteger.valueOf(1), BigInteger.valueOf(0), BigInteger.valueOf(6),
                BigInteger.valueOf(2), BigInteger.ZERO
        ));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testEmptyPolynomialMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList();
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(3), BigInteger.ONE, BigInteger.ZERO);

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(BigInteger.ZERO, BigInteger.ZERO));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testNegativeCoefficientsMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList(BigInteger.ONE, BigInteger.valueOf(-2), BigInteger.valueOf(3));
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(-2), BigInteger.ONE, BigInteger.valueOf(-4));

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(
                BigInteger.valueOf(-2), BigInteger.valueOf(5), BigInteger.valueOf(-12), BigInteger.valueOf(11),
                BigInteger.valueOf(-12)
        ));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testLargeCoefficientsMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList(
                new BigInteger("12345678901234567890"),
                new BigInteger("98765432109876543210")
        );
        List<BigInteger> coefficients2 = Arrays.asList(
                new BigInteger("99999999999999999999"),
                new BigInteger("11111111111111111111")
        );

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(
                new BigInteger("12345678901234567890").multiply(new BigInteger("99999999999999999999")),
                new BigInteger("12345678901234567890").multiply(new BigInteger("11111111111111111111"))
                        .add(new BigInteger("98765432109876543210").multiply(new BigInteger("99999999999999999999"))),
                new BigInteger("98765432109876543210").multiply(new BigInteger("11111111111111111111"))
        ));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void testConstantPolynomialMultiplication() {
        List<BigInteger> coefficients1 = Arrays.asList(BigInteger.valueOf(5));
        List<BigInteger> coefficients2 = Arrays.asList(BigInteger.valueOf(2));

        Polynomial<BigInteger> poly1 = Polynomial.from(coefficients1);
        Polynomial<BigInteger> poly2 = Polynomial.from(coefficients2);

        Polynomial<BigInteger> expected = Polynomial.from(Arrays.asList(BigInteger.TEN));

        Polynomial<BigInteger> result = poly1.times(poly2, new BigIntegerRing());

        assertEquals(expected.toString(), result.toString());
    }

}
