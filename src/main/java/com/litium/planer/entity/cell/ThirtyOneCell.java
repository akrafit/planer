package com.litium.planer.entity.cell;

import com.litium.planer.entity.ThirtyOneDF;
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
@Table(name = "cell31")
@NoArgsConstructor
public class ThirtyOneCell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "df_id")
    private ThirtyOneDF df;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Long value;

    private LocalDate period;

    private LocalDateTime time;
}
