package com.example.hospital.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient_details")
public class PatientDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private byte age;
    private String sex;

    private BigDecimal balance;

    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private PatientsEntity patient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientDetailsEntity that)) return false;
        return age == that.age &&
                id.equals(that.id) &&
                address.equals(that.address) &&
                sex.equals(that.sex) &&
                balance.equals(that.balance) &&
                patient.equals(that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, age, sex, balance, patient);
    }
}
