package org.forms.biz.services;

import java.util.List;

import org.forms.biz.entities.Projet;
import org.springframework.stereotype.Service;

@Service
public interface IProjetService {

	public void saveProjet(Projet projet);

	public void deleteProjet(int idProjet);

	public void updateProjet(Projet projet);

	public List<Projet> findAllProjet();

	public Projet findProjetById(int idProjet);
	
	public Projet findProjetByPersonnel(int idPersonnel);
	
}
