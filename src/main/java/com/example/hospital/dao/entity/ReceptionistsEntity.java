package com.example.hospital.dao.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receptionists")
public class ReceptionistsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "receptionist", cascade = ALL)
    @ToString.Exclude
    private List<PatientsEntity> patients;

    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private BillsEntity bill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReceptionistsEntity that)) return false;
        return id.equals(that.id) &&
                name.equals(that.name) && patients.equals(that.patients) && bill.equals(that.bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patients, bill);
    }
}
