package com.main.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDTO {

    private Long customerId;
    private String emailId;
    private String customerName;
    private LocalDateTime dateOfBirth;

}
