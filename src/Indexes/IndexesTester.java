package Indexes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class IndexesTester {
    private final Indexes createIndexes(int row, int col) {
        return new Indexes(row, col);
    }

    @Test
    void testCompareTo() {
        // Test compareTo for Indexes
        Indexes thisIndexes = new Indexes(3, 3);
        Indexes otherIndexes = new Indexes(3, 3);
        assertEquals(0, thisIndexes.compareTo(otherIndexes));

        thisIndexes = createIndexes(3, 3);
        otherIndexes = createIndexes(3, 2);
        assertEquals(1, thisIndexes.compareTo(otherIndexes));

        thisIndexes = createIndexes(2, 3);
        otherIndexes = createIndexes(3, 3);
        assertEquals(-1, thisIndexes.compareTo(otherIndexes));

        // Test compareTo error handling
        String message = null;
        thisIndexes = createIndexes(2, 3);
        final Indexes  finalThisIndexes = thisIndexes;
        Throwable exception = assertThrows(NullPointerException.class, () -> finalThisIndexes.compareTo(null));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testAreDiagonal() {
        assertTrue(new Indexes(1, 1).areDiagonal());
        assertFalse(new Indexes(2, 1).areDiagonal());
    }

    @Test
    void testStreamMethods() {
        // Test Indexes.stream() method
        List<Indexes> list1 = Indexes.stream(new Indexes(0, 1), new Indexes(1, 3)).toList();
        List<Indexes> expectedList1 = Arrays.asList(
                new Indexes(0, 1),
                new Indexes(0, 2),
                new Indexes(0, 3),
                new Indexes(1, 1),
                new Indexes(1, 2),
                new Indexes(1, 3));
        assertEquals(expectedList1.toString(), list1.toString());

        // Test Indexes.stream() method with null indexes
        Throwable exception = assertThrows(NullPointerException.class, () -> Indexes.stream(null, new Indexes(1, 3)).toList());
        assertEquals(null, exception.getMessage());

        // Test Indexes.stream() method with size
        List<Indexes> list2 = Indexes.stream(new Indexes(0, 1)).toList();
        List<Indexes> expectedList2 = Arrays.asList(
                new Indexes(0, 0),
                new Indexes(0, 1));
        assertEquals(expectedList2.toString(), list2.toString());

        // Test Indexes.stream() method with size and null indexes
        exception = assertThrows(NullPointerException.class, () -> Indexes.stream(null, new Indexes(1, 3)).toList());
        assertEquals(null, exception.getMessage());
    }

    @Test
    void testValue() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Test value() method
        Indexes indexes = new Indexes(1, 2);
        assertEquals(6, indexes.value(matrix));

        // Test value() method with different matrix
        indexes = new Indexes(2, 3);
        Integer[][] matrix2 = {
                {1, 2, 5, 4, 6},
                {4, 1, 6, 12, 500},
                {2, 3, 1000, 62, 100}
        };
        assertEquals(62, indexes.value(matrix2).intValue());
    }
}

