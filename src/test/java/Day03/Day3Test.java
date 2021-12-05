package Day03;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day3Test {
    @Test
    public void day3TestPart1()
    {
        File txtFile = new File("src/test/java/Day03/input.txt");
        int expected = 198;
        int actual = Day3.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }
    @Test
    public void day3TestPart2()
    {
        File txtFile = new File("src/test/java/Day03/input.txt");
        int expected = 230;
        int actual = Day3.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}