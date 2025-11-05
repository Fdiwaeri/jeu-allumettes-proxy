package allumettes;

/** Un arbitre fait respecter les règles du jeu aux deux joueurs.
 * L’arbitre fait jouer, à tour de rôle, chaque joueur.
 * Faire jouer un joueur consiste à afficher le nombre d’allumettes 
 * encore en jeu, lui demander le nombre d’allumettes qu’il 
 * souhaite prendre, afficher ce nombre, puis à retirer les 
 * allumettes du jeu.
 * 
 * @author F.E
*/

public class Arbitre {

    /** Le premier joueur. */
    private Joueur j1;

    /** Le deuxième joueur. */
    private Joueur j2;


    /** Construire un arbitre à partir des deux joueurs qui vont
     * s'affronter.
     * @param j1 le premier joueur
     * @param j2 le deuxième joueur
     */
    public Arbitre(Joueur joueur1, Joueur joueur2) {
        this.j1 = joueur1;
        this.j2 = joueur2;
    }


    /** Arbitrer un partie/un jeu.
     * @param jeu le jeu en cours.
     * @param confiant arbitre confiant ou non?
     */
    public void arbitrer(JeuReel jeu, boolean confiant) {
        Joueur joueurCourant = this.j1;
        int nbAllumettes = jeu.getNombreAllumettes();
        while (nbAllumettes != 0) {
            try {
                // Afficher le nombre d’allumettes encore en jeu
                System.out.println("Allumettes restantes : " + nbAllumettes);
                // Demander au joueur le nombre d’allumettes qu’il souhaite prendre
                int prise;
                if (confiant) { // Transmettre le jeu réel au joueur
                    prise = joueurCourant.getPrise(jeu);
                } else { // Transmettre proxy
                    prise = joueurCourant.getPrise(new Proxy(jeu));
                }
                // Afficher ce nombre
                System.out.print(joueurCourant.getNom() + " prend " + prise);
                if (prise<2) {
                    System.out.println(" allumette.");
                } else {
                    System.out.println(" allumettes.");
                }
                // Retirer les allumettes
                if (prise > nbAllumettes) {
                    throw new CoupInvalideException(prise, "> " + nbAllumettes);
                
                } else if (prise > jeu.PRISE_MAX) {
                    throw new CoupInvalideException(prise, "> " + jeu.PRISE_MAX);
                }
                jeu.retirer(prise);
                nbAllumettes = jeu.getNombreAllumettes();
                // Changer le joueur courant si le coup est valide
                joueurCourant = changerJoueurs(joueurCourant, j1, j2);
                System.out.println();
            } catch (CoupInvalideException e) {
                System.out.println("Impossible ! Nombre invalide : "
                            + e.getCoup() + " (" + e.getProbleme() + ")");
                System.out.println();
            } catch (OperationInterditeException e) {
                System.out.println("Abandon de la partie car " 
                                   + joueurCourant.getNom() + " triche !");
                // Arrêter la partie immédiatement
                return; // Sort de la méthode arbitrer()
            }
        }
        // Annoncer les résultats de la partie
        if (joueurCourant == this.j1) {
            System.out.println(j2.getNom() + " perd !");
            System.out.println(j1.getNom() + " gagne !");
        } else {
            System.out.println(j1.getNom() + " perd !");
            System.out.println(j2.getNom() + " gagne !");
        }
    }

    /** Changer le joueur courant.
     * @param joueurCourant le joueur courant
     * @param joueur1 le premier joueur
     * @param joueur2 le deuxième joueur
     */
    private static Joueur changerJoueurs(Joueur joueurCourant, Joueur joueur1, Joueur joueur2) {
        if (joueurCourant == joueur1) {
            return joueur2;
        } else {
            return joueur1;
        }
    }
}