package com.rjv.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rjv.dao.DepenseRepository;
import com.rjv.dao.SalaireRepository;
import com.rjv.entities.Depense;
import com.rjv.entities.Salaire;
import com.rjv.tools.MyTools;

@Controller
public class SalaireController {
	@Autowired
	private SalaireRepository salaireRepository;
	@Autowired
	private DepenseRepository depenseRepository;

	private float getSolde() {
		return salaireRepository.sommeSalaire() - depenseRepository.sommeDepense();
	}

	@RequestMapping(value = "/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "type", defaultValue = "salaire") String type,
			@RequestParam(name = "size", defaultValue = "10") int s,
			@RequestParam(name = "mc", defaultValue = "") String mc) {

		if (type.equalsIgnoreCase("depense")) {
			Page<Depense> pageDepenses = depenseRepository.chercher("%" + mc + "%", PageRequest.of(p, s));
			model.addAttribute("salaires", pageDepenses.getContent());
			int[] pages = new int[pageDepenses.getTotalPages()];
			model.addAttribute("type", "depense");
			model.addAttribute("pages", pages);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			model.addAttribute("mc", mc);
			model.addAttribute("salaire", new Salaire());
			model.addAttribute("depense", new Depense());
			model.addAttribute("solde", "Solde: " + MyTools.formatVola(getSolde()));
		} else {
			Page<Salaire> pageSalaires = salaireRepository.chercher("%" + mc + "%", PageRequest.of(p, s));
			model.addAttribute("salaires", pageSalaires.getContent());
			int[] pages = new int[pageSalaires.getTotalPages()];
			model.addAttribute("type", "salaire");
			model.addAttribute("pages", pages);
			model.addAttribute("size", s);
			model.addAttribute("pageCourante", p);
			model.addAttribute("mc", mc);
			model.addAttribute("salaire", new Salaire());
			model.addAttribute("depense", new Depense());
			model.addAttribute("solde", "Solde: " + MyTools.formatVola(getSolde()));
		}

		return "salaire";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "id") Long id, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "10") int s,
			@RequestParam(name = "type", defaultValue = "salaire") String type,
			@RequestParam(name = "mc", defaultValue = "") String mc) {
		if (type.equalsIgnoreCase("salaire")){
			salaireRepository.deleteById(id);
		}else{
			depenseRepository.deleteById(id);
		}
		return "redirect:/index?page=" + p + "&size=" + s + "&mc=" + mc + "&type=" + type;
	}

	@RequestMapping(value = "/saveSalaire", method = RequestMethod.POST)
	public String saveSalaire(Model model, Salaire s) {
		s.setDate(new Date());
		salaireRepository.save(s);
		return "redirect:/index";
	}

	@RequestMapping(value = "/saveDepense", method = RequestMethod.POST)
	public String saveDepense(Model model, Depense d) {
		d.setDate(new Date());
		if (getSolde() >= d.getMontant()) {
			depenseRepository.save(d);
			return "redirect:/index";
		} else {
			model.addAttribute("msg", "Solde insuffisant");
			return "error";
		}
	}
}
