import java.util.*;

public class RangeTransformer {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizzbuzz";
    private static final String LUCK = "luck";

    private int counter = 0;

    private static final List<String> outputKeys = new ArrayList<>(Arrays.asList(FIZZ, BUZZ, FIZZBUZZ, LUCK));

    private Map<String, Integer> wordStats = new HashMap<>();

    public static void main(String[] args) {
        RangeTransformer rangeTransformer = new RangeTransformer();
        rangeTransformer.transform(Integer.parseInt(args[0]));
    }

    public void transform(int range) {
        transformAndPrint(range);
        printStats();
    }

    private void transformAndPrint(int range) {
        StringBuilder rangeString = new StringBuilder();

        for (int i = 1; i <= range; i++) {
            if (i != 1) {
                rangeString.append(" ");
            }
            rangeString.append(transformIfRequired(i));
        }

        System.out.print(rangeString.toString());
    }

    private void printStats() {
        outputKeys.forEach(outputKey ->
                System.out.print("\n" + outputKey + ": " + wordStats.get(outputKey)));

        System.out.print("\nnumber: " + counter);
    }

    private String transformIfRequired(int number) {
        StringBuilder transformation = applyTransformation(number);

        if (transformation.length() == 0) {
            return String.valueOf(number);
        }

        String transformationString = transformation.toString();
        addStats(transformationString);
        return transformationString;
    }

    private StringBuilder applyTransformation(int number) {
        StringBuilder transformation = new StringBuilder();

        if (isDivisibleBy3(number)) {
            transformation.append(FIZZ);
        }
        if (isDivisibleBy5(number)) {
            transformation.append(BUZZ);
        }
        if (containsA3(number)) {
            transformation = new StringBuilder(LUCK);
        }

        return transformation;
    }

    private void addStats(String transformation) {
        Integer occurrenceCount = wordStats.get(transformation) == null ? 1 : wordStats.get(transformation) + 1;
        wordStats.put(transformation, occurrenceCount);

        counter++;
    }

    private boolean isDivisibleBy3(int number) {
        return (number % 3) == 0;
    }

    private boolean isDivisibleBy5(int number) {
        return (number % 5) == 0;
    }

    private boolean containsA3(int number) {
        return String.valueOf(number).contains("3");
    }
}
