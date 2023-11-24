package com.fit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fit.entity.HocPhan;
import com.fit.services.HocPhanService;

@Controller
@RequestMapping("/")
public class HocPhanController {
   @Autowired
   private HocPhanService hocphanService;
    @PostMapping("/save")
    public String saveHocPhan(@ModelAttribute("tempHocPhan") HocPhan hocPhan) {
    	hocphanService.saveHocphan(hocPhan);
    	return "redirect:/";
    }
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("hocphanId") int theId,Model model) {
		HocPhan hocPhan=hocphanService.getHocPhan(theId);
		model.addAttribute( "tempHocPhan",hocPhan);
		return "hocphan-form";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormForAdd(Model model) {
		HocPhan hocPhan=new HocPhan();
		model.addAttribute("tempHocPhan",hocPhan);
		
		return "hocphan-form";
	}
	
	@GetMapping("/")
	public String listHocPhan(Model model) {
		List<HocPhan>list=hocphanService.getAllHocPhans();
	  model.addAttribute("listhocphan",list);
		return "list-hocphan";
	}
	@GetMapping("/delete")
	public String deleteHocPhan(@RequestParam("hocphanId") int id) {
		hocphanService.deleteHocPhan(id);
		return "redirect:/";
	}
	
}
