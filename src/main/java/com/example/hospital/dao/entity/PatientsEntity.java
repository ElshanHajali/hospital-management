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
@Table(name = "patients")
public class PatientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNo;

    @OneToOne(mappedBy = "patient",
              cascade = ALL,
              fetch = LAZY)
    @ToString.Exclude
    private PatientDetailsEntity patientDetail;

    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private DoctorsEntity doctor;

    @ManyToOne(fetch = LAZY)
    @ToString.Exclude
    private ReceptionistsEntity receptionist;

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "patients_rooms",
               joinColumns = @JoinColumn(name = "patient_id"),
               inverseJoinColumns = @JoinColumn(name = "room_no")
    )
    @ToString.Exclude
    private List<RoomsEntity> rooms;

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "patients_bills",
               joinColumns = @JoinColumn(name = "patient_id"),
               inverseJoinColumns = @JoinColumn(name = "bill_no"))
    @ToString.Exclude
    private List<BillsEntity> bills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientsEntity that)) return false;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                phoneNo.equals(that.phoneNo) &&
                patientDetail.equals(that.patientDetail) &&
                doctor.equals(that.doctor) &&
                receptionist.equals(that.receptionist) &&
                rooms.equals(that.rooms) &&
                bills.equals(that.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNo, patientDetail, doctor, receptionist, rooms, bills);
    }
}
