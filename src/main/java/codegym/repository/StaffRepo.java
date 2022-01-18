package codegym.repository;

import codegym.model.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepo extends CrudRepository<Staff, Long> {
}
