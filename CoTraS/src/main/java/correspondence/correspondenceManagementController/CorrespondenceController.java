package correspondence.correspondenceManagementController;


import correspondence.correspondenceManagementService.CorrespondenceService;
import correspondence.model.Correspondence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correspondences")
public class CorrespondenceController {

    private final CorrespondenceService correspondenceService;

    @Autowired
    public CorrespondenceController(CorrespondenceService correspondenceService) {
        this.correspondenceService = correspondenceService;
    }

    @GetMapping
    public List<Correspondence> findAll() {
        return correspondenceService.findAll();
    }

    @GetMapping("/{id}")
    public Correspondence findById(@PathVariable Long id) {
        return correspondenceService.findById(id);
    }

    @PostMapping
    public Correspondence create(@RequestBody Correspondence correspondence) {
        return correspondenceService.create(correspondence);
    }

    @PutMapping("/{id}")
    public Correspondence update(@PathVariable Long id, @RequestBody Correspondence correspondence) {
        return correspondenceService.update(id, correspondence);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        correspondenceService.delete(id);
    }
}

