package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position spécifiée en paramètre dans le résultat
    public Lettre lettre(int position) {
        return null;
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        // TBD
    }

    // vrai si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        return false;
    }

    public List<Lettre> lettresResultat() {
        return Collections.unmodifiableList(resultat);
    }

    // renvoie le statut du caractère (incorrect, mal placé, placé)
    private Lettre evaluationCaractere(char carCourant) {
        return null;
    }

    // vrai si le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        return false;
    }

    // vrai si le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        return false;
    }
}
