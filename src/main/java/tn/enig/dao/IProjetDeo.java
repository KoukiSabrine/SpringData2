package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.enig.model.Projet;

public interface IProjetDeo extends JpaRepository<Projet,Integer>{
	@Query("select p from Projet p where p.dep.id=?1")
     public List<Projet> getAllProjetsById(int id);
}
