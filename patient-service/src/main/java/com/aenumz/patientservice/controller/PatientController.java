package com.aenumz.patientservice.controller;

import com.aenumz.patientservice.dto.PatientRequestDTO;
import com.aenumz.patientservice.dto.PatientResponseDTO;
import com.aenumz.patientservice.dto.validator.CreatePatientValidationGroup;
import com.aenumz.patientservice.service.PatientService;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/")
    public ResponseEntity<List<PatientResponseDTO>> index() {
        List<PatientResponseDTO> patients = patientService.index();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping("/store")
    public ResponseEntity<PatientResponseDTO> store(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientResponseDTO patientResponseDTO = this.patientService.store(patientRequestDTO);

        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientResponseDTO> update(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientResponseDTO patientResponseDTO = this.patientService.updatePatient(id, patientRequestDTO);

        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
