package unitadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unitadmin.model.UnitAdmin;

import java.util.Optional;

public interface UnitAdminRepository extends JpaRepository<UnitAdmin, Long> {
    Optional<UnitAdmin> findByEmail(String email);

    static boolean existsByEmail(String email);
}