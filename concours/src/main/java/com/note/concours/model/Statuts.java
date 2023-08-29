package com.gestion.concour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor


public class Statuts {

    private int id_statuts;
    private int id_candidat;
    private int id_note;
    private boolean admis;

}
