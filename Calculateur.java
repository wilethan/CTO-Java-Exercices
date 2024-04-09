public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Calculateur <nombre1> <nombre2> <opérateur>");
            System.exit(1);
        }

        double nombre1, nombre2;
        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Les deux premiers arguments doivent être des nombres.");
            System.exit(1);
            return;
        }

        char operateur = args[2].charAt(0);
        double resultat = 0;
        switch (operateur) {
            case '+': resultat = nombre1 + nombre2; break;
            case '-': resultat = nombre1 - nombre2; break;
            case '*': resultat = nombre1 * nombre2; break;
            default:
                System.err.println("Opérateur invalide. Utilisez l'un des opérateurs suivants : +, -, *.");
                System.exit(1);
        }
        System.out.println("Résultat : " + resultat);
    }
}