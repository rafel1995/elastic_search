package com.elastic.kibana.demo.repository;

import com.elastic.kibana.demo.model.LogEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogEventRepository extends ElasticsearchRepository<LogEvent, String> {
}
