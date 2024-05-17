package com.litium.planer.entity;

import com.litium.planer.dto.EightDFDto;
import com.litium.planer.entity.cell.EightCell;
import com.litium.planer.model.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "df8")
@NoArgsConstructor
public class EightDF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "df_id")
    private DF df;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "df_id", nullable = false, insertable = false, updatable = false)
    private List<EightCell> cellList;

    private String name;
    private String typeWater;
    private String oilfield;
    private String well;
    private LocalDateTime time;

    public EightDF(EightDFDto dfDto) {
        this.name = dfDto.getName();
        this.typeWater = dfDto.getTypeWater();
        this.oilfield = dfDto.getOilfield();
        this.well = dfDto.getWell();
    }
}
