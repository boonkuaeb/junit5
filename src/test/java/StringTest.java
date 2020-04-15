import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @BeforeAll
    static void beforeAll()
    {
        System.out.println(">>> Initialize database connection");
    }

    @AfterAll
    static void afterAll()
    {
        System.out.println(">>> Close database connection");

    }

    @BeforeEach // Before in junit4
    void beforeEach(TestInfo testInfo)
    {
        System.out.println("Initialize test data for "+testInfo.getDisplayName());
    }

    @AfterEach // After in junit4
    void afterEach(TestInfo testInfo)
    {
        System.out.println("Clean up test data for "+testInfo.getDisplayName()+"\n");
    }

    @Test
    void length_basic()
    {
        // Given
        String str = "ABCD";

        // When
        int actualLength = str.length();

        // Assertion
        int expectedLength = 4;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void toUpperCase()
    {
        // Given
        String str = "abcd";

        // When
        String result = str.toUpperCase();

        // Assertion && Verify
        assertNotNull(result);
        assertEquals("ABCD",result.toString());
    }

    @Test
    void contain_basic()
    {
        // Given
        String str = "abcdefghijk";

        // When
        boolean result = str.contains("ijk");

        // Assertion
        assertEquals(true,result);
        // assertTrue(result);
    }
    @Test
    void slim_contain_basic()
    {
        assertFalse("abcdefghijk".contains("xyz"));
    }

    @Test
    void split_basic()
    {
        // Given
        String str = "abc def ghi";

        // When
        String actualResult[] = str.split(" ");

        // Assertion
        assertArrayEquals(new String[] {"abc", "def", "ghi"}, actualResult);
//        String expectResult[] = new String[] {"abc", "def", "ghi"};
//        assertArrayEquals(expectResult, actualResult);
    }
}
