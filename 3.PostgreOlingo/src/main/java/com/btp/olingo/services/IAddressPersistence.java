package com.btp.olingo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.btp.olingo.entities.Address;
public interface IAddressPersistence extends JpaRepository<Address,String>{

}
