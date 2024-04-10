interface Operation {
    double calculate(double nombre1, double nombre2);
}

class Addition implements Operation {
    public double calculate(double nombre1, double nombre2) {
        return nombre1 + nombre2;
    }
}

class Subtraction implements Operation {
    public double calculate(double nombre1, double nombre2) {
        return nombre1 - nombre2;
    }
}

class Multiplication implements Operation {
    public double calculate(double nombre1, double nombre2) {
        return nombre1 * nombre2;
    }
}

class OperationFactory {
    public static Operation getOperation(char operator) {
        switch (operator) {
            case '+': return new Addition();
            case '-': return new Subtraction();
            case '*': return new Multiplication();
            default: throw new IllegalArgumentException("Opérateur non supporté : " + operator);
        }
    }
}

public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Calculateur <nombre1> <nombre2> <opérateur>");
            System.exit(1);
        }

        double nombre1 = Double.parseDouble(args[0]);
        double nombre2 = Double.parseDouble(args[1]);
        char operator = args[2].charAt(0);

        Operation operation = OperationFactory.getOperation(operator);
        double result = operation.calculate(nombre1, nombre2);

        System.out.println("Résultat : " + result);
    }
}
