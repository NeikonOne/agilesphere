public class RangeTransformer {

    public static final String FIZZ = "fizz";
    public static final String BUZZ = "buzz";
    public static final String LUCK = "luck";

    public static void main(String[] args) {
        RangeTransformer rangeTransformer = new RangeTransformer();
        rangeTransformer.transform(Integer.parseInt(args[0]));
    }

    public void transform(int range) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i<=range; i++) {
            if(i != 1) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(transformIfRequired(i));
        }
        System.out.print(stringBuilder.toString());
    }

    private String transformIfRequired(int number) {
        StringBuilder transformation =  new StringBuilder();

        if (isDivisibleBy3(number)){
            transformation.append(FIZZ);
        }
        if (isDivisibleBy5(number)){
            transformation.append(BUZZ);
        }
        if (containsA3(number)) {
            transformation = new StringBuilder(LUCK);
        }
        if (transformation.length() == 0) {
            transformation.append(String.valueOf(number));
        }
        return transformation.toString();
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
