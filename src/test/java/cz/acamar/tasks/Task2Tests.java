package cz.acamar.tasks;

import cz.acamar.tasks.exception.NotValidArrayException;
import cz.acamar.tasks.exception.NotValidStringException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Tests {

    private final Task2 task2 = new Task2();

    @Test
    void test_case1() {
        int[] input = new int[]{-4, -1, 0, 3, 10};
        int[] expected = new int[]{0, 1, 9, 16, 100};

        assertArrayEquals(expected, task2.squaresOfSortedArray(input));
    }

    @Test
    void test_case2() {
        int[] input = new int[]{-7, -3, 2, 3, 11};
        int[] expected = new int[]{4, 9, 9, 49, 121};

        assertArrayEquals(expected, task2.squaresOfSortedArray(input));
    }

    /**
     * Test for invalid parameters.
     */
    @ParameterizedTest
    @NullSource // Annotation parameters must to be only constant expressions, not null. Because use this hack.
    void test_squaresOfSortedArrayThrowsNotValidArrayException(int[] input) {
        // Huh, how safe is it to check the expected exception without specifying the line number? What if an exception is thrown before the expected string?
        Throwable exception = assertThrows(NotValidArrayException.class, () -> task2.squaresOfSortedArray(input));
        assertEquals("Getting null pointer or empty array!", exception.getMessage());
    }

}
