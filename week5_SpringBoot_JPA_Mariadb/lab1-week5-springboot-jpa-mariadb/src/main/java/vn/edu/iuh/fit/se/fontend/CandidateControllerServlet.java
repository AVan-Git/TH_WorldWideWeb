package vn.edu.iuh.fit.se.fontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.se.entity.Candidate;
import vn.edu.iuh.fit.se.repositories.CandidateRepository;
import vn.edu.iuh.fit.se.service.impl.CandidateServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidate_fe")
public class CandidateControllerServlet {

    @Autowired
    private CandidateServiceImpl candidateService;
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/candidate";
    }

    @GetMapping("")
    public  String showCandidateListPaging(Model model,
                                           @RequestParam("page") Optional<Integer> page,
                                           @RequestParam("size") Optional<Integer> size)
    {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Pageable pageable =  PageRequest.of(currentPage-1, pageSize);
        Page<Candidate> candidatePage =  candidateService.findBaginated(
                pageable
        );

        model.addAttribute("candidatePage", candidatePage);

        int totalPage = candidatePage.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumber", pageNumber);
        }


        return "candidates/candidates-paging";
    }
}
