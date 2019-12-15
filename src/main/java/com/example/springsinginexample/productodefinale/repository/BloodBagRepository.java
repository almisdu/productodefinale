package com.example.springsinginexample.productodefinale.repository;



import com.example.springsinginexample.productodefinale.model.BloodBag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BloodBagRepository extends JpaRepository<BloodBag, Long> {

}
