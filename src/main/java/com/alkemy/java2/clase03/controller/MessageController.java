package com.alkemy.java2.clase03.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MessageController {

  @GetMapping("/mensaje")
  public String home(Model model) {
    try {
      model.addAttribute("mensaje", "Hola, este es un mensaje desde el controlador.");
      return "message"; // Nombre de la vista JSP sin el sufijo .jsp
    } catch (Exception e) {
      log.error("Error en el controlador de mensaje", e);
      return "error"; // Página de error genérica
    }
  }

  @GetMapping("/test")
  public String test() {
    try {
      log.info("aca vista test");
      return "message"; // Nombre de la vista JSP sin el sufijo .jsp
    } catch (Exception e) {
      log.error("Error en el controlador de mensaje", e);
      return "error"; // Página de error genérica
    }
  }
}