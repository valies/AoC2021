package Day04;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day4Test {
    @Test
    public void day4TestPart1()
    {
        File txtFile = new File("src/test/java/Day04/input.txt");
        int expected = 4512;
        int actual = Day4.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }
    @Test
    public void day4TestPart2()
    {
        File txtFile = new File("src/test/java/Day04/input.txt");
        int expected = 1924;
        int actual = Day4.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}