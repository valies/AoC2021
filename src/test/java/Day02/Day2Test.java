package Day02;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Day2Test {
    @Test
    public void day2TestPart1()
    {
        File txtFile = new File("src/test/java/Day2/input.txt");
        int expected = 150;
        int actual = Day2.getResultOfPart1(txtFile);
        assertEquals(expected, actual);
    }
    @Test
    public void day2TestPart2()
    {
        File txtFile = new File("src/test/java/Day2/input.txt");
        int expected = 900;
        int actual = Day2.getResultOfPart2(txtFile);
        assertEquals(expected, actual);
    }
}