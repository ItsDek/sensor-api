package dev.deklab.sensorapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.deklab.model.Measurement;

@Service
public class MeasurementService {
    private Measurement m1 = new Measurement(1L, 21.5, 48);
    private Measurement m2 = new Measurement(2L, 25.5, 38);
    private Measurement m3 = new Measurement(3L, 29.5, 58);

    private List<Measurement> measurements = List.of(m1, m2, m3);
    public List<Measurement> returnAllMeasurements(){
            return measurements;
    }
    public Optional<Measurement> searchById(Long id){
        for (int i = 0; i < measurements.size(); i++) {
            if (id.equals(measurements.get(i).id())) {
                return Optional.of(measurements.get(i));
            }
        }
        return Optional.empty();
    }
}
