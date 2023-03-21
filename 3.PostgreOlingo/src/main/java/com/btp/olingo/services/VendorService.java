package com.btp.olingo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.btp.olingo.entities.Vendor;

@Component
public class VendorService {

	@Autowired
	IVendorPersistence vendor;
	
	public List<Vendor> readAllVendors(){
		return vendor.findAll();
	}
	
	public Vendor createVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
	}
	
	public Vendor updateVendor(Vendor vendorObj) {
		Optional<Vendor> myVendor = vendor.findById(vendorObj.getId());
		if(!myVendor.isPresent()) {
			return new Vendor("","","","","","","","",null);
		}
		return vendor.save(vendorObj);
	}
	
	public String deleteVendor(String vendorId) {
		vendor.deleteById(vendorId);
		Optional<Vendor> myVendor = vendor.findById(vendorId);
		if(!myVendor.isPresent()) {
			return "Deleted Successfully Vendor Id " + vendorId;
		}else {
			return "Not Deleted successfully";
		}
		
	}
	
	public Optional<Vendor> getSingleVendor(String vendorId) {
		return vendor.findById(vendorId);
	}
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	}
	
	public List<Vendor> lookupVendorByGST(String GstNo){
		return vendor.lookVendorByGST(GstNo);
	}
}
