package allumettes;

/** Exception levée par la procuration si le joueur appelle la méthode
 * retirer de la procuration.
 * 
 * @author	F.E
 */
public class OperationInterditeException extends RuntimeException {

    /** Initaliser une OperationInterditeException.
	  * @param message le message explicatif
	  * @param vNomJoueur le nom du joueur qui triche
	  */
	public OperationInterditeException(String message) {
		super(message);
	}
}