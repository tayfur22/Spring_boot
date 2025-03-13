package com.example.Project.service.impl;

import com.example.Project.entity.Workspace;
import com.example.Project.entity.enums.WorkspaceType;
import com.example.Project.repository.WorkspaceRepository;
import com.example.Project.service.WorkspaceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Autowired
    public WorkspaceServiceImpl(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public List<Workspace> getAll() {
        return workspaceRepository.findAll();
    }

    @Override
    public Optional<Workspace> getById(Long aLong) {
        return workspaceRepository.findById(aLong);
    }


    @Override
    public Workspace save(Workspace entity) {
        return workspaceRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        workspaceRepository.deleteById(aLong);
    }

    @Override
    public List<Workspace> getAviableWorkspaces() {
        return workspaceRepository.findByAvailableTrue();
    }

    @Override
    public List<Workspace> findWorkspaceByType(WorkspaceType type) {
        return workspaceRepository.findByWorkspaceType(type);
    }

}
