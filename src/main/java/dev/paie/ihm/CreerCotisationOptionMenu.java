package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.domain.Cotisation;
import dev.paie.service.CotisationService;

@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	@Autowired
	private Scanner scanner;
	@Autowired
	private CotisationService cotisService;

	public CreerCotisationOptionMenu() {
		super("Créer une cotisation");
	}

	@Override
	public void executer() {
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code : ");
		String codeSaisie = this.scanner.next();
		System.out.println("Veuillez saisir le libellé : ");
		String libelle = this.scanner.next();
		System.out.println("Veuillez saisir le taux Patronal : ");
		BigDecimal tauxPratonal = new BigDecimal(scanner.next());
		System.out.println("Veuillez saisir le taux Salarial : ");
		BigDecimal tauxSalarial = new BigDecimal(this.scanner.next());
		System.out.println("Veuillez saisir son imposabilité (O/N) : ");
		Boolean imposable = (this.scanner.next().toLowerCase()=="n")?false:true;
		Cotisation c = this.cotisService.sauver(codeSaisie, libelle, imposable, tauxPratonal, tauxSalarial);
		
		System.out.println("Vous avez creé :" + c);
	}

}
