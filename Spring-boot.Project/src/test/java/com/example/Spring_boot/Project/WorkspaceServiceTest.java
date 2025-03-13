//package com.example.Spring_boot.Project;
//
//import com.example.Project.entity.Workspace;
//import com.example.Project.entity.enums.WorkspaceType;
//import com.example.Project.service.impl.WorkspaceServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//@ActiveProfiles("prod")  // PostgreSQL profilini istifadə et
//public class WorkspaceServiceTest {
//
//    @Autowired
//    private WorkspaceServiceImpl workspaceService;
//
//    @Test
//    public void testFilterWorkspacesByType() {
//        // Given
//        Workspace workspace = new Workspace();
//        workspace.setWorkspaceType(WorkspaceType.PRIVATE);
//        workspaceService.save(workspace);
//
//        // When
//        List<Workspace> workspaces = workspaceService.findWorkspaceByType(WorkspaceType.PRIVATE);
//
//        // Then
//        assertNotNull(workspaces);
//        assertEquals(1, workspaces.size());
//    }
//}
//
