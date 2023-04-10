package com.appt.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.appt.model.Nse;
import com.appt.repository.NseRepository;
import com.appt.service.NseService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class NseControllerTest {
	
	@Autowired
	@InjectMocks
	NseService nseService;
	
	@Mock
	NseRepository nseRepository;
	
	@Test
	void findByIsinNoTest() {
		String isinNo1 = "INE447A01015";
		Nse nse1 = new Nse("500028", "India", "INR", "NSE", "40203030", "Capital Goods", "INE447A01015", "962", "Industrials", "ATV PROJECTS INDIA LTD.", "ATVPR");
		
		String isinNo2 = "INE117A01022";
		Nse nse2 = new Nse("500002", "India", "INR", "NSE", "40203030", "Capital Goods", "INE117A01022", "581", "Industrials", "ABB India Limited", "ABB");
		when(nseRepository.findByIsinNo(isinNo2)).thenReturn(nse2);

	}
	
	@Test
	void findBySymbolTest() {
		String symbol = "BATAINDIA";
		Nse nse = new Nse("500043", "India", "INR", "NSE", "2520", "Consumer Durables", "INE176A01028", "1557", "Consumer Discretionary", "BATA INDIA LTD.", "BATAINDIA");
		
		when(nseRepository.findBySymbol(symbol))
		.thenReturn(nse);		
	}
	
	@Test
	void findBySectorTest() {
		String sector = "Healthcare";
		List<Nse> listNse = new ArrayList<>();
		listNse.add(new Nse("500009", "India", "INR", "NSE", "35", "Healthcare", "INE432A01017", "195", "Healthcare", "AMBALAL SARABHAI ENTERPRISES LTD.", "AMBALALSA"));
		listNse.add(new Nse("500124", "India", "INR", "NSE", "35", "Healthcare", "INE089A01023", "1463", "Healthcare", "DR.REDDY'S LABORATORIES LTD.", "DRREDDY"));
		
		when(nseRepository.findBySector(sector)).thenReturn(listNse);
		
		int expected = 2;
		int actual = nseService.findBySector(sector).size();
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	void findByIndustryTest() {
		String industry = "Financial Services";
		
		List<Nse> listNse = new ArrayList<>();
		listNse.add(new Nse("500111", "India", "INR", "NSE", "40201020", "Financial Services", "INE013A01015", "180", "Financial Services", "RELIANCE CAPITAL LTD.", "RELCAPITAL"));
		listNse.add(new Nse("500112", "India", "INR", "NSE", "40201020", "Financial Services", "INE062A01020", "269", "Financial Services", "STATE BANK OF INDIA", "SBIN"));
		listNse.add(new Nse("500116", "India", "INR", "NSE", "40201020", "Financial Services", "INE008A01015", "1016", "Financial Services", "IDBI BANK LTD.", "IDBI"));
		
		when(nseRepository.findByIndustry(industry)).thenReturn(listNse);
		
		int expected = 3;
		int actual = nseService.fetchByIndustry(industry).size();
		
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void findBySecurityNameTest() {
		String securityName1 = "RELIANCE CAPITAL LTD.";
		String securityName2 = "STATE BANK OF INDIA";
		
		Nse nse1 = new Nse("500111", "India", "INR", "NSE", "40201020", "Financial Services", "INE013A01015", "180", "Financial Services", "RELIANCE CAPITAL LTD.", "RELCAPITAL");
		Nse nse2 = new Nse("500112", "India", "INR", "NSE", "40201020", "Financial Services", "INE062A01020", "269", "Financial Services", "STATE BANK OF INDIA", "SBIN");
		
		when(nseRepository.findBySecurityName(securityName1)).thenReturn(nse1);
		when(nseRepository.findBySecurityName(securityName2)).thenReturn(nse2);
		
	}
}
