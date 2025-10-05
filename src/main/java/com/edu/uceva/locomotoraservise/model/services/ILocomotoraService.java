package com.edu.uceva.locomotoraservise.model.services;

import com.edu.uceva.locomotoraservise.model.entities.locomotora;
import java.util.List;

public interface ILocomotoraService {
    locomotora save(locomotora locomotora);
    void delete(locomotora locomotora);
    locomotora findById(locomotora locomotora);
    locomotora update(locomotora locomotora);
    List<locomotora> findAll();
}
