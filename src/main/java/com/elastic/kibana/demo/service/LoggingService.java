package com.elastic.kibana.demo.service;

import com.elastic.kibana.demo.model.LogEvent;
import com.elastic.kibana.demo.repository.LogEventRepository;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final LogEventRepository logEventRepository;

    public LoggingService(LogEventRepository logEventRepository) {
        this.logEventRepository = logEventRepository;
    }

    public void logEvent(String level, String message) {
        LogEvent event = new LogEvent(level, message);
        logEventRepository.save(event);
    }
}
