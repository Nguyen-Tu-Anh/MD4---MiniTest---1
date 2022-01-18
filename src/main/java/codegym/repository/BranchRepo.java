package codegym.repository;

import codegym.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepo extends CrudRepository<Branch, Long> {
}
