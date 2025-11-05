package allumettes;

/** Le patron de conception Procuration est aussi appelé Mandataire, Proxy,
 *  etc. Au lieu d’accéder au sujet réel, le client (= le joueur) accède
 * à l’objet procuration qui relaie l’opération vers le sujet réel (=le jeu).
 * 
 * La proccuration (Proxy) sert à interdire le joueur de modifier le jeu.
 * 
 * @author F.E
 */
public class Proxy implements Jeu {

    private JeuReel sujetReel;

    /** Créer une procuration. */
    public Proxy(JeuReel jeuReel) {
        this.sujetReel = jeuReel;
    }

	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	public int getNombreAllumettes() {
        return this.sujetReel.getNombreAllumettes();
    }

	/** Retirer des allumettes.  Le nombre d'allumettes doit être compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'allumettes
	 */
    @Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		if (nbPrises > this.sujetReel.getNombreAllumettes()) { // Vérification avant
			throw new CoupInvalideException(nbPrises, "> " + this.sujetReel.getNombreAllumettes());
		}
        throw new OperationInterditeException("");
    }

}
