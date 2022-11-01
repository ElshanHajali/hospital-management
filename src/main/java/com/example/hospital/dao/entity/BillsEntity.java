package com.example.hospital.dao.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "bills")
public class BillsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private BigDecimal paidAmount;
    private boolean paid;

    @CreationTimestamp
    private LocalDateTime requestedAt;

    private Long queueNo;

    @OneToMany(mappedBy = "bill", cascade = ALL)
    @ToString.Exclude
    private List<ReceptionistsEntity> receptionists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillsEntity that)) return false;
        return paid == that.paid &&
                num.equals(that.num) &&
                paidAmount.equals(that.paidAmount) &&
                requestedAt.equals(that.requestedAt) &&
                queueNo.equals(that.queueNo) &&
                receptionists.equals(that.receptionists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, paidAmount, paid, requestedAt, queueNo, receptionists);
    }
}
