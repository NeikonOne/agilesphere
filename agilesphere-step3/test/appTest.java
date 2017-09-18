import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class appTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private RangeTransformer rangeTransformer = new RangeTransformer();

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
    public void shouldReturnARangeOfNumbersWithFizzBuzzAndFizzbuzzInsteadOfMultiplesOf3and5() {

        String expectedStats = "1 2 luck 4 buzz fizz 7 8 fizz";

        rangeTransformer.transform(9);

        assert (outContent.toString()).contains(expectedStats);
    }

    @Test
    public void shouldReturnARangeOfNumbersWithLuckWhenTheNumberContainsA3AndFizzbuzzWhenMultipleOf3and5() {
        String expectedStats = "1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz";
        rangeTransformer.transform(20);

        assert (outContent.toString()).contains(expectedStats);
    }

    @Test
    public void shouldReturnASummaryOfTheStatistics() {
        String expectedStats = "fizz: 4\n" +
                "buzz: 3\n" +
                "fizzbuzz: 1\n" +
                "luck: 2\n" +
                "number: 10";

        rangeTransformer.transform(20);

        assert (outContent.toString()).contains(expectedStats);
    }

}