package com.granjo.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.granjo.cursos.model.CentroFormacion;
import com.granjo.cursos.service.ICentroFormacionService;



@Controller()
@RequestMapping("/centros")
public class CentroFormacionController {

    @Autowired
    ICentroFormacionService centroService;

    @GetMapping
    public String verCentros(Model model){
        model.addAttribute("title", "Centros de Formación");
        model.addAttribute("centros", centroService.findAllCentros());
        return "centros";
    }

    @GetMapping("/nuevo/{id}")
    public String mostrarFormulario(@PathVariable Long id, Model model){

        CentroFormacion centro = new CentroFormacion();

        if(id!=0) {
            centro = centroService.findCentroById(id).get();
        }

        model.addAttribute("title", "Crear Centro de Formación");
        model.addAttribute("centroFormacion", centro);

        return "centrosForm";
    }

    @PostMapping
    public String crearCentro(CentroFormacion centroFormacion) {
        centroService.createCentro(centroFormacion);
        return "redirect:/centros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCentro(@PathVariable Long id) {
        centroService.deleteCentro(id);
        return "redirect:/centros";
    }

    @PostMapping("/modificar/{id}")
    public String modificarCentro(@PathVariable Long id, CentroFormacion centroFormacion, Model model) {
        model.addAttribute("title", "Actualizar datos centro");
        centroService.updateCentro(id, centroFormacion);
        return "redirect:/centros";
    }

    @GetMapping("/mostrar/{id}")
    public String mostrarCentro(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Datos del centro");
        model.addAttribute("centro", centroService.findCentroById(id).get());
        return "mostrarCentro";
    }
    
    

}
