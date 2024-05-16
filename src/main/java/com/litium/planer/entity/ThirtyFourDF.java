package com.litium.planer.entity;

import com.litium.planer.dto.ThirtyFourDFDto;
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
@Table(name = "df34")
@NoArgsConstructor
public class ThirtyFourDF {
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
    private String bosom;
    private String type;
    private String target;
    private String place;
    private String mark;
    private String amt;
    private LocalDate period;
    private LocalDateTime time;

    public ThirtyFourDF(ThirtyFourDFDto dfDto) {
        this.bosom = dfDto.getBosom();
        this.type = dfDto.getType();
        this.target = dfDto.getTarget();
        this.place = dfDto.getPlace();
        this.mark = dfDto.getMark();
        this.amt = dfDto.getAmt();
        this.period = dfDto.getPeriod();
    }
}
