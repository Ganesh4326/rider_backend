package com.rider.rider.rides.util.converters;

import jakarta.persistence.AttributeConverter;

import java.time.Duration;

public class DurationToLongConverter implements AttributeConverter<Duration, Long> {
    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        return duration == null ? null : duration.getSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(Long seconds) {
        return seconds == null ? null : Duration.ofSeconds(seconds);
    }
}
