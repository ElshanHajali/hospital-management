package com.example.hospital.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class RoomsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String location;
    private boolean available;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomsEntity that)) return false;
        return available == that.available &&
                num.equals(that.num) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, location, available);
    }
}
