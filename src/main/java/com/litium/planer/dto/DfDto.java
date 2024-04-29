package com.litium.planer.dto;

import com.litium.planer.entity.DF;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DfDto {
    private Long id;

    private String name;

    private String form;

    private String period;

    public DfDto(DF df) {
        this.id = df.getId();
        this.form = df.getForm();
        this.name = df.getName();
        this.period = df.getPeriod();
    }
}
