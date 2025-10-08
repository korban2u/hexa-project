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
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        // TBD
        resultat.clear();
        for (int i = 0; i < essai.length(); i++) {
            position = i;
            char carCourant = essai.charAt(i);
            Lettre evaluation = evaluationCaractere(carCourant);
            resultat.add(evaluation);
        }

    }

    // vrai si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        return resultat.stream().allMatch(res -> res.equals(Lettre.PLACEE));
    }

    public List<Lettre> lettresResultat() {
        return Collections.unmodifiableList(resultat);
    }

    // renvoie le statut du caractère (incorrect, mal placé, placé)
    private Lettre evaluationCaractere(char carCourant) {
        if (estPlace(carCourant))
            return Lettre.PLACEE;

        if (estPresent(carCourant))
            return Lettre.NON_PLACEE;

        return Lettre.INCORRECTE;
    }

    // vrai si le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        return motSecret.chars().anyMatch(c -> c == carCourant);
    }

    // vrai si le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        return motSecret.charAt(position) == carCourant;
    }
}
