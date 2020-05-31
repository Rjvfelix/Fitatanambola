package com.rjv.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rjv.entities.Salaire;

public interface SalaireRepository extends JpaRepository<Salaire, Long> {
	@Query("select s from Salaire s where s.description like :x")
	public Page<Salaire> chercher(@Param("x")String mc,Pageable pageable);
	
	@Query("select sum(s.montant) from Salaire s")
	public Float sommeSalaire();
}
