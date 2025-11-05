package allumettes;

import java.util.Scanner;

/** StrategieHumain permet à un joueur humain de jouer au jeu. Elle
 * consiste à demander à l’utilisateur ce nombre.
 * 
 * @author F.E
 */

public class StrategieHumain implements Strategie {

    /** Le scanner de la saisie de l'utilisateur. */
    private static final Scanner INPUT = new Scanner(System.in);

    /** Obtenir le nombre d'allumettes à prendre en fonction de la
     * stratégie du joueur.
     * @param nomJoueur le nom du joueur
     * @param jeu le jeu
     * @return le nombre d'allumettes à prendre
     */
    @Override
    public int choisir(String nomJoueur, Jeu jeu) {
        while (true) {
            System.out.print(nomJoueur + ", combien d'allumettes ? ");
            if (INPUT.hasNextInt()) { // La donnée saisie est un entier
                int prise = INPUT.nextInt();
                INPUT.nextLine(); // Consommer le reste de la ligne
                // Retourner le nombre donné par l'utilisateur (joueur humain)
                return prise;
            } else { // La donnée saisie n'est pas un entier
                String saisie = INPUT.next();
                INPUT.nextLine(); // Consommer le reste de la ligne
                if ( saisie.equals("triche")) { // Vérifier si l'utilisateur tente de tricher
                    try {
                        jeu.retirer(1);
                    } catch (CoupInvalideException e) {}
                    System.out.println("[Une allumette en moins, plus que " +jeu.getNombreAllumettes() +". Chut !]");
                } else {
                    System.out.println("Vous devez donner un entier.");
                }
            }
        }
    }
}