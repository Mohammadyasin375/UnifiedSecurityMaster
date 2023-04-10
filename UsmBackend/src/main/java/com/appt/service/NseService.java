package com.appt.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appt.dto.NseResponseDto;
import com.appt.model.Nse;
import com.appt.repository.NseRepository;

import javax.annotation.PostConstruct;

@Service
public class NseService {

	@Autowired
	private NseRepository nseRepo;
	

	@PostConstruct
	public void saveNseData() throws IOException {

		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Stocks.csv"));
		try {
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				Nse n = new Nse();
				n.setSecurityCode(data[0]);
				n.setSymbol(data[1]);
				n.setSecurityName(data[2]);
				n.setIsinNo(data[3]);
				n.setSector(data[4]);
				n.setIndustry(data[5]);
				n.setExchange(data[6]);
				n.setCurrency(data[7]);
				n.setGics(data[8]);
				n.setPrice(data[9]);
				n.setCountry(data[10]);

				nseRepo.save(n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			br.close();
		}
	}

	public List<Nse> allStocks() {
		return nseRepo.findAll();
	}

	public Nse findByIsinNo(String isinNo) {
		return nseRepo.findByIsinNo(isinNo);
	}

	public Nse getBySymbol(String symbol) {
		return nseRepo.findBySymbol(symbol);
	}

	public List<Nse> findBySector(String sector) {
		return nseRepo.findBySector(sector);
	}

	public List<NseResponseDto> fetchByIndustry(String industry) {
		List<Nse> stocks = nseRepo.findByIndustry(industry);
		List<NseResponseDto> listDto = new ArrayList<>();
		
		for(Nse nse:stocks) {
			NseResponseDto dto = new NseResponseDto();
			dto.setIsinNo(nse.getIsinNo());
			dto.setSecurityCode(nse.getSecurityCode());
			dto.setSecurityName(nse.getSecurityName());
			dto.setSymbol(nse.getSymbol());
			dto.setSector(nse.getSector());
			dto.setIndustry(nse.getIndustry());
			dto.setGics(nse.getGics());
			dto.setPrice(nse.getPrice());
			dto.setCountry(nse.getCountry());
			listDto.add(dto);
		}
		return listDto;
	}

	public NseResponseDto fetchStockBySecurityName(String securityName) {
		Nse stock = nseRepo.findBySecurityName(securityName);
		NseResponseDto dto = new NseResponseDto();
		dto.setIsinNo(stock.getIsinNo());
		dto.setSecurityName(stock.getSecurityName());
		dto.setSector(stock.getSector());
		dto.setSymbol(stock.getSymbol());
		dto.setIndustry(stock.getIndustry());
		dto.setSecurityCode(stock.getSecurityCode());
		dto.setGics(stock.getGics());
		dto.setPrice(stock.getPrice());
		dto.setCountry(stock.getCountry());
		return dto;
	}
}
