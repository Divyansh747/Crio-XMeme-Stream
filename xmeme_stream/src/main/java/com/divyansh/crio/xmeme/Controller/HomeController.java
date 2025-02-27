package com.divyansh.crio.xmeme.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * REST HOME Controller Class deals with all RESTful API used in XMEME STREAM WEB Application 
 * This Controller deals with UI Part i.e Form/Buttons etc other HTML webpage stuffs
 *  
 * @author Divyansh Rahangdale
 *
 */
@Controller
@ApiIgnore
public class HomeController {

	// Spring dependency injection for XmemeService
	@Autowired
	private XmemeService xmemeService;

	/**
	 * HomeController constructor
	 * @param xmemeService
	 */
	public HomeController(XmemeService xmemeService) {
		super();
		this.xmemeService = xmemeService;
	}

	/**
	 * This function generating GET Method with mapped endpoint /
	 * This function will display index i.e Home page, when / endpoint calls
	 * 
	 * @return - Top 100 recent Memes in reverse chronological order
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Model model) {
		model.addAttribute("form", new XmemeEntity());
		model.addAttribute("showmeme", xmemeService.findTop100ByOrderByIdDesc());
		return "index";
	}

	/**
	 * This function generating POST Method with mapped endpoint /
	 * After submitting form POST this method will invoke
	 * 
	 * @param xmemeEntity - object of XmemeEntity class 
	 * @param model - stores form data
	 * @return - Redirect to / endpoint after submitting form
	 */
	@PostMapping("/")
	public String returnHome(@ModelAttribute @RequestBody @Valid XmemeEntity xmemeEntity, Model model) {
		model.addAttribute("meme", xmemeEntity);
		xmemeService.createMeme(xmemeEntity);
		return "redirect:/";
	}

	/**
	 * This function generating GET Method with mapped endpoint /memes/{id}/edit
	 * This function will retrieve id from URL and redirect to edit Form page
	 * 
	 * @param id - String type parameter retrieve from PathVariable
	 * @param model - stores edit meme form data
	 * @return - editMeme html page
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/memes/{id}/edit")
	public String editFormByMemeId(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("editform", new XmemeEntity());
		return "editMeme";
	}

	/**
	 * This function generating POST Method with mapped endpoint /memes/{id}/edit
	 * After submitting edit meme form this POST method will invoke
	 * 
	 * @param id - String type parameter retrieve from PathVariable
	 * @param patchMeme - object of XmemeEntity to store edit meme attributes
	 * @return - redirect to / home page
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/memes/{id}/edit", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String xmemePatchByMemeId(@PathVariable("id") Long id, @ModelAttribute @RequestBody XmemeEntity patchMeme) {
		xmemeService.updateFormMeme(id, patchMeme);
		return "redirect:/";
	}

}
