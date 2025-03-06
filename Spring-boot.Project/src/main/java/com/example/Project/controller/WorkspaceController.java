package com.example.Project.controller;

import com.example.Project.entity.Workspace;
import com.example.Project.service.WorkspaceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public List<Workspace> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @PostMapping
    public Workspace createWorkspace(@Valid @RequestBody Workspace workspace) {
        return workspaceService.saveWorkspace(workspace);
    }
}
