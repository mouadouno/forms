package org.forms.biz.dao;

import java.util.List;

import org.forms.biz.entities.Personnel;
import org.forms.biz.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet, Integer>{

	@Query("select p from Projet p where :x IN (SELECT idPersonnel from p.personnel)")
	public Projet ProjetparPersonnel(@Param("x")int idPersonnel);
}
