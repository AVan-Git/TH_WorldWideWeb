package vn.edu.iuh.fit.se.fontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.se.service.impl.CandidateServiceImpl;

import java.util.Optional;

@Controller
public class CandidateControllerServlet {

    @Autowired
    private CandidateServiceImpl candidateService;

    @GetMapping("/candidate_fe/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/candidate";
    }

    @GetMapping("candidate_fe")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size)
    {


        return "candidates/candidates-paging";
    }
}
