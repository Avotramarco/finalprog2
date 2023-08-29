package com.gestion.concour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class Condidats {
    private int id_candidats;
    private String nom;
    private String prenom;
    private boolean statut_admission;
}
