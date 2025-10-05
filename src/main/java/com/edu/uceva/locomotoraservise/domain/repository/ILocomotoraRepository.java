package com.edu.uceva.locomotoraservise.domain.repository;

import com.edu.uceva.locomotoraservise.domain.model.Locomotora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocomotoraRepository extends JpaRepository<Locomotora, Long> {
}
