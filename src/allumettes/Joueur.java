package allumettes;

/** Un joueur participe à un jeu. Il y a deux joueurs dans chaque partie.
 * 
 * @author F.E
 */

public class Joueur {
    /** Le nom du joueur. */
    private String nom;

    /** La stratégie du joueur. */
    private Strategie strategie;

    /** Construire un joueur à partie de son nom et sa stratégie de jeu.
     * @param vnom so nom
     * @param vstrategie sa stratégie
     */
    public Joueur(String vnom, Strategie vstrategie) {
        this.nom = vnom;
        this.strategie = vstrategie;
    }

    /** Obtenir le nom du joueur.
     * @return le nom du joueur
     */
    public String getNom() {
        return this.nom;
    }

    /** Obtenir le nombre d'allumettes que le joueur veut prendre.
     * @param jeu le jeu
     * @return le nombre d'allumettes pris par le joueur
     */
    public int getPrise(Jeu jeu) {
        return this.strategie.choisir(this.nom, jeu);
    }
}