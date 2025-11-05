package allumettes;

/** StrategieTricheur correspond à un joueur qui triche pour
 * gagner.
 * 
 * @author F.E
 */

public class StrategieTricheur implements Strategie {

    /** Obtenir le nombre d'allumettes à prendre en fonction de la
     * stratégie du joueur.
     * @param nomJoueur le nom du joueur
     * @param jeu le jeu
     * @return le nombre d'allumettes à prendre
     */
    @Override
    public int choisir(String nomJoueur, Jeu jeu) {
        System.out.println("[Je triche...]");
        try {
            jeu.retirer(jeu.getNombreAllumettes() - 2);
        } catch (CoupInvalideException e) {}
        System.out.println("[Allumettes restantes : 2]");
        return 1;
    }
}