package com.example.hospital.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctors")
public class DoctorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String phoneNo;

    private boolean available;

    @OneToMany(mappedBy = "doctor",cascade = ALL)
    @ToString.Exclude
    private List<PatientsEntity> patients;

    @OneToMany(mappedBy = "doctor", cascade = ALL)
    @ToString.Exclude
    private List<DepartmentsEntity> departments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoctorsEntity that)) return false;
        return available == that.available &&
                id.equals(that.id) &&
                name.equals(that.name) &&
                specialization.equals(that.specialization) &&
                phoneNo.equals(that.phoneNo) &&
                patients.equals(that.patients) &&
                departments.equals(that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specialization, phoneNo, available, patients, departments);
    }
}
