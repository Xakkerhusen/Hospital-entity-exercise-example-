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
public class Profile {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy ="org.hibernate.id.UUIDGenerator" )
    @Column(name = "ssn")
    private UUID ssn;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private UUID driverCertificate;

}
