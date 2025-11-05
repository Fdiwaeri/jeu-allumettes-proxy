package allumettes;

/** StrategieRapide correspond à un ordinateur qui prend le 
 * maximum d’allumettes possible (de manière à ce que la 
 * partie se termine le plus rapidement possible)
 * 
 * @author F.E
 */

public class StrategieRapide implements Strategie {

    /** Obtenir le nombre d'allumettes à prendre en fonction de la
     * stratégie du joueur.
     * @param nomJoueur le nom du joueur
     * @param jeu le jeu
     * @return le nombre d'allumettes à prendre
     */
    public int choisir(String nomJoueur, Jeu jeu) {
        if (jeu.getNombreAllumettes() > 3) {
            return 3;
        }
        return jeu.getNombreAllumettes();
    }
}