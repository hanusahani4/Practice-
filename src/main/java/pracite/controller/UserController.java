package pracite.controller;

import pracite.model.User;
import pracite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// display list of employees
	
	@GetMapping("/")
	public String showNewUserForm(Model model) {
		// create model attribute to bind form data
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	@PostMapping("/saveUser")
	public String saveSave(@ModelAttribute("user") User user) {
		// save employee to database
		userService.saveUser(user);
		return "redirect:/";
	}

}
