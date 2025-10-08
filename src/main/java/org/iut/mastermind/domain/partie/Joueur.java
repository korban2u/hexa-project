package org.iut.mastermind.domain.partie;

public record Joueur(String nom) {

    public String getNom() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

}
