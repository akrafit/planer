package com.litium.planer.entity.cell;

import com.litium.planer.entity.ThirtySixDF;
import com.litium.planer.entity.TwentySixDF;
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
@Table(name = "cell36")
@NoArgsConstructor
public class ThirtySixCell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "df_id")
    private ThirtySixDF df;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Double value;

    private LocalDate period;

    private LocalDateTime time;
}
