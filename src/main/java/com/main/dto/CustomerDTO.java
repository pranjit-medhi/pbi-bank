package com.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDTO {

    private Long customerId;
    @Email(message = "Please provide valid email address")
    @NotNull()
    private String emailId;
    @NotNull()
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message="Name should contain only alphabets and space")
    private String customerName;
    @PastOrPresent(message = "Date of birth should be past or present date")
    private LocalDateTime dateOfBirth;

}
