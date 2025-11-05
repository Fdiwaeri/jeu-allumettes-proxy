package allumettes;

/** Strategie représente la stratégie du jeu qui définisse le choix du
 * nombre d'allumettes à prendre. Elle définit aussi le niveau de jeu
 * du joueur.
 * 
 * @author F.E
 */

public interface Strategie {
    
    /** Obtenir le nombre d'allumettes à prendre en fonction de la
     * stratégie du joueur.
     * @param nomJoueur le nom du joueur
     * @param jeu le jeu
     * @return le nombre d'allumettes à prendre
     */
    int choisir(String nomJoueur, Jeu jeu);
}