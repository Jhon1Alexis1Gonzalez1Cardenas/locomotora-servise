package com.edu.uceva.locomotoraservise.controllers;


import com.edu.uceva.locomotoraservise.model.entities.Locomotora;
import com.edu.uceva.locomotoraservise.model.services.ILocomotoraService;
import com.edu.uceva.locomotoraservise.model.services.LocomotoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Locomotora-service")
public class LocomotoraController {

    private ILocomotoraService iLocomotoraService;

    @Autowired
    public LocomotoraController(ILocomotoraService iLocomotoraService) {
        this.iLocomotoraService = iLocomotoraService;
    }

    @GetMapping("/Locomotoras")
    public List<Locomotora> getLocomotoras() {
        return iLocomotoraService.findAll();
    }

    @PostMapping("/Locomotoras")
    public Locomotora save(@RequestBody Locomotora locomotora) {
        return iLocomotoraService.save(locomotora);
    }

    @DeleteMapping("/Locomotoras")
    public void delete(@RequestBody Locomotora locomotora) {
        iLocomotoraService.delete(locomotora);
    }

    @PutMapping("/Locomotoras")
    public Locomotora update(@RequestBody Locomotora locomotora) {
        return  iLocomotoraService.update(locomotora);
    }

    @GetMapping("/Locomotoras/{id}")
    public Locomotora findById(@PathVariable("id") long id) {
        return iLocomotoraService.findById(id);
    }

    @GetMapping("/Locomotoras/page/{page}")
    public ResponseEntity<Page<Locomotora>> getLocomotorasPaginated(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4); // 4 elementos por página
        Page<Locomotora> locomotoraPage = iLocomotoraService.findAll(pageable);
        return ResponseEntity.ok(locomotoraPage);
    }

}
