import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Initialize database connection \n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Close database connection\n");

    }

    @BeforeEach
        // Before in junit4
    void beforeEach(TestInfo testInfo) {
        System.out.println("Initialize test data for " + testInfo.getDisplayName());
    }

    @AfterEach
        // After in junit4
    void afterEach(TestInfo testInfo) {
        System.out.println("Clean up test data for " + testInfo.getDisplayName() + "\n");
    }

    @Test
    void length_basic() {
        // Given
        String str = "ABCD";

        // When
        int actualLength = str.length();

        // Assertion
        int expectedLength = 4;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void length_greater_then_zero() {
        assertTrue("ABCD".length() > 0);
        assertTrue("ABC".length() > 0);
        assertTrue("A".length() > 0);
        assertTrue("DEF".length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
    void length_greater_then_zero_using_parameterized(String str) {
        assertTrue(str.length() > 0);
    }

    @Test
    void uppercase() {
        assertEquals("ABCD", "abcd".toUpperCase());
        assertEquals("ABC", "abc".toUpperCase());
        assertEquals("A", "a".toUpperCase());
        assertEquals("DEF", "def".toUpperCase());
    }

    @ParameterizedTest(name = "{0} when upper case is {1}")
    @CsvSource(value = {"abcd,ABCD","abc,ABC","'',''","a,A","def,DEF"})
    void uppercaseCsv(String word, String expectedCapitalizeWord) {
        assertEquals(expectedCapitalizeWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} is length {1}")
    @CsvSource(value = {"abcd,4","abc,3","'',0","a,1","def,3"})
    void lengthCsv(String word, int expectedLength) {
        assertEquals(expectedLength, word.length());
    }


    @Test
    void toUpperCase() {
        // Given
        String str = "abcd";

        // When
        String result = str.toUpperCase();

        // Assertion && Verify
        assertNotNull(result);
        assertEquals("ABCD", result.toString());
    }

    @RepeatedTest(10)
    void contain_basic() {
        // Given
        String str = "abcdefghijk";

        // When
        boolean result = str.contains("ijk");

        // Assertion
        assertEquals(true, result);
        // assertTrue(result);
    }

    @Test
    void slim_contain_basic() {
        assertFalse("abcdefghijk".contains("xyz"));
    }

    @Test
    void split_basic() {
        // Given
        String str = "abc def ghi";

        // When
        String actualResult[] = str.split(" ");

        // Assertion
        assertArrayEquals(new String[]{"abc", "def", "ghi"}, actualResult);
//        String expectResult[] = new String[] {"abc", "def", "ghi"};
//        assertArrayEquals(expectResult, actualResult);
    }


    @Test
    @DisplayName("When length is null, Throw an exception")
    void length_exception() {
        // Given
        String str = null;

        // Assertion
        assertThrows(NullPointerException.class,
                () -> {
                    // When
                    str.length();
                }
        );
    }

}
