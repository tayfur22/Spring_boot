package com.example.Project.service;

import com.example.Project.entity.Workspace;
import com.example.Project.entity.enums.WorkspaceType;

import java.util.List;

public interface WorkspaceService extends BaseService<Workspace, Long> {
    List<Workspace> getAviableWorkspaces();

    List<Workspace> findWorkspaceByType(WorkspaceType type);
}