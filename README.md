# Jeu des 13 Allumettes

Ce projet est une implémentation avancée en **Java** du Jeu des 13 Allumettes. Réalisé dans le cadre du cours de **Technologie Objet (TOB)** de l'ENSEEIHT, l'objectif principal était de concevoir une architecture logicielle robuste et extensible en utilisant des principes de la **POO** et des **Patrons de Conception**.

***

*This project is an advanced **Java** implementation of the 13 Matchsticks Game. Developed for the Object Technology (TOB) course at ENSEEIHT, the main goal was to design a robust and extensible software architecture using **OOP** principles and **Design Patterns**.*

## Concepts Architecturaux Clés / Key Architectural Concepts

### 1. Le Pattern Stratégie (Strategy Pattern)

* **Implémentation:** Le comportement des joueurs (prise d'allumettes) est modélisé comme une interface de stratégie, permettant de basculer facilement entre différents niveaux d'intelligence artificielle.
* **Stratégies implémentées (Implemented Strategies):** `Humain`, `Naif` (aléatoire), `Rapide` (maximise la prise), `Expert` (stratégie gagnante), et `Tricheur`.

### 2. Le Pattern Procuration (Proxy Pattern)

* **Objectif:** Prévenir la **triche** en garantissant l'intégrité du jeu.
* **Fonctionnement:** Le joueur reçoit une instance de type **Proxy** au lieu du véritable objet `JeuReel` (Sujet Réel). Ce mandataire intercepte les appels à la méthode `retirer()` : si le joueur tente de modifier l'état du jeu illégalement (tricher), le Proxy lève une exception `OperationInterditeException`.
* **Défense contre la triche (Anti-Cheating):** Ceci protège le cœur du jeu des manipulations externes, sauf si l'arbitre est configuré en mode "-confiant".

### 3. Architecture Modulaire

* **Séparation des Responsabilités:** La conception est basée sur le diagramme de classe d'analyse fourni, garantissant une séparation nette entre l'état du jeu (`Jeu`), la logique des joueurs (`Joueur`), et la gestion du déroulement de la partie (`Arbitre`).
* **Gestion des Erreurs:** Utilisation d'exceptions contrôlées (`CoupInvalideException`) pour faire respecter les règles de jeu (e.g., ne prendre que 1 à 3 allumettes).

## Qualité et Tests / Quality and Testing

* **Tests Unitaires JUnit:** L'ensemble de la stratégie `Rapide` a été couvert par des tests unitaires complets en utilisant le framework **JUnit**.
* **Tests d'Intégration (Boîte Noire):** La robustesse de l'IHM et la conformité du programme ont été validées à l'aide du script `testeur.sh` fourni. Ce script lance une série de scénarios de jeu (fichiers `.run`) et compare la sortie du programme aux résultats attendus (`.expected`) pour garantir une correspondance parfaite.

## Exécution du Projet / Running the Project

Pour lancer une partie, utilisez la classe `allumettes.Jouer` avec le format `nom@stratégie` :

### Exemple Standard: Humain VS Naïf
```bash
java allumettes.Jouer Xavier@humain Ordinateur@naif
```

### Exemple de Triche Réussie (Arbitre Confient)
```bash
java allumettes.Jouer -confiant Ordinateur@rapide Xavier@tricheur
```
