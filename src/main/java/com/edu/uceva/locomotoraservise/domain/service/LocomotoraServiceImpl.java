package com.edu.uceva.locomotoraservise.domain.service;


import com.edu.uceva.locomotoraservise.domain.model.Locomotora;
import com.edu.uceva.locomotoraservise.domain.repository.ILocomotoraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocomotoraServiceImpl implements ILocomotoraService {

    ILocomotoraRepository locomotoraRepository;

    public  LocomotoraServiceImpl(ILocomotoraRepository locomotoraRepository) {
        this.locomotoraRepository = locomotoraRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Locomotora> findAll(Pageable pageable) {
        return locomotoraRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Locomotora save(Locomotora locomotora) {
        return locomotoraRepository.save(locomotora);
    }

    @Override
    @Transactional
    public void delete(Locomotora locomotora) {
        locomotoraRepository.delete(locomotora);
    }

    @Override
    @Transactional(readOnly = true)
    public Locomotora findById(long id) {
        return locomotoraRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Locomotora update(Locomotora locomotora) {
        return locomotoraRepository.save(locomotora);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Locomotora> findAll() {
        return (List<Locomotora>) locomotoraRepository.findAll();
    }

}
