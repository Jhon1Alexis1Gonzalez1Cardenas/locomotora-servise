package com.edu.uceva.locomotoraservise.model.services;


import com.edu.uceva.locomotoraservise.model.entities.Locomotora;
import com.edu.uceva.locomotoraservise.model.repositories.ILocomotoraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocomotoraServiceImpl implements ILocomotoraService {

    ILocomotoraRepository locomotoraRepository;

    public  LocomotoraServiceImpl(ILocomotoraRepository locomotoraRepository) {
        this.locomotoraRepository = locomotoraRepository;
    }

    @Override
    public Locomotora save(Locomotora locomotora) {
        return locomotoraRepository.save(locomotora);
    }

    @Override
    public void delete(Locomotora locomotora) {
        locomotoraRepository.delete(locomotora);
    }

    @Override
    public Locomotora findById(Locomotora locomotora) {
        return locomotoraRepository.findById(locomotora.getId()).orElse(null);
    }

    @Override
    public Locomotora update(Locomotora locomotora) {
        return locomotoraRepository.save(locomotora);
    }

    @Override
    public List<Locomotora> findAll() {
        return (List<Locomotora>) locomotoraRepository.findAll();
    }

}
