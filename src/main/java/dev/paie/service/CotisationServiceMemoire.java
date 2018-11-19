package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.paie.domain.Cotisation;

public class CotisationServiceMemoire implements CotisationService {

	private List<Cotisation> cotisations = new ArrayList<Cotisation>();

	@Override
	public List<Cotisation> lister() {
		return cotisations;
	}

	@Override
	public Cotisation sauver(String code, String libelle, Boolean imposable, BigDecimal tauxPratonal,
			BigDecimal tauxSalarial) {
		
		Cotisation cotis = new Cotisation();
		cotis.setCode(code);
		cotis.setLibelle(libelle);
		cotis.setImposable(imposable);
		cotis.setTauxPatronal(tauxPratonal);
		cotis.setTauxSalarial(tauxSalarial);
		cotisations.add(cotis);

		return cotis;
	}

	@Override
	public void supprimer(Integer id) {
		cotisations.remove(id.intValue());
	}

}
