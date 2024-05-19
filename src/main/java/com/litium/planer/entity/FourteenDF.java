package com.litium.planer.entity;

import com.litium.planer.dto.FourteenDFDto;
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
@Table(name = "df14")
@NoArgsConstructor
public class FourteenDF {
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
    private String oilfield;
    private String well;
    private String usedTon;
    private String coefLost;
    private String procLostPlan;
    private String procLostFact;
    private String comment;
    private LocalDate period;
    private LocalDateTime time;

    public FourteenDF(FourteenDFDto dfDto) {
        this.oilfield = dfDto.getOilfield();
        this.well = dfDto.getWell();
        this.usedTon = dfDto.getUsedTon();
        this.coefLost = dfDto.getCoefLost();
        this.procLostPlan = dfDto.getProcLostPlan();
        this.procLostFact = dfDto.getProcLostFact();
        this.comment = dfDto.getComment();
        this.period = dfDto.getPeriod();

    }
}
