package dev.deklab.sensorapi.controller;

import dev.deklab.sensorapi.service.MeasurementService;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.deklab.model.Measurement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class MeasurementController {
    private final MeasurementService measurementService;

    MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping("/measurements")
    public List<Measurement> returnAllMeasurements() {
        return measurementService.returnAllMeasurements();
    }

    @GetMapping("/measurements/{id}")
    public Measurement returnMeasurementsById(@PathVariable Long id) {
        return measurementService.searchById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/measurements")
    @ResponseStatus(HttpStatus.CREATED)
    public Measurement postMeasurement(@RequestBody Measurement measurement) {
        return measurementService.save(measurement);
    }

}
