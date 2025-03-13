package com.example.Project.controller;

import com.example.Project.entity.Workspace;
import com.example.Project.entity.enums.WorkspaceType;
import com.example.Project.service.WorkspaceService;
import com.example.Project.service.impl.WorkspaceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Workspace>> getAvailableWorkspaces() {
        return ResponseEntity.ok(workspaceService.getAviableWorkspaces());
    }

    @PostMapping
    public ResponseEntity<Workspace> createWorkspace(@Valid @RequestBody Workspace workspace) {
        return ResponseEntity.ok((Workspace) workspaceService.save(workspace));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable("id") Long id) {
        workspaceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/workspaces")
    public ResponseEntity<List<Workspace>> findWorkspacesByType(@RequestParam WorkspaceType type) {
        return ResponseEntity.ok(workspaceService.findWorkspaceByType(type));
    }
}
