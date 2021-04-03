package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.Utils.getid;
import com.example.model.CarModel;
import com.example.repo.CarRepository;

@Service
@Transactional
public class CarService {
	
	private static  CarRepository carRepo;
	
	@Autowired
	public CarService(CarRepository carRepo) {
		CarService.carRepo = carRepo;
	}
	
	public Integer addCarModel(CarModel car) {
		System.out.print(car.getCarID());
		Optional<CarModel> check = carRepo.findBycarID(car.getCarID());
		System.out.println(check);
		if(check.isEmpty()) {
			carRepo.save(car);
			return 1;
		}else {
			return 0;
		}
	}
	public Integer updateCar(CarModel car) {
		Optional<CarModel> find =carRepo.findBycarID(car.getCarID());
		if(find.isEmpty()) {
			return 1;
		}else{
			carRepo.save(car);
			return 0;
		}
	}
	public void deleteCar(getid id) {
		carRepo.deleteByCarID(Integer.parseInt(id.getId()));
	}
	public List<CarModel> findAllCars() {
        return carRepo.findAll();
    }
	public Optional<CarModel> findByCarId(getid id) {
		System.out.print(Integer.parseInt(id.getId()));
		return carRepo.findBycarID(Integer.parseInt(id.getId()));
	}
	public static List<CarModel> getdashboard(Integer aid){
		ArrayList<CarModel> find_cars = new ArrayList<>();
		for(CarModel c:carRepo.findAll()) {
			if(Integer.parseInt(c.getAdminID())==aid) {
				find_cars.add(c);
			}
		}
		return find_cars;
	}

}
