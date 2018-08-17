package org.forms.biz.dao;

import java.util.List;

import org.forms.biz.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, Integer>{

}
