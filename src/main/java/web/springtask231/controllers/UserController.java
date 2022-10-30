package web.springtask231.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.springtask231.models.User;
import web.springtask231.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/addNewUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/saveUser")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.show(id));
        return "editor";
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id") int id){
        this.userService.update(id,user);
        return "redirect:/users";

    }

    @GetMapping("/deleteUser/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
}
