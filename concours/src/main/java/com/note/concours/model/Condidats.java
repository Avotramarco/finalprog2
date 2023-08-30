package com.note.concours.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Condidats {
    private int id_candidats;
    private String nom;
    private String prenom;
    private boolean statut_admission;
}
