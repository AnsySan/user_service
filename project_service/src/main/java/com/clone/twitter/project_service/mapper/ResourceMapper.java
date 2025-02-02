package com.clone.twitter.project_service.mapper;

import com.clone.twitter.project_service.dto.resource.ResourceDto;
import com.clone.twitter.project_service.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResourceMapper {

    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "updatedById", target = "updatedBy.id")
    @Mapping(source = "projectId", target = "project.id")
    Resource toEntity(ResourceDto resourceDto);

    @Mapping(source = "createdBy.id", target = "createdById")
    @Mapping(source = "updatedBy.id", target = "updatedById")
    @Mapping(source = "project.id", target = "projectId")
    ResourceDto toDto(Resource resource);
}
