package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;
import dev.paie.repository.CotisationRepository;

@Service
public class CotisationServiceJpa implements CotisationService {
	
	@Autowired
	private CotisationRepository cotisationRepository;
	
	@Override
	public List<Cotisation> lister() {
		return cotisationRepository.findAll();
	}

	@Override
	public Cotisation sauver(String codeSaisie, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		Cotisation c = new Cotisation();
		c.setCode(codeSaisie);
		c.setLibelle(libelle);
		c.setImposable(imposable);
		c.setTauxPatronal(tauxPatronal);
		c.setTauxSalarial(tauxSalarial);
		cotisationRepository.save(c);
		return null;
	}

	@Override
	public void supprimer(Integer id) {
		cotisationRepository.delete(id);
	}

}
