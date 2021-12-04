package Day01;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day1Test {
    @Test
    public void day1TestPart1() 
    {
        File txtFile = new File("src/test/java/Day1/input.txt");
        int expected = 7;
        int actual = Day1.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }
    @Test
    public void day1TestPart2()
    {
        File txtFile = new File("src/test/java/Day1/input.txt");
        int expected = 5;
        int actual = Day1.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}