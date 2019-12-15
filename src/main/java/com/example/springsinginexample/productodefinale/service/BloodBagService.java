package com.example.springsinginexample.productodefinale.service;

import com.example.springsinginexample.productodefinale.model.BloodBag;
import com.example.springsinginexample.productodefinale.repository.BloodBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BloodBagService {

    public void saveBloodBag(BloodBag bloodBag);

    List<BloodBag> listAll();
}
