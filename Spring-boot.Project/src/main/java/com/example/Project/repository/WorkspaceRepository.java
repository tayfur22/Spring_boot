package com.example.Project.repository;

import com.example.Project.entity.Workspace;
import com.example.Project.entity.enums.WorkspaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepository extends BaseRepository<Workspace, Long> {
    List<Workspace> findByAvailableTrue();

    List<Workspace> findByWorkspaceType(WorkspaceType type);
}
