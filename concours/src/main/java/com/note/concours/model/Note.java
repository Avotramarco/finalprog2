package com.gestion.concour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Note {
    private int id_notes;
    private float note_mathematique;
    private float note_francais;

}
