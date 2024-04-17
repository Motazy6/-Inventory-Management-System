package com.example.pro1.service;

import com.example.pro1.Entity.Manager;
import com.example.pro1.repository.ManagerRepsitory;

import java.util.List;
import java.util.Optional;

public class ManagerService {

    private ManagerRepsitory managerRepsitory;

    public ManagerService(ManagerRepsitory managerRepsitory) {
        this.managerRepsitory = managerRepsitory;

    }

    public List <Manager> getAllManagers() {
        return managerRepsitory.findAll();

    }

    public Optional<Manager> getManagerById(int id) {
        return  managerRepsitory.findById(id);

    }

    public Manager addManager(Manager manager) {
        return managerRepsitory.save(manager);

    }

    public Manager updateManager(int id, Manager updatedManager) {
        Optional<Manager> optionalManager = managerRepsitory.findById(id);
        if (optionalManager.isPresent()) {
            Manager existingManager = optionalManager.get();
            existingManager.setName(updatedManager.getName());
            existingManager.setEmail(updatedManager.getEmail());
            // Update any other fields as needed
            return managerRepsitory.save(existingManager);
        } else {
            // Handle the case where manager with given id does not exist
            return null;
        }
    }

    public void deleteManager(int id) {
        managerRepsitory.deleteById(id);
    }
}
