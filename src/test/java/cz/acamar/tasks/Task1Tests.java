package cz.acamar.tasks;

import cz.acamar.tasks.exception.NotValidStringException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task1Tests { // Delete public, good practice. Read - https://junit.org/junit5/docs/current/user-guide/#writing-tests-classes-and-methods

    private final Task1 task1 = new Task1();

    @ParameterizedTest
    @MethodSource("stringsAndLastWordLength")
    void test_lastWordLength(String str, int lastWordLength) {
        assertEquals(lastWordLength, task1.lengthOfLastWord(str));
    }

    private static Stream<Arguments> stringsAndLastWordLength() {
        return Stream.of(
                Arguments.of("Hello world", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("William Shakespeare was an English   playwright", 10),
                Arguments.of("R", 1)
        );
    }

    /**
     * Test for invalid parameters.
     */
    @ParameterizedTest
    @NullSource // Annotation parameters must to be only constant expressions, not null. Because use this hack.
    @MethodSource("invalidStringsAndLastWordLength")
    void test_lastWordLengthThrowsNotValidStringException(String str) {
        // Huh, how safe is it to check the expected exception without specifying the line number? What if an exception is thrown before the expected string?
        Throwable exception = assertThrows(NotValidStringException.class, () -> task1.lengthOfLastWord(str));
        assertEquals("Getting null pointer or empty string!", exception.getMessage());
    }

    private static Stream<Arguments> invalidStringsAndLastWordLength() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of("    ")
        );
    }
}
