import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class appTest {

    RangeTransformer rangeTransformer = new RangeTransformer();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldReturnARangeOfNumbersWithFizzInsteadOfA3(){

        rangeTransformer.transform(3);

        assertEquals("1 2 luck", outContent.toString());
    }

    @Test
    public void shouldReturnARangeOfNumbersWithFizzBuzzAndFizzbuzzInsteadOfMultiplesOf3and5(){

        rangeTransformer.transform(9);

        assertEquals("1 2 luck 4 buzz fizz 7 8 fizz", outContent.toString());
    }


    @Test
    public void shouldReturnARangeOfNumbersWithLuckWhenTheNumberContainsA3AndFizzbuzzWhenMultipleOf3and5() {
        rangeTransformer.transform(20);

        assertEquals("1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz", outContent.toString());
    }

    @Test
    public void shouldReturnARangeOfNumbersAndNeverContainA3() {
        rangeTransformer.transform(100);

        assert(!outContent.toString().contains("3"));
    }

}

