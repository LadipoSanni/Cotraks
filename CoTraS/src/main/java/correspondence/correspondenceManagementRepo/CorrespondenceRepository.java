package correspondence.correspondenceManagementRepo;



import org.springframework.data.jpa.repository.JpaRepository;
import correspondence.model.Correspondence;

public interface CorrespondenceRepository extends JpaRepository<Correspondence, Long> {
}
