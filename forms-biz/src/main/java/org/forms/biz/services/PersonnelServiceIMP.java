package org.forms.biz.services;

import java.util.List;

import javax.transaction.Transactional;

import org.forms.biz.dao.PersonnelRepository;
import org.forms.biz.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("IPersonnelService")
@Transactional
public class PersonnelServiceIMP implements IPersonnelService{

	@Autowired
	PersonnelRepository personnelRepository;
	
	@Override
	public void savePersonnel(Personnel personnel) {
		personnelRepository.save(personnel);
		
	}

	@Override
	public void deletePersonnel(int idPersonnel) {
		personnelRepository.deleteById(idPersonnel);
		
	}

	@Override
	public void updatePersonnel(Personnel personnel) {
		personnelRepository.save(personnel);
		
	}

	@Override
	public List<Personnel> findAllPersonnel() {
		return personnelRepository.findAll();
		
	}

	@Override
	public Personnel findPersonnelById(int idPersonnel) {
		return personnelRepository.getOne(idPersonnel);
		
	}

}
