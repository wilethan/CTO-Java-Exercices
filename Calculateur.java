import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculateur {

    private static final Map<Character, BinaryOperator<Double>> OPERATIONS = new HashMap<>();
    static {
        OPERATIONS.put('+', (a, b) -> a + b);
        OPERATIONS.put('-', (a, b) -> a - b);
        OPERATIONS.put('*', (a, b) -> a * b);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Calculateur <nombre1> <nombre2> <opérateur>");
            System.exit(1);
        }

        double nombre1 = Double.parseDouble(args[0]);
        double nombre2 = Double.parseDouble(args[1]);
        char operator = args[2].charAt(0);

        if (!OPERATIONS.containsKey(operator)) {
            System.err.println("Opérateur non supporté : " + operator);
            System.exit(1);
        }

        BinaryOperator<Double> operation = OPERATIONS.get(operator);
        double result = operation.apply(nombre1, nombre2);

        System.out.println("Résultat : " + result);
    }
}
