package com.appt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appt.model.Nse;

@Repository
public interface NseRepository extends JpaRepository<Nse, String> {
	
	Nse findByIsinNo(String isinNo);
	
	Nse findBySymbol(String symbol);

	List<Nse> findBySector(String sector);

	List<Nse> findByIndustry(String industry);

	Nse findBySecurityName(String securityName);
	
	
}
