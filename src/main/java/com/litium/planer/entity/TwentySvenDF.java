package com.litium.planer.entity;

import com.litium.planer.dto.TwentySvenDFDto;
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
@Table(name = "df27")
@NoArgsConstructor
public class TwentySvenDF {

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
    private List<TwentySevenCell> cellList;

    private String mvz;

    private String type;

    private String vid;

    private String nameChar;

    private String valueChar;

    private String specialChar;

    private String purpose;

    private LocalDateTime time;

    public TwentySvenDF(TwentySvenDFDto dfDto) {
        this.mvz = dfDto.getMvz();
        this.type = dfDto.getType();
        this.vid = dfDto.getVid();
        this.nameChar = dfDto.getNameChar();
        this.valueChar = dfDto.getValueChar();
        this.specialChar = dfDto.getSpecialChar();
        this.purpose = dfDto.getPurpose();
        this.time = dfDto.getTime();
    }
}
