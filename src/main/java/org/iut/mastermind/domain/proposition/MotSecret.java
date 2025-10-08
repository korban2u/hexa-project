package org.iut.mastermind.domain.proposition;

public class MotSecret {
    private final String motSecret;

    public MotSecret(String mot) {
        this.motSecret = mot;
    }

    // on retourne le résultat de la comparaison
    // du mot proposé avec le mot secret
    public Reponse compareProposition(String essai) {
        return Reponse.compare(essai,motSecret);
    }
}
