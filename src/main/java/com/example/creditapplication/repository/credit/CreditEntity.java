package com.example.creditapplication.repository.credit;

import com.example.creditapplication.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "credit")
@Table(name = "credit")
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column()
    private String phoneNumber;

    @Column()
    private Integer monthlySalary;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Column(nullable = false)
    private Integer creditLimit;

    @Column(nullable = false)
    private Long identificationNumber;
}
