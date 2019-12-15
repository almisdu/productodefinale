package com.example.springsinginexample.productodefinale.service;

import com.example.springsinginexample.productodefinale.model.BloodBag;
import com.example.springsinginexample.productodefinale.repository.BloodBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service("bloodBagService")
public class BloodBagServiceImpl implements  BloodBagService {


    @Autowired
    private BloodBagRepository bloodBagRepository;


    @Override
    public void saveBloodBag(BloodBag bloodBag) {
        bloodBag.toString() ;
        bloodBagRepository.save(bloodBag);
    }

    @Override
    public List<BloodBag> listAll() {
        return null;
    }
}
