package yieldstreet.test.names;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class UniqueNamesTest {

    UniqueNames uniqueNames;

    @Before
    public void setUp() {
        uniqueNames = new UniqueNames();
    }

    @Test
    public void noUnique() {
        uniqueNames.addNames("A", "B", "C", "B", "C", "A");
        assertFalse(uniqueNames.findUniqueFirst().isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void noNulls() {
        uniqueNames.addName(null);
        fail();
    }

    @Test
    public void multipleUnique() {
        uniqueNames.addNames("A", "B!", "C", "A", "A");
        assertEquals("B!", uniqueNames.findUniqueFirst().get());

        setUp();
        // Check if implementation respects order
        uniqueNames.addNames("A", "C!", "B", "A", "A");
        assertEquals("C!", uniqueNames.findUniqueFirst().get());
    }

}