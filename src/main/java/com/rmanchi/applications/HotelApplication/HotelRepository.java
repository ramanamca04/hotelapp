package com.rmanchi.applications.HotelApplication;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
	
	List<Hotel> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value = "{'address.city':?0}")
	List<Hotel> findByCity(String city);

}
