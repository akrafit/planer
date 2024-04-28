package com.litium.planer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "df")
public class DF {

    @Id
    private Long id;

    private String name;

    private String form;

    private String period;


}
