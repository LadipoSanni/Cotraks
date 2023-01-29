package correspondence.correspondenceManagementService;

import java.util.List;

import correspondence.correspondenceManagementRepo.CorrespondenceRepository;
import exceptions.classs.CtsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import correspondence.model.Correspondence;


@Service
public class CorrespondenceService {
    @Autowired
    private CorrespondenceRepository correspondenceRepository;

    public List<Correspondence> getAllCorrespondences() {
        return correspondenceRepository.findAll();
    }

    public Correspondence getCorrespondenceById(Long id) {
        return correspondenceRepository.findById(id).orElse(null);
    }

    public Correspondence createCorrespondence(Correspondence correspondence) {
        return correspondenceRepository.save(correspondence);
    }

    public Correspondence updateCorrespondence(Correspondence correspondence) {
        return correspondenceRepository.save(correspondence);
    }

    public void deleteCorrespondence(Long id) {
        correspondenceRepository.deleteById(id);
    }

    public List<Correspondence> findAll() {
        return correspondenceRepository.findAll();
    }

    public Correspondence findById(Long id) {
        return correspondenceRepository.findById(id).orElse(null);
    }

    public Correspondence create(Correspondence correspondence) {
        return correspondence.create(correspondence);
    }

    public Correspondence update(Long id, Correspondence updatedCorrespondence) {
        return correspondenceRepository.findById(id)
                .map(correspondence -> {
                    correspondence.setCompanyName(updatedCorrespondence.getCompanyName());
                    correspondence.setCorrespondence(updatedCorrespondence.getCorrespondence());
                    correspondence.setCorType(updatedCorrespondence.getCorType());
                    correspondence.setDepartment(updatedCorrespondence.getDepartment());
                    correspondence.setSubDepartment(updatedCorrespondence.getSubDepartment());
                    correspondence.setPhoneNumber(updatedCorrespondence.getPhoneNumber());
                    correspondence.setEmail(updatedCorrespondence.getEmail());
                    return correspondenceRepository.save(correspondence);
                })
                .orElseThrow(() -> new CtsException("Correspondence not found with id " + id));
    }

    public void delete(Long id) {
        correspondenceRepository.deleteById(id);
    }

}

