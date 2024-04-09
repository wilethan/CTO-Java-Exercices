import java.io.*;

public class TraitementFichiers {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java TraitementFichiers <dossier>");
            System.exit(1);
        }

        File dossier = new File(args[0]);
        File[] fichiers = dossier.listFiles((dir, name) -> name.endsWith(".op"));

        if (fichiers == null) {
            System.err.println("Le dossier spécifié est invalide.");
            System.exit(1);
        }

        for (File fichier : fichiers) {
            traiterFichier(fichier);
        }
    }

    private static void traiterFichier(File fichier) {
        File fichierResultat = new File(fichier.getParent(), fichier.getName().replace(".op", ".res"));

        try (BufferedReader reader = new BufferedReader(new FileReader(fichier));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fichierResultat))) {

            String ligne;
            while ((ligne = reader.readLine()) != null) {
                try {
                    String[] elements = ligne.split("\\s+");
                    double resultat = calculer(Double.parseDouble(elements[0]), Double.parseDouble(elements[1]), elements[2].charAt(0));
                    writer.write(String.valueOf(resultat));
                    writer.newLine();
                } catch (Exception e) {
                    writer.write("ERROR");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calculer(double nombre1, double nombre2, char operateur) {
        switch (operateur) {
            case '+': return nombre1 + nombre2;
            case '-': return nombre1 - nombre2;
            case '*': return nombre1 * nombre2;
            default: throw new IllegalArgumentException("Opérateur non supporté : " + operateur);
        }
    }
}
