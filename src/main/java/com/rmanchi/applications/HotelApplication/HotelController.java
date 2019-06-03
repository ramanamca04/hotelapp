package com.rmanchi.applications.HotelApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	private HotelRepository hotelRepository;

	public HotelController(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}
	
	@RequestMapping("/all")
	public List<Hotel> getAllHotels() {
		
		List<Hotel>hotels = this.hotelRepository.findAll();
		return hotels;
		
	}
	
	@RequestMapping("/{id}")
	public Optional<Hotel> getHotelById(@PathVariable String id) {
		return this.hotelRepository.findById(id);
		
	}

	@PostMapping
	public void insert(@RequestBody Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable String id, @RequestBody Hotel hotel) {
		this.hotelRepository.save(hotel);
	}
	
	@RequestMapping("/price/{maxPrice}")
	public List<Hotel> filterPrice(@PathVariable int maxPrice) {
		return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		
	}
	
	@RequestMapping("/address/{city}")
	public List<Hotel> filterPrice(@PathVariable String city) {
		return this.hotelRepository.findByCity(city);
		
	}
}
