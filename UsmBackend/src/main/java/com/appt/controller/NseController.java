package com.appt.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appt.dto.NseResponseDto;
import com.appt.model.Nse;
import com.appt.service.NseService;

@CrossOrigin("http://localhost:9867/")
@RestController
@RequestMapping("/api/stocks")
public class NseController {

	@Autowired
	private NseService nseService;
	
	@PostMapping("/insert")
	public void setDataInDB() throws IOException {
		nseService.saveNseData();
	}
	
	@GetMapping("/all")
	public List<Nse> getAllStocks(){
		return nseService.allStocks();
	}
	
	@GetMapping("/{isinNo}")
	public Nse getStockByCode(@PathVariable("isinNo") String isinNo) {
		return nseService.findByIsinNo(isinNo);
	}
	
	@GetMapping("/symbol/")
	public Nse getStocksBySymbol(@RequestParam String symbol){
		return nseService.getBySymbol(symbol);   
	}
	
	@GetMapping("/sector/")
	public List<Nse> getStocksBySector(@RequestParam String sector) {
		return nseService.findBySector(sector);
	}
	
	@GetMapping("/industry/")
	public List<NseResponseDto> getStocksByIndustry(@RequestParam String industry) {
		return nseService.fetchByIndustry(industry);	
	}
	
	@GetMapping("/security/")
	public NseResponseDto getStockBySecurityName(@RequestParam String securityName) {
		return nseService.fetchStockBySecurityName(securityName);
	}
	
}
