package com.aenumz.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
}
