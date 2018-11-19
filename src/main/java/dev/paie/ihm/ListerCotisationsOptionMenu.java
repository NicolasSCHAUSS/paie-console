package dev.paie.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class ListerCotisationsOptionMenu extends OptionMenu {

	@Autowired
	private CotisationService cotisService;

	public ListerCotisationsOptionMenu() {
		super("Lister les cotisations");
	}

	@Override
	public void executer() {
		System.out.println("Listage en cours");
		this.cotisService.lister().forEach(cotis -> System.out.println(cotis));
	}

}
