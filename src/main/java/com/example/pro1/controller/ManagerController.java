package com.example.pro1.controller;

import com.example.pro1.Entity.Manager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pro1.service.ManagerService;

import java.util.List;


public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;

    }


    @GetMapping("/manager")
    public ResponseEntity<List<Manager>> getAllManager() {
        List<Manager> manager = managerService.getAllManagers();
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PostMapping("/manager")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        Manager createdManager = managerService.addManager(manager);
        return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }

    @PutMapping("/manager")
    public ResponseEntity<Manager> updateManager(@PathVariable("id") int id, @RequestBody Manager manager) {
        Manager updatedManager = managerService.updateManager(id, manager);
        if (updatedManager != null) {
            return new ResponseEntity<>(updatedManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/manager")
    public ResponseEntity<Manager> patchManager(@PathVariable("id") int id, @RequestBody Manager manager) {
        Manager patchedManager = managerService.updateManager(id, manager);
        if (patchedManager != null) {
            return new ResponseEntity<>(patchedManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/manager")
    public ResponseEntity<Void> deleteManager(@PathVariable("id") int id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



