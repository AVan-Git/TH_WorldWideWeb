package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.se.service.impl.CandidateServiceImpl;

@Controller
//@RequestMapping("/candidate_fe")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateService;

    @GetMapping("/candidate_fe/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/candidate";
    }



}
