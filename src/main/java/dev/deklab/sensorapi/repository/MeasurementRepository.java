package dev.deklab.sensorapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import dev.deklab.model.Measurement;

@Repository
public class MeasurementRepository {
    private final ConcurrentHashMap<Long, Measurement> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Measurement> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Measurement> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Measurement save(Measurement measurement){
        Long newId = idGenerator.incrementAndGet();
        Measurement saved = new Measurement(newId,measurement.temperature(),measurement.humidity());
        store.put(newId, saved);
        return saved;
    }

}
