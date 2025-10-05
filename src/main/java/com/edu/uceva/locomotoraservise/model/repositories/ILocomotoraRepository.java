package com.edu.uceva.locomotoraservise.model.repositories;

import com.edu.uceva.locomotoraservise.model.entities.Locomotora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocomotoraRepository extends CrudRepository<Locomotora, Long> {
}
