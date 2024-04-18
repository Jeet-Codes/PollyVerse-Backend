package org.example.pollyversebackend.Service.ServiceImp;

import lombok.AllArgsConstructor;

import org.example.pollyversebackend.Entity.Admin;
import org.example.pollyversebackend.Exception.ResourceNotFound;
import org.example.pollyversebackend.Repository.AdminRepo;
import org.example.pollyversebackend.Service.AdminMethods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService implements AdminMethods {

	private AdminRepo adminRepo;

	@Override
	public Admin createAdmin(Admin admin) {
		Admin savedAdmin = adminRepo.save(admin);
		return savedAdmin;
	}

	@Override
	public Admin getAdminById(Long id) {
		Admin admin = adminRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Admin not exist with id : "+id)
		);
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> admins = adminRepo.findAll();
		return admins;
	}

	@Override
	public void deleteAdmin(Long id) {
		adminRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Admin does not exist with id : " + id));
		adminRepo.deleteById(id);
	}

	@Override
	public Admin updateAdmin(Long id, Admin updatedAdmin) {
		Admin previousAdmin = adminRepo.findById(id).orElseThrow(
				() -> new ResourceNotFound("Admin does not exist with id : " + id)
		);
		previousAdmin.setAdminEmail(updatedAdmin.getAdminEmail());
		previousAdmin.setAdminPasswd((updatedAdmin.getAdminPasswd()));
		Admin savedAdmin = adminRepo.save(previousAdmin);
		return savedAdmin;
	}
}