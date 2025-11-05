package allumettes;

/** StrategieExpert correspond à un ordinateur qui joue du
 * mieux qu’il peut (s’il peut gagner, il gagnera).
 * 
 * @author F.E
 */

public class StrategieExpert implements Strategie {

    /** Obtenir le nombre d'allumettes à prendre en fonction de la
     * stratégie du joueur.
     * @param nomJoueur le nom du joueur
     * @param jeu le jeu
     * @return le nombre d'allumettes à prendre
     */
    public int choisir(String nomJoueur, Jeu jeu) {
        int nbAllumettes = jeu.getNombreAllumettes();
        if (nbAllumettes == 1) {
            return 1;
        } else if (nbAllumettes % 4 == 1) {
            return 3;
        } else {
            return ((nbAllumettes - 1) % 4);
        }
    }
}