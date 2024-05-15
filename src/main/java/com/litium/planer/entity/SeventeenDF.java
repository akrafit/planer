package com.litium.planer.entity;

import com.litium.planer.dto.SeventeenDFDto;
import com.litium.planer.model.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "df17")
@NoArgsConstructor
public class SeventeenDF {
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

    private String typeOil;
    private String affiliation;
    private String oilName;
    private LocalDate date;
    private String amt;
    private String comment;
    private LocalDateTime time;

    public SeventeenDF(SeventeenDFDto dfDto) {
        this.typeOil = dfDto.getTypeOil();
        this.affiliation = dfDto.getAffiliation();
        this.oilName = dfDto.getOilName();
        this.date = dfDto.getDate();
        this.amt = dfDto.getAmt();
        this.comment = dfDto.getComment();
        this.time = dfDto.getTime();
    }
}
