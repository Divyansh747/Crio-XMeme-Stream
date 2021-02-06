package com.divyansh.crio.xmeme.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;
import com.divyansh.crio.xmeme.Service.XmemeService;

@Controller
public class HomeController {

	private XmemeService xmemeService;

	public HomeController(XmemeService xmemeService) {
		super();
		this.xmemeService = xmemeService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Model model) {
		model.addAttribute("form", new XmemeEntity());
		model.addAttribute("showmeme", xmemeService.findTop100ByOrderByIdDesc());
		return "index";
	}

	@PostMapping("/")
	public String returnHome(@ModelAttribute @RequestBody @Valid XmemeEntity xmemeEntity, Model model) {
		model.addAttribute("meme", xmemeEntity);
		xmemeService.createMeme(xmemeEntity);
		return "redirect:/";
	}

}
