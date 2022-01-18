package codegym.service;

import codegym.model.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    List<Staff> findAll();

    void save(Staff staff);

    void delete(Long id);

    Optional<Staff> findById(Long id);
}
