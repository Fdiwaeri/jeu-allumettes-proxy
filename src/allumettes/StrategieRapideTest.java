package allumettes;

import org.junit.*;
import static org.junit.Assert.*;

/** Classe de test de la stratégie de jeu StartegieRapide.
 * 
 * @author F.E
 */

public class StrategieRapideTest {

    // Le jeu de test
    private Jeu jeuTest;

    // Le stratégie
    Strategie strategieA;

    // Les joueurs dans le jeu de test
    private Joueur j1, j2;

    @Before
    public void setUp() {
        // Créer une stratégie rapide
        strategieA = new StrategieRapide();

        // Créer les joueurs
        j1 = new Joueur("Joueur1", strategieA);
        j2 = new Joueur("Joueur2", strategieA);

        // Créer le jeu
        jeuTest = new JeuReel();
    }

    @Test
    public void testerPrise3() {
        assertEquals("La stratégie rapide ne donne pas 3 même au début du jeu",
                3, strategieA.choisir("John Doe", jeuTest));
        assertEquals("Le joueur avec stratégie rapide ne prend pas 3 même au début",
                3, j1.getPrise(jeuTest));
        // Affichage
        // System.out.println("Allumettes restantes : " + jeuTest.getNombreAllumettes());
        // System.out.println("John Doe prend " + strategieA.choisir("John Doe", jeuTest) + " allumettes.");
        // System.out.println(j1.getNom() + " prend " + j1.getPrise(jeuTest) + " allumettes.");
    }

    @Test
    public void testerPriseMaximum() {
        try {
                jeuTest.retirer(11);
        } catch (CoupInvalideException e) {}
        assertEquals("La stratégie rapide doit donner 2 (= nbAllumettesRestantes)",
                2, strategieA.choisir("Jane Doe", jeuTest));
        assertEquals("Le joueur avec stratégie rapide ne prend pas 2",
                2, j2.getPrise(jeuTest));
        // Affichage
        // System.out.println("Allumettes restantes : " + jeuTest.getNombreAllumettes());
        // System.out.println("Jane Doe prend " + strategieA.choisir("Jane Doe", jeuTest) + " allumettes.");
        // System.out.println(j2.getNom() + " prend " + j2.getPrise(jeuTest) + " allumettes.");

        try {
                jeuTest.retirer(1);
        } catch (CoupInvalideException e) {}
        assertEquals("La stratégie rapide doit donner 2 (= nbAllumettesRestantes)",
                1, strategieA.choisir("Jen Doe", jeuTest));
        assertEquals("Le joueur avec stratégie rapide ne prend pas 2",
                1, j2.getPrise(jeuTest));
        // Affichage
        // System.out.println("Allumettes restantes : " + jeuTest.getNombreAllumettes());
        // System.out.println("Jen Doe prend " + strategieA.choisir("Jen Doe", jeuTest) + " allumette.");
        // System.out.println(j2.getNom() + " prend " + j2.getPrise(jeuTest) + " allumettes.");
    }

}