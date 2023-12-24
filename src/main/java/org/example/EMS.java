package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
@Table()
public class EMS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDate dayOfService;

    @ManyToOne
    @JoinColumn()
    private Transport transport;
    @ManyToOne
    @JoinColumn()
    private Hospital hospital;
    @ManyToOne
    @JoinColumn()
    private Profile profile;

    @Enumerated(EnumType.STRING)
    private LevelOfUrgency levelOfUrgency;

}
