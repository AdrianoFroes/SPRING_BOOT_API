package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.NotaFiscal;
import com.example.demo.repository.NotaRepository;


@Controller
@RequestMapping("/nota")
public class NotaController {
	
	@Autowired
	NotaRepository notaFiscalRepository;
	
	@GetMapping
	public String mostraForm(NotaFiscal notaFiscal) {
		return "nota-cadastrar";
	}

	@GetMapping("/listar")
	public ModelAndView listaNotas() {
		ModelAndView modelAndView = new ModelAndView("nota-listar");
		List<NotaFiscal> notas = notaFiscalRepository.findAll();
		modelAndView.addObject("notas", notas);
		return modelAndView;
	}
	
	@PostMapping("/criar")
	public ModelAndView cadastrarNota(NotaFiscal notaFiscal) {
		ModelAndView modelAndView = new ModelAndView("nota-cadastrar");
		notaFiscalRepository.save(notaFiscal);
		modelAndView.addObject("mensagem", "Nota salva com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{id}")
	public String deletarDisciplina(@PathVariable("id") Long id) {
		notaFiscalRepository.deleteById(id);
		return "redirect:/nota/listar";
	}
}

