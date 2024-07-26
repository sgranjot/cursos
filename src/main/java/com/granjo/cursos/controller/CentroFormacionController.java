package com.granjo.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.granjo.cursos.dto.CentroFormacionDTO;
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

    @GetMapping("/form/{id}")
    public String mostrarFormulario(@PathVariable Long id, Model model){

        CentroFormacionDTO centro = new CentroFormacionDTO();

        if(id!=0) {
            centro = centroService.findCentroById(id);
        }

        model.addAttribute("title", "Crear Centro de Formación");
        model.addAttribute("centroFormacion", centro);

        return "centrosForm";
    }

    @PostMapping
    public String crearCentro(CentroFormacionDTO centroFormacionDTO) {
        centroService.createCentro(centroFormacionDTO);
        return "redirect:/centros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCentro(@PathVariable Long id) {
        centroService.deleteCentro(id);
        return "redirect:/centros";
    }

    @PutMapping("/modificar/{id}")
    public String modificarCentro(@PathVariable Long id, CentroFormacionDTO centroFormacionDTO, Model model) {
        model.addAttribute("title", "Actualizar datos centro");
        centroService.updateCentro(id, centroFormacionDTO);
        return "redirect:/centros";
    }

    @GetMapping("/mostrar/{id}")
    public String mostrarCentro(@PathVariable Long id, Model model) {
        model.addAttribute("title", "Datos del centro");
        model.addAttribute("centro", centroService.findCentroById(id));
        return "mostrarCentro";
    }
    
    

}
