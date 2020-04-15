import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

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
}
