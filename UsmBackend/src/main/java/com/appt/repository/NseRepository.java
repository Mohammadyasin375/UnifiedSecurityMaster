package com.appt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appt.model.Nse;

@Repository
public interface NseRepository extends JpaRepository<Nse, String>{
	
	Nse findByIsinNo(String isinNo);
	
	List<Nse> findBySymbolStartsWith(String symbol);

	List<Nse> findBySectorContaining(String sector);
	
	List<Nse> findByIndustryContaining(String industry);

	List<Nse> findBySecurityNameStartsWith(String securityName);

	void deleteByIsinNo(String isinNo);
}
