package com.litium.planer.entity;

import com.litium.planer.dto.ThirtyOneDFDto;
import com.litium.planer.model.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "df31")
@NoArgsConstructor
public class ThirtyOneDF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "df_id")
    private DF df;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mvz_id")
    private Mvz mvz;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "df_id", nullable = false, insertable = false, updatable = false)
    private List<ThirtyOneCell> cellList;

    private String target;
    private String nomenclature;
    private String affiliation;
    private String stock;
    private String comment;
    private LocalDateTime time;

    public ThirtyOneDF(ThirtyOneDFDto dfDto) {
        this.target = dfDto.getTarget();
        this.nomenclature = dfDto.getNomenclature();
        this.affiliation = dfDto.getAffiliation();
        this.stock = dfDto.getStock();
        this.comment = dfDto.getComment();
        this.time = dfDto.getTime();

    }
}
