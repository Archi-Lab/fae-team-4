package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.infrastructure.eventing.processed;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProcessedEventService {

    private final JpaProcessedEventRepository repository;

    public ProcessedEventService(final JpaProcessedEventRepository repository) {
        this.repository=repository;
    }

    public long getLastProcessedVersion(String topic, String key) {
        return Optional.ofNullable(repository.findByTopicAndKey(topic, key))
                .map(ProcessedEventEntity::getVersion)
                .orElse(0L);
    }

    public void updateLastProcessedVersion(String topic, String key, long version) {
        repository.save(new ProcessedEventEntity(key, topic, version));
    }
}
