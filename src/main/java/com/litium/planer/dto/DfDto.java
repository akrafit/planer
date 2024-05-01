package com.litium.planer.dto;

import com.litium.planer.entity.DF;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DfDto {
    private Long id;

    private String name;

    private String form;

    private String period;

    private String type;
    private List<String> users;

    public DfDto(DF df) {
        this.id = df.getId();
        this.form = df.getForm();
        this.name = df.getName();
        this.period = df.getPeriod();
        this.type = String.valueOf(df.getType());
        List<String> users = new ArrayList<>();
        df.getUser2DFS().forEach(user2DF -> users.add(user2DF.getUser().getName()));
        this.users = users;
    }
}
