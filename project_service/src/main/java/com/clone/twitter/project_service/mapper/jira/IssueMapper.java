package com.clone.twitter.project_service.mapper.jira;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.clone.twitter.project_service.dto.jira.IssueDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {IssueTypeMapper.class, StatusMapper.class})
public interface IssueMapper {

    @Mapping(source = "project.key", target = "projectKey")
    IssueDto toDto(Issue issue);

    @Mapping(source = "projectKey", target = "project.key")
    Issue toEntity(IssueDto issueDto);

    List<IssueDto> toDto(List<Issue> issues);
}