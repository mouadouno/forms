package org.forms.biz.services;

import java.util.List;

import javax.transaction.Transactional;

import org.forms.biz.dao.ProjetRepository;
import org.forms.biz.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IProjetService")
@Transactional
public class ProjetServiceIMP implements IProjetService{

	@Autowired
	ProjetRepository projetRepository;
	
	@Override
	public void saveProjet(Projet projet) {
		projetRepository.save(projet);
		
	}

	@Override
	public void deleteProjet(int idProjet) {
		projetRepository.deleteById(idProjet);
		
	}

	@Override
	public void updateProjet(Projet projet) {
		projetRepository.save(projet);
		
	}

	@Override
	public List<Projet> findAllProjet() {
		return projetRepository.findAll();
		
	}

	@Override
	public Projet findProjetById(int idProjet) {
		return projetRepository.getOne(idProjet);
		
	}

	@Override
	public Projet findProjetByPersonnel(int idPersonnel) {
		return projetRepository.ProjetparPersonnel(idPersonnel);
	}

}
