package com.edu.uceva.locomotoraservise.controllers;


import com.edu.uceva.locomotoraservise.model.entities.Locomotora;
import com.edu.uceva.locomotoraservise.model.services.ILocomotoraService;
import com.edu.uceva.locomotoraservise.model.services.LocomotoraServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/Locomotora-service")
public class LocomotoraController {

    private ILocomotoraService iLocomotoraService;

    private static final String MENSAJE = "mensaje";
    private static final String LOCOMOTORA = "locomotora";
    private static final String LOCOMOTORAS = "locomotoras";

    @Autowired
    public LocomotoraController(ILocomotoraService iLocomotoraService) {
        this.iLocomotoraService = iLocomotoraService;
    }

    @GetMapping("/Locomotoras")
    /*public List<Locomotora> getLocomotoras() {
        return iLocomotoraService.findAll();
    }*/
    public ResponseEntity<Map<String, Object>> getLocomotoras() {
        List<Locomotora> locomotoras = iLocomotoraService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put(LOCOMOTORAS, locomotoras);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/Locomotoras")
   /* public Locomotora save(@RequestBody Locomotora locomotora) {
        return iLocomotoraService.save(locomotora);
    }*/
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Locomotora locomotora, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Error de validación");
            response.put("errores", result.getFieldErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Map<String, Object> response = new HashMap<>();
        Locomotora nuevaLocomotora = iLocomotoraService.save(locomotora);
        response.put(MENSAJE, "Locomotora creada con éxito");
        response.put(LOCOMOTORA, nuevaLocomotora);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/Locomotoras")
    /*public void delete(@RequestBody Locomotora locomotora) {
        iLocomotoraService.delete(locomotora);
    }*/
    public ResponseEntity<Map<String, Object>> delete(@Valid @RequestBody Locomotora locomotora, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Error de validación");
            response.put("errores", result.getFieldErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> response = new HashMap<>();
        iLocomotoraService.delete(locomotora);
        response.put(MENSAJE, "Locomotora eliminada con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/Locomotoras")
    /*public Locomotora update(@RequestBody Locomotora locomotora) {
        return  iLocomotoraService.update(locomotora);
    }*/
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Locomotora locomotora, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Error de validación");
            response.put("errores", result.getFieldErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> response = new HashMap<>();
        Locomotora locomotoraActualizada = iLocomotoraService.update(locomotora);
        response.put(MENSAJE, "Locomotora actualizada con éxito");
        response.put(LOCOMOTORA, locomotoraActualizada);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Locomotoras/{id}")
    /*public Locomotora findById(@PathVariable("id") long id) {
        return iLocomotoraService.findById(id);
    }*/
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") long id) {
        Map<String, Object> response = new HashMap<>();
        Locomotora locomotora = iLocomotoraService.findById(id);
        if (locomotora == null) {
            response.put(MENSAJE, "La locomotora con ID: ".concat(String.valueOf(id).concat(" no existe en la base de datos")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put(LOCOMOTORA, locomotora);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Locomotoras/page/{page}")
    public ResponseEntity<Page<Locomotora>> getLocomotorasPaginated(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4); // 4 elementos por página
        Page<Locomotora> locomotoraPage = iLocomotoraService.findAll(pageable);
        return ResponseEntity.ok(locomotoraPage);
    }

}
