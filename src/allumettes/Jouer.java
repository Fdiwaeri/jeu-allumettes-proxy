package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	F.E
 */
public class Jouer {

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);
			verifierArguments(args);
			JeuReel jeu = new JeuReel();
			boolean confiant; Joueur joueur1; Joueur joueur2;
			if (args.length == 3) {
				confiant = true;
				joueur1 = donnerJoueur(args[1]);
				joueur2 = donnerJoueur(args[2]);
			} else {
				confiant = false;
				joueur1 = donnerJoueur(args[0]);
				joueur2 = donnerJoueur(args[1]);
			}
			Arbitre arbitre = new Arbitre(joueur1, joueur2);
			arbitre.arbitrer(jeu, confiant);
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Vérifier les arguments de la ligne de commande. */
	private static void verifierArguments(String[] args) {
		if (args.length == 3 && !args[0].equals("-confiant")) {
			throw new ConfigurationException("Argument invalide : "
					+ args[0]);
		}
	}

	/** Attribuer aux joueurs leurs noms et stratégies. */
	private static Joueur donnerJoueur(String arg) {
		String[] parametres = arg.split("@"); // parametres[0] est le nom du joueur
		if (parametres.length != 2) {
			throw new ConfigurationException("Arguments de joueur invalide :"
					+ arg);
		}
		return switch (parametres[1]) { // parametres[1] est la stratégie du joueur
			case "humain" -> new Joueur(parametres[0], new StrategieHumain());
			case "naif" -> new Joueur(parametres[0], new StrategieNaif());
			case "rapide" -> new Joueur(parametres[0], new StrategieRapide());
			case "expert" -> new Joueur(parametres[0], new StrategieExpert());
			case "tricheur" -> new Joueur(parametres[0], new StrategieTricheur());
			default -> throw new ConfigurationException("Argument de stratégie invalide : "
							+ parametres[1]);
		};
		// Pour l'instant, les stratégies possibles sont :
		// 		humain , naif, rapide, expert et tricheur
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple 1:"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n\t" + "Exemple 2:"
				+ "\n\t" + "	java allumettes.Jouer -confiant Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
