package com.granjo.cursos.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.granjo.cursos.dto.CentroFormacionDTO;
import com.granjo.cursos.service.ICentroFormacionService;

public class CentroFormacionControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    CentroFormacionController centroFormacionController;

    @Mock
    ICentroFormacionService centroFormacionService;


    @BeforeEach
    public void setup () {

        MockitoAnnotations.openMocks(this);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".html");

        this.mockMvc = MockMvcBuilders.standaloneSetup(centroFormacionController)
            .setViewResolvers(viewResolver)
            .build();
    }


    @Test
    public void verCentrosTest () throws Exception {

        when(centroFormacionService.findAllCentros()).thenReturn(Collections.emptyList());

        this.mockMvc.perform(get("/centros"))
            .andExpect(status().isOk())
            .andExpect(view().name("centros"))
            .andExpect(model().attributeExists("title"))
            .andExpect(model().attributeExists("centros"));
            
        verify(centroFormacionService, times(1)).findAllCentros();
    }


    @Test
    public void mostrarFormularioCrearTest () throws Exception {

        this.mockMvc.perform(get("/centros/form/0"))
            .andExpect(status().isOk())
            .andExpect(view().name("centrosForm"))
            .andExpect(model().attributeExists("title"))
            .andExpect(model().attributeExists("centroFormacion"));

        verify(centroFormacionService, never()).findCentroById(anyLong());
   }


   @Test
   public void mostrarFormularioEditarTest () throws Exception {

        CentroFormacionDTO centro = new CentroFormacionDTO();

        when(centroFormacionService.findCentroById(1L)).thenReturn(centro);

        this.mockMvc.perform(get("/centros/form/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("centrosForm"))
            .andExpect(model().attributeExists("title"))
            .andExpect(model().attributeExists("centroFormacion"));

        verify(centroFormacionService, times(1)).findCentroById(1L);

   }


   @Test
   public void crearCentroTest () throws Exception {

    when(centroFormacionService.createCentro(any(CentroFormacionDTO.class)))
        .thenReturn(any(CentroFormacionDTO.class));

        this.mockMvc.perform(post("/centros")
            .param("nombre", "Centro de Prueba")
            .param("direccion.tipoVia", "Calle")
            .param("direccion.nombreVia", "Falsa")
            .param("direccion.numero", "123")
            .param("direccion.codigoPostal", "12345")
            .param("direccion.ciudad", "Springfield"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/centros"));

        verify(centroFormacionService, times(1)).createCentro(any(CentroFormacionDTO.class));

   }


   @Test
   public void eliminarCentroTest () throws Exception {

        this.mockMvc.perform(get("/centros/eliminar/1"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/centros"));

        verify(centroFormacionService, times(1)).deleteCentro(1L);

   }


   @Test
   public void modificarCentroTest () throws Exception {

        this.mockMvc.perform(put("/centros/modificar/1")
            .param("nombre", "Centro modificado")
            .param("direccion.tipoVia", "Calle")
            .param("direccion.nombreVia", "Modificada")
            .param("direccion.numero", "456")
            .param("direccion.codigoPostal", "01234")
            .param("direccion.ciudad", "Toronto"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/centros"));

        verify(centroFormacionService, times(1)).updateCentro(eq(1L), any(CentroFormacionDTO.class));

   }


   @Test
   public void mostrarCentroTest () throws Exception {

        CentroFormacionDTO centro = new CentroFormacionDTO();
    
        when(centroFormacionService.findCentroById(anyLong()))
            .thenReturn(centro);

        this.mockMvc.perform(get("/centros/mostrar/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("mostrarCentro"))
            .andExpect(model().attributeExists("title"))
            .andExpect(model().attributeExists("centro"));

        verify(centroFormacionService, times(1)).findCentroById(eq(1L));

   }


}
