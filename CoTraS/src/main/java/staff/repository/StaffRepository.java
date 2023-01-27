package staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import staff.model.Staff;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmail(String email);

    boolean existsByEmail(String email);
}