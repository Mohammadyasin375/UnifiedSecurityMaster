package com.appt.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appt.model.Admin;
import com.appt.model.Nse;
import com.appt.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {

		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/details")
	public Admin getAdminDetails(Principal principal) {
		String username = principal.getName();
		return adminService.getAdminDetails(username);
	}
	
	@PostMapping("/addstock")
	public void addNewStock(@RequestBody Nse nse){
		adminService.addStock(nse);
	}

	@PutMapping("/update/{isinNo}")
	public void updateStockByIsinNo(@RequestBody Nse nse, @PathVariable("isinNo") String isinNo) {
		adminService.updateStockByIsin(nse, isinNo);
	}
	
	@DeleteMapping("/delete/{isinNo}")
	public void deleteStock(@PathVariable("isinNo") String isinNo) {
		adminService.deleteStock(isinNo);
	}
	
}
