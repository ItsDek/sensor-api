package dev.deklab.sensorapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.deklab.model.Measurement;
import dev.deklab.sensorapi.repository.MeasurementRepository;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    MeasurementService(MeasurementRepository measurementRepository){
        this.measurementRepository = measurementRepository;
    }
    public List<Measurement> returnAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Optional<Measurement> searchById(Long id) {
        return measurementRepository.findById(id);
    }
    public Measurement save(Measurement measurement){
        return measurementRepository.save(measurement);
    }
}
