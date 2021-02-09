package com.divyansh.crio.xmeme.Controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.divyansh.crio.xmeme.Entity.XmemeEntity;
import com.divyansh.crio.xmeme.Service.XmemeService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
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

	@RequestMapping(method = RequestMethod.GET, value = "/memes/{id}/edit")
	public String editFormByMemeId(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("editform", new XmemeEntity());
		return "editMeme";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/memes/{id}/edit", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String xmemePatchByMemeId(@PathVariable("id") Long id, @ModelAttribute @RequestBody XmemeEntity patchMeme) {
		xmemeService.updateFormMeme(id, patchMeme);
		return "redirect:/";
	}

}
