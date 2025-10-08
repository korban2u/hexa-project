package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reponse {
    private final List<Lettre> resultat;

    private Reponse(List<Lettre> resultat) {
        this.resultat = List.copyOf(resultat);
    }

    // on récupère la lettre à la position spécifiée en paramètre dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public static Reponse compare(String essai, String motSecret) {
        // on regarde les lettre bien placé
        List<Boolean> lettresPlacees = IntStream.range(0, essai.length())
                .mapToObj(i -> i < motSecret.length() && essai.charAt(i) == motSecret.charAt(i))
                .toList();
        // on compte les lettres non utilisé par les lettres qui sont dans le mot secret
        List<Character> lettresDisponibles = IntStream.range(0, motSecret.length())
                .filter(i -> !lettresPlacees.get(i))
                .mapToObj(motSecret::charAt)
                .collect(Collectors.toCollection(ArrayList::new)); // de base j'avais un .toList() mais les tests passais pas...
                // vu que toList() renvoi une list immutable on peut pas faire le remove qui est dans evaluationCaractere()
                // merci chatgpt

        // on évalue chaque lettre de l'essai
        List<Lettre> evaluations = IntStream.range(0, essai.length())
                .mapToObj(i -> evaluationCaractere(essai.charAt(i), lettresPlacees.get(i), lettresDisponibles))
                .toList();

        return new Reponse(evaluations);
    }

    // vrai si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        return resultat.stream().allMatch(lettre -> lettre == Lettre.PLACEE);
    }

    public List<Lettre> lettresResultat() {
        return Collections.unmodifiableList(resultat);
    }

    // renvoie le statut du caractère (incorrect, mal placé, placé)
    private static Lettre evaluationCaractere(char lettre, boolean estPlacee, List<Character> lettresDisponibles) {
        if (estPlacee) {
            return Lettre.PLACEE;
        }

        // cherche si lettre dispo dans le mot secret
        int index = lettresDisponibles.indexOf(lettre);
        if (index != -1) {
            lettresDisponibles.remove(index); // marquer comme utilisé
            return Lettre.NON_PLACEE;
        }

        return Lettre.INCORRECTE;
    }

}


