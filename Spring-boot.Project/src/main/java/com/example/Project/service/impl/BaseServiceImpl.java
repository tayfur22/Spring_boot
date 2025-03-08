package com.example.Project.service.impl;

import com.example.Project.repository.BaseRepository;
import com.example.Project.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    private final BaseRepository<T,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T,ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<T> getAll() {
        return baseRepository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public T save(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }
}
