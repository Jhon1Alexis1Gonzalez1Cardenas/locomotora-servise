package com.edu.uceva.locomotoraservise.model.services;

import com.edu.uceva.locomotoraservise.model.entities.Locomotora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocomotoraService {
    Locomotora save(Locomotora locomotora);
    void delete(Locomotora locomotora);
    Locomotora findById(long locomotora);
    Locomotora update(Locomotora locomotora);
    List<Locomotora> findAll();
    Page<Locomotora> findAll(Pageable pageable);
}
