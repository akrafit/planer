package com.litium.planer.entity;

import com.litium.planer.dto.TwentySixDFDto;
import com.litium.planer.entity.cell.TwentySixCell;
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
@Table(name = "df26")
@NoArgsConstructor
public class TwentySixDF {

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
    private List<TwentySixCell> cellList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mvz_id")
    private Mvz mvz;

    private String type;
    private String nomenclature;
    private String typeCar;
    private String valueCar;
    private String typeWork;
    private String purpose;
    private String startPoint;
    private String endPoint;
    private String comment;
    private LocalDateTime time;

    public TwentySixDF(TwentySixDFDto dfDto) {
        this.id = dfDto.getId();
        this.type = dfDto.getType();
        this.nomenclature = dfDto.getNomenclature();
        this.typeCar = dfDto.getTypeCar();
        this.valueCar = dfDto.getValueCar();
        this.typeWork = dfDto.getTypeWork();
        this.purpose = dfDto.getPurpose();
        this.startPoint = dfDto.getStartPoint();
        this.endPoint = dfDto.getEndPoint();
        this.comment = dfDto.getComment();
        this.time = dfDto.getTime();
    }
}
