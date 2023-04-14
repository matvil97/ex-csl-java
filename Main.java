import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Compter le nombre de mots dans une phrase
        System.out.print("Entrez une phrase : ");
        String phrase = scanner.nextLine();
        int nombreMots = phrase.split(" ").length;
        System.out.println("Nombre de mots dans la phrase : " + nombreMots);

        // Sauvegarder une phrase dans un fichier
        try {
            FileWriter fichier = new FileWriter("MaPhrase.txt");
            fichier.write(phrase);
            fichier.close();
            System.out.println("La phrase a été sauvegardée dans le fichier ma-phrase.txt");
        } catch (IOException e) {
            System.out.println("Erreur : impossible d'écrire dans le fichier");
        }

        // Lire du texte dans un fichier et compter le nombre de mots contenu
        System.out.print("Entrez le chemin du fichier : ");
        String chemin = scanner.nextLine();

        try {
            File fichier = new File(chemin);
            Scanner lecteur = new Scanner(fichier);
            int nombreMotsFichier = 0;

            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                nombreMotsFichier += ligne.split(" ").length;
            }

            System.out.println("Nombre de mots dans le fichier : " + nombreMotsFichier);
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : fichier non trouvé");
        }
    }
}
