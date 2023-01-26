package edu.ecn.medev;

import java.util.Base64;
import java.util.Scanner;

/**
 * Cette classe permet de représenter une partie. Dans notre implémentation, une partie comporte un plateau de jeu.
 * Chaque partie se joue à deux. Par défaut, la partie contient 4 manches.
 *
 * @author Antoine FRIOGUT (antoine.frigout@eleves.ec-nantes.fr)
 * @author Mailys LE LOCH (mailys.le-loch@eleves.ec-nantes.fr)
 * @version 1.0
 */
public class Partie {

    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private int nombreMancheRestante;

    /**
     * Constructeur de la classe Partie. Le constructeur appelle la méthode init pour configurer la partie.
     */
    public Partie(){
        this.init();
    }

    /**
     * Cette méthode permet d'initialiser la partie.
     * Nous allons demander à l'utilisateur de choisir le nombre de partie qui seront jouées.
     * Ensuite nous demanderons le nom des deux joueurs.
     */
    public void init(){
        Scanner entreeutilisateur = new Scanner(System.in);

        // Description générale
        System.out.println("---------------------------------------------------");
        System.out.println("MASTERMIND - ECN - [FRIGOUT - LE-LOCH]");
        System.out.println("Nous allons maintenant configurer la partie...");

        // Choix du nombre de manche
        System.out.println("---------------------------------------------------");
        System.out.println("Veuillez choisir le nombre de partie (entier et pair) : ");
        int nbPartie = 4;
        try {
            nbPartie = entreeutilisateur.nextInt();
            if (nbPartie % 2 != 0){
                nbPartie = nbPartie + 1;
                System.out.println("Attention le nombre n'est pas pair, nous utiliserons " + nbPartie);
            }
        } catch (Exception e){
            System.out.println("Nombre de partie erronée, nous utiliserons donc 4 parties...");
        }
        this.nombreMancheRestante = nbPartie;
        System.out.println("Nombre de partie choisie : " + this.nombreMancheRestante);
        System.out.println("---------------------------------------------------");

        // Choix des joueurs
        System.out.println("Création du joueur 1, ce joueur commencera en tant que codeur.");
        System.out.println("Joueur 1, quel est votre nom ? ");
        String nomJoueur1 = entreeutilisateur.next();
        System.out.println("Bonjour " + nomJoueur1);
        this.joueur1 = new Joueur(nomJoueur1);
        this.joueur1 = new Codeur(joueur1);
        System.out.println("Création du joueur 2, ce joueur commencera en tant que decodeur.");
        System.out.println("Joueur 2, quel est votre nom ? ");
        String nomJoueur2 = entreeutilisateur.next();
        System.out.println("Bonjour " + nomJoueur2);
        this.joueur2 = new Joueur(nomJoueur2);
        this.joueur2 = new Decodeur(joueur2);
        System.out.println("---------------------------------------------------");
        System.out.println("Commençons la partie!");
        System.out.println("---------------------------------------------------");
    }

    /**
     * cette méthode permet de débuter une nouvelle manche.
     */
    public void nouvelleManche(){
        System.out.println("---------------------------------------------------");
        System.out.println("Début d'une nouvelle manche (il en reste " + nombreMancheRestante + ")");
        System.out.println(joueur1.getNom() + " vous avez " + joueur1.getScore() + " point(s)!");
        System.out.println(joueur2.getNom() + " vous avez " + joueur2.getScore() + " point(s)!");
        System.out.println("---------------------------------------------------");
        Combinaison objectif = new Combinaison();
        if(joueur1 instanceof Codeur){
            objectif = (Codeur)joueur1.choisirObjectif();
        } else {
            objectif = (Codeur)joueur2.choisirObjectif();
        }
        this.plateau.setObjectif(objectif);
        for(int tourCourant = 1; tourCourant < 13; tourCourant ++){
            System.out.println("Debut du tour " + tourCourant);
            Combinaison proposition = new Combinaison();
            Combinaison indication = new Combinaison();
            if(joueur1 instanceof Codeur){
                System.out.println(joueur2.getName() + " a vous de jouer, voici le plateau...");
                System.out.println(plateau.affiche());
                proposition = (Decodeur)joueur2.jouer();
                this.plateau.getListeTentative().add(proposition);

                System.out.println(joueur1.getName() + " a vous de jouer, voici le plateau...");
                System.out.println(plateau.affiche());
                indication = (Codeur)joueur1.jouer(proposition, plateau.getObjectif());
                this.plateau.getListeIndication().add(indication);
            } else {
                System.out.println(joueur1.getName() + " a vous de jouer, voici le plateau...");
                System.out.println(plateau.affiche());
                indication = (Decodeur)joueur1.jouer(proposition, plateau.getObjectif());
                this.plateau.getListeIndication().add(indication);

                System.out.println(joueur2.getName() + " a vous de jouer, voici le plateau...");
                System.out.println(plateau.affiche());
                proposition = (Codeur)joueur2.jouer();
                this.plateau.getListeTentative().add(proposition);
            }

            if (proposition.equals(plateau.getObjectif())){
                System.out.println("Victoire !!! Vous avez deviné la combinaison !");
                this.terminePartie(tourCourant);
            }
        }
        this.terminePartie(tourCourant);
    }

    /**
     * CEtte méthode gère la fin d'une partie en mettant à jour les scores, puis elle va changer les joeuurs et enfin remettre à vide le plateau.
     * @param nbToursJoues Le nombre de tours joues dans la partie.
     */
    public void terminePartie(int nbToursJoues){
        if (joueur1 instanceof Codeur){
            this.joueur1.setScore(this.joueur1.getScore() + nbToursJoues);
            this.joueur1 = new Decodeur(joueur1);
            this.joueur2 = new Codeur(joueur2);
        } else {
            this.joueur2.setScore(this.joueur2.getScore() + nbToursJoues);
            this.joueur1 = new Codeur(joueur1);
            this.joueur2 = new Decodeur(joueur2);
        }
        this.plateau.reset();
        this.nombreMancheRestante = this.nombreMancheRestante - 1;
        // Gestion de fin de partie
        if (this.nombreMancheRestante == 0){
            this.terminerPartie();
        } else {
            this.nouvelleManche();
        }
    }

    /**
     * Méthode permettant de terminer la partie et d'ajouter les résultats finaux.
     */
    public void terminerPartie(){
        int scoreJ1 = this.joueur1.getScore();
        int scoreJ2 = this.joueur2.getScore();

        if(scoreJ1 > scoreJ2){
            System.out.println("---------------------------------------------------");
            System.out.println(this.joueur1.getName() + " vous avez gagné avec " + this.joueur1.getScore() + " point(s)!");
            System.out.println(this.joueur2.getName() + " vous avez perdu avec " + this.joueur2.getScore() + " point(s)!");
            System.out.println("---------------------------------------------------");
        } else if(scoreJ2 > scoreJ1){
            System.out.println("---------------------------------------------------");
            System.out.println(this.joueur2.getName() + " vous avez gagné avec " + this.joueur2.getScore() + " point(s)!");
            System.out.println(this.joueur1.getName() + " vous avez perdu avec " + this.joueur1.getScore() + " point(s)!");
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("---------------------------------------------------");
            System.out.println("Égalité avec " + this.joueur2.getScore() + " point(s)!");
            System.out.println("---------------------------------------------------");
        }
    }
}
