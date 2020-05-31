package com.rjv.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rjv.entities.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Long> {
	@Query("select sum(d.montant) from Depense d")
	public Float sommeDepense();
	
	@Query("select d from Depense d where d.description like :x")
	public Page<Depense> chercher(@Param("x")String mc,Pageable pageable);
}
