package Day05;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day5Test {
    @Test
    public void day5TestPart1()
    {
        File txtFile = new File("src/test/java/Day05/input.txt");
        int expected = 5;
        int actual = Day5.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }
    @Test
    public void day5TestPart2()
    {
        File txtFile = new File("src/test/java/Day05/input.txt");
        int expected = 0;
        int actual = Day5.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}