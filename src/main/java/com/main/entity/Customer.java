package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Customer
{
    @Id
    private Long customerId;
    private String emailId;
    private String customerName;
    private LocalDateTime dateOfBirth;

}
