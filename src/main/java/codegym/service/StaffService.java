package codegym.service;

import codegym.model.Staff;
import codegym.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StaffService implements IStaffService{
    @Autowired
    StaffRepo staffRepo;
    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(Long id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepo.findById(id);
    }
}
