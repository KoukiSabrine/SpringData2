package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.enig.model.Employe;


public interface IEmployeDao extends JpaRepository<Employe,Integer> {
	@Query("select p from Employe p where p.dep.id=?1")
	public List<Employe> getAllEmployeByIdDep(int id);
	
	@Query("select p from Employe p where p.projet.id=?1")
	public List<Employe> getAllEmployeByProjet(int id);
	

}
