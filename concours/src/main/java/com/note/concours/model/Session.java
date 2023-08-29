package com.gestion.concour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor


public class Session {
    private int id_sessions;
    private Date date_session;
    private String lieu;
}
