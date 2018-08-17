package org.forms.biz.services;

import java.util.List;

import org.forms.biz.entities.Personnel;
import org.springframework.stereotype.Service;

@Service
public interface IPersonnelService {

	public void savePersonnel(Personnel personnel);

	public void deletePersonnel(int idPersonnel);

	public void updatePersonnel(Personnel personnel);

	public List<Personnel> findAllPersonnel();

	public Personnel findPersonnelById(int idPersonnel);
	
}
