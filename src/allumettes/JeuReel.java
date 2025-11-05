package allumettes;

/**  JeuReel représente le sujet réél du patron de conception Procuration.
 * 
 * @author F.E */

public class JeuReel implements Jeu {

    /** Nombre d'allumettes en jeu. */
    private int nombreAllumettes = 13; // au début 13


	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	public int getNombreAllumettes() {
        return this.nombreAllumettes;
    }

	/** Retirer des allumettes.  Le nombre d'allumettes doit être compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes
	 */
    @Override
	public void retirer(int nbPrises) throws CoupInvalideException {
        if (nbPrises < 1) {
            throw new CoupInvalideException(nbPrises, "< 1");
        } else if (nbPrises > nombreAllumettes) {
            throw new CoupInvalideException(nbPrises, "> " + this.nombreAllumettes);
        } else {
            this.nombreAllumettes = this.nombreAllumettes - nbPrises;
        }
    }

}