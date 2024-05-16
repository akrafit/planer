package com.litium.planer.entity;

import com.litium.planer.dto.ThirtySixDFDto;
import com.litium.planer.entity.cell.ThirtySixCell;
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
@Table(name = "df36")
@NoArgsConstructor
public class ThirtySixDF {
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
    private List<ThirtySixCell> cellList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mvz_id")
    private Mvz mvz;
    private String name;
    private String unit;
    private LocalDateTime time;
    public ThirtySixDF(ThirtySixDFDto dfDto) {
        this.id = dfDto.getId();
        this.name = dfDto.getName();
        this.unit = dfDto.getUnit();
        this.time = dfDto.getTime();
    }
}
