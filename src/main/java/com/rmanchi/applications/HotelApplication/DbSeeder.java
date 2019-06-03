package com.rmanchi.applications.HotelApplication;


import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private HotelRepository hotelRepository;
	

	public DbSeeder(HotelRepository hotelRepository) {
	
		this.hotelRepository = hotelRepository;
	}


	@Override
	public void run(String... args) throws Exception {
			Hotel marriot = new Hotel("Marriot", 130, 
							new Address("Paris", "France"), 
							Arrays.asList(new Review("John", 8, false), new Review("Mary", 7, true)));
			
			Hotel crownePlaza = new Hotel("Crowne Plaza", 90, 
					new Address("Chennai", "India"), 
					Arrays.asList(new Review("Ramana", 8, false), new Review("Rao", 7, true)));
		
			//drop all hotels
			this.hotelRepository.deleteAll();
			
			//add our hotels to the db
			List<Hotel> hotels = Arrays.asList(marriot, crownePlaza);
			this.hotelRepository.saveAll(hotels);
			
			
	}
	
	


}
