package org.iut.mastermind.domain.partie;

import java.util.Objects;

public record Joueur(String nom) {

    public String getNom() {
        return nom;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(nom, joueur.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }
}
