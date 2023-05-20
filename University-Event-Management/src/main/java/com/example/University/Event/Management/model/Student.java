package com.example.University.Event.Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="StudentId_Id")
    private Integer studentId;

    @Column(name="First_Name")
    @Pattern(regexp = "[A-Z][a-z]*", message = "First name should start with a capital letter")
    private String firstName;

    @NotBlank
    @Column(name="Last_Name")
    private String lastName;


    @Column(name="Age")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 25, message = "Age must not exceed 25")
    private Integer age;

    @Column(name="Department")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Department is mandatory")
    private Department department;

}

