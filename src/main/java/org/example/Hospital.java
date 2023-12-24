package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
@Table()
public class Hospital {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy ="org.hibernate.id.UUIDGenerator" )
    @Column(name = "id")
    private UUID id;
    @Column
    private String name;
    @Column
    private String sectionName;
    @Column
    private String address;
    @Column
    private String phone;
}
