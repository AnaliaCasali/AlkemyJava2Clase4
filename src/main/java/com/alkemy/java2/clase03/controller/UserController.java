package com.alkemy.java2.clase03.controller;

  import com.alkemy.java2.clase03.model.User;
  import com.alkemy.java2.clase03.service.UserService;
  import lombok.extern.slf4j.Slf4j;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.*;

  @Controller
  @Slf4j
  @RequestMapping("/users")
  public class UserController {

    @Autowired
    private UserService userService;

    // Listar todos los usuarios
    @GetMapping
    public String listUsers(Model model) {
      model.addAttribute("users", userService.getAllUsers());
      log.info("Listando usuarios");
      userService.getAllUsers().forEach(user -> log.info(user.toString()));
      return "user-list"; // Vista JSP para listar usuarios
    }

    // Mostrar formulario para crear un nuevo usuario
    @GetMapping("/new")
    public String showCreateForm(Model model) {
      model.addAttribute("user", new User());
      return "user-form"; // Vista JSP para el formulario de creación
    }

    // Guardar un nuevo usuario
    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
      userService.createUser(user);
      return "redirect:/users"; // Redirige a la lista de usuarios
    }

    // Mostrar formulario para editar un usuario existente
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
      model.addAttribute("user", userService.getUserById(id));
      return "user-form"; // Vista JSP para el formulario de edición
    }

    // Actualizar un usuario existente
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
      userService.updateUser(id, user);
      return "redirect:/users"; // Redirige a la lista de usuarios
    }

    // Eliminar un usuario
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
      userService.deleteUser(id);
      return "redirect:/users"; // Redirige a la lista de usuarios
    }
  }