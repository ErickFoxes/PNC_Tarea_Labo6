package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;


@Controller
public class MainController {

	@Autowired
    private ImportanciaDAO importanciaDAO;
	
	@Autowired
    private ContribuyenteDAO contribuyenteDAO;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> importanciaSelect = importanciaDAO.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("contribuyente",contribuyente);
		mav.addObject("importanciaSelect",importanciaSelect);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresar")
	public ModelAndView ingresar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
		}
		else {
			contribuyenteDAO.save(contribuyente);
			mav.setViewName("exito");
		}
		
		return mav;
	}
	@RequestMapping(value = "/mostrarContribuyentes")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteDAO.findAll();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("contribuyentes",contribuyentes);
		mav.setViewName("listadoContribuyentes");
		return mav;
	}
}
