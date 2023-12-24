package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@ToString
@Entity
@Table()
public class WorkShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalTime startTime;
    @Column
    private Integer durationHour;

    @ManyToOne
    @JoinColumn()
    private Profile profile;
}
