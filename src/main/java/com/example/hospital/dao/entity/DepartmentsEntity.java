package com.example.hospital.dao.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class DepartmentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private DoctorsEntity doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentsEntity that)) return false;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                doctor.equals(that.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, doctor);
    }
}
