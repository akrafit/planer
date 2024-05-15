package com.litium.planer.entity;

import com.litium.planer.dto.ThirtyTwoDFDto;
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
@Table(name = "df32")
@NoArgsConstructor
public class ThirtyTwoDF {
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
    private String objectB;
    private LocalDate dateKo;
    private String typeGas;
    private LocalDate date;
    private String amt;
    private String comment;
    private LocalDateTime time;

    public ThirtyTwoDF(ThirtyTwoDFDto dfDto) {
        this.objectB = dfDto.getObjectB();
        this.dateKo = dfDto.getDateKo();
        this.typeGas = dfDto.getTypeGas();
        this.date = dfDto.getDate();
        this.amt = dfDto.getAmt();
        this.comment = dfDto.getComment();
        this.time = dfDto.getTime();
    }
}
