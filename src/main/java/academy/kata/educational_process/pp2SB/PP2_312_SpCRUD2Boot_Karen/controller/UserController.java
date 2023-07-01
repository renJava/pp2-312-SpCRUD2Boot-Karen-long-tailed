package academy.kata.educational_process.pp2SB.PP2_312_SpCRUD2Boot_Karen.controller;

import academy.kata.educational_process.pp2SB.PP2_312_SpCRUD2Boot_Karen.entity.User;
import academy.kata.educational_process.pp2SB.PP2_312_SpCRUD2Boot_Karen.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    static final String REDIRECT_ROOT = "redirect:/";
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createU";
    }

    @GetMapping("/")
    public String printUsers(Model model) {
        model.addAttribute("users3", userService.getAllUsers());
        return "listU";
    }

    @PostMapping("/user-create")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "createU";
        }

        userService.add(user);
        return REDIRECT_ROOT;
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUserFromTable(@PathVariable("id") Long id) {
        userService.deleteUserFromTable(id);
        return REDIRECT_ROOT;
    }

    @PatchMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "updateU";
    }

    @PatchMapping("/user-update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "updateU";
        }

        userService.updateUser(user);
        return REDIRECT_ROOT;
    }

}