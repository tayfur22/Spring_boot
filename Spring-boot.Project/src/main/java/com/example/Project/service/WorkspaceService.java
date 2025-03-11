package com.example.Project.service;

import com.example.Project.entity.Workspace;
import com.example.Project.entity.enums.WorkspaceType;
import com.example.Project.repository.WorkspaceRepository;
import com.example.Project.service.impl.BaseServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WorkspaceService extends BaseServiceImpl {

    private WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        super(workspaceRepository);
    }

    public List<Workspace> getAviableWorkspaces() {
        return workspaceRepository.findByAvailableTrue();
    }

    public List<Workspace> findWorkspaceByType(WorkspaceType type) {
        return workspaceRepository.findByWorkspaceType(type);
    }

}
