package dev.paie.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class SupprimerCotisationOptionMenu extends OptionMenu {

	@Autowired
	private Scanner scanner;

	@Autowired
	private CotisationService cotisService;

	public SupprimerCotisationOptionMenu() {
		super("Supprimer une cotisation");
	}

	@Override
	public void executer() {
		System.out.println("Suppression de l'id ?");
		Integer id = scanner.nextInt();
		cotisService.supprimer(id);
	}

}
