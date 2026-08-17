package dev.deklab.sensorapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.deklab.model.Measurement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MeasurementController {
    Measurement m1 = new Measurement(1L, 21.5, 48);
    Measurement m2 = new Measurement(2L, 25.5, 38);
    Measurement m3 = new Measurement(3L, 29.5, 58);

    List<Measurement> measurements = List.of(m1, m2, m3);

    @GetMapping("/measurements")
    public List<Measurement> returnAllMeasurements() {
        return measurements;
    }

    @GetMapping("/measurements/{id}")
    public Measurement returnMeasurementsById(@PathVariable Long id) {
        for (int i = 0; i < measurements.size(); i++) {
            if (id.equals(measurements.get(i).id())) {
                return measurements.get(i);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
