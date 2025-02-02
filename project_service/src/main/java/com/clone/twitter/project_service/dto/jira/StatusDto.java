package com.clone.twitter.project_service.dto.jira;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StatusDto {
    private Long id;
    private String description;
}
