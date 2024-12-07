package com.elastic.kibana.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.time.Instant;

@Document(indexName = "app-logs")
@Data
public class LogEvent {
    @Id
    private String id;
    private String level;
    private String message;
    @Field(type = FieldType.Date)
    private Instant timestamp;

    public LogEvent(String level, String message) {
        this.level = level;
        this.message = message;
        this.timestamp = Instant.now();
    }
}
