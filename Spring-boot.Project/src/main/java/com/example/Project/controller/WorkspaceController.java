package com.example.Project.controller;

import com.example.Project.entity.Workspace;
import com.example.Project.entity.enums.WorkspaceType;
import com.example.Project.service.WorkspaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public List<Workspace> getAllWorks() {
        return workspaceService.getAll();
    }

    @GetMapping("/available")
    public List<Workspace> getAvailableWorkspaces() {
        return workspaceService.getAviableWorkspaces();
    }

    @PostMapping
    public Workspace createWorkspace(@Valid @RequestBody Workspace workspace) {
        return (Workspace) workspaceService.save(workspace);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkspace(@PathVariable("id") Long id) {
        workspaceService.deleteById(id);
    }

    @GetMapping("/workspaces")
    public List<Workspace> findWorkspacesByType(@RequestParam WorkspaceType type) {
        return workspaceService.findWorkspaceByType(type);
    }
}
