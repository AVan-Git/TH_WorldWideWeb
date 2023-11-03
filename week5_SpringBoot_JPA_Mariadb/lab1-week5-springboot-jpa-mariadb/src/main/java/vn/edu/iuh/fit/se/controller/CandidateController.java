package vn.edu.iuh.fit.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.service.impl.CandidateServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateService;

    @GetMapping()
    public List<Candidate> getALl(){
        return candidateService.findAll();
    }

//    @GetMapping("/list")
//    public String showCandidateList(Model model) {
//        return "/candidates/candidate.html";
//    }


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
        System.out.println(candidate);
        candidateService.insert(candidate);

        return new ResponseEntity<>("Finish Add "+ candidate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Candidate candidate) {
        Optional<Candidate> opt = candidateService.findById(id);
        Candidate canNew = opt.get();
        canNew.setDob(candidate.getDob());
        canNew.setAddress(candidate.getAddress());
        canNew.setName(candidate.getName());
        canNew.setEmail(candidate.getEmail());
        canNew.setPhone(candidate.getPhone());
        canNew.setExperiences(candidate.getExperiences());
        candidateService.insert(canNew);
        System.err.println("Set TH Tạo mới mà bị trùng email, phone,address thì sao");
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
    @GetMapping("page")
    public  Page<Candidate> showCandidateListPaging(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size)
    {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Pageable pageable =  PageRequest.of(currentPage-1, pageSize, Sort.by("phone").descending());
        Page<Candidate> candidatePage =  candidateService.findBaginated(
                pageable
        );

        return candidatePage;
    }

}
