package com.clone.twitter.project_service.filter;

import com.clone.twitter.project_service.dto.filter.ProjectFilterDto;
import com.clone.twitter.project_service.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProjectNameFilterTest {
    @Spy
    private ProjectNameFilter projectNameFilter;

    private ProjectFilterDto projectFilterDto;
    private Project project;

    @BeforeEach
    void init() {
        projectFilterDto = ProjectFilterDto.builder().name("Name").build();
        project = Project.builder().name("Name").build();
    }

    @Test
    public void testIsApplicableGood() {
        assertTrue(projectNameFilter.isApplicable(projectFilterDto));
    }

    @Test
    public void testIaApplicableBad() {
        projectFilterDto.setName(null);
        assertFalse(projectNameFilter.isApplicable(projectFilterDto));
    }

    @Test
    public void testApply() {
        List<Project> result = projectNameFilter.apply(Stream.of(project), projectFilterDto).toList();
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), project);
    }
}
