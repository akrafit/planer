package com.litium.planer.entity;

import com.litium.planer.dto.TwentyFourDFDto;
import com.litium.planer.entity.cell.TwentyFourCell;
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
@Table(name = "df24")
@NoArgsConstructor
public class TwentyFourDF {
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
    private List<TwentyFourCell> cellList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mvz_id")
    private Mvz mvz;

    private String name;
    private String comment;
    private LocalDateTime time;

    public TwentyFourDF(TwentyFourDFDto dfDto) {
        this.id = dfDto.getId();
        this.name = dfDto.getName();
        this.comment = dfDto.getComment();
        this.time = dfDto.getTime();
    }
}
