package allumettes;

import java.util.Random;

/** StrategieNaif correspond à un ordinateur qui choisit 
 * aléatoirement un nombre entre 1 et 3
 * 
 * @author F.E
 */

public class StrategieNaif implements Strategie {
    
    /** Le générateur de nombres aléatoires. */
    private static final Random ALEA = new Random();

    /** Obtenir le nombre d'allumettes à prendre en fonction de la
     * stratégie du joueur.
     * @param nomJoueur le nom du joueur
     * @param jeu le jeu
     * @return le nombre d'allumettes à prendre
     */
    public int choisir(String nomJoueur, Jeu jeu) {
        return ALEA.nextInt(3) + 1; // résultat entre 1 et 3
    }
}