package vn.edu.iuh.fit.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.service.impl.CandidateServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateService;

    @GetMapping()
    public List<Candidate> getALl(){
        return candidateService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        Optional<Candidate> optional = candidateService.findById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }
        return new ResponseEntity<>("Không tìm thấy !!!"+ id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate) {
        candidateService.insert(candidate);

        return new ResponseEntity<>("Finish Add "+ candidate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Candidate candidate) {
        Optional<Candidate> opt = candidateService.findById(id);
        candidateService.insert(candidate);
        if (opt.isPresent()){
            return new ResponseEntity<>("Finish Update "+ candidate, HttpStatus.OK);
        }
        return new ResponseEntity<>("Finish Add "+ candidate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        Optional<Candidate> opt = candidateService.findById(id);
        if (opt.isPresent()){
            candidateService.delete(id);

            return new ResponseEntity<>("Finish del ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy" + id, HttpStatus.NOT_FOUND);

    }

}
