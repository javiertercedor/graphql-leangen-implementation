package com.weekendesk.graphqlleangen.hotel.infrastructure.database.repository;

import com.weekendesk.graphqlleangen.hotel.infrastructure.database.model.HotelDto;
import org.springframework.data.repository.CrudRepository;

public interface HotelCrudRepository extends CrudRepository<HotelDto, Long> {

}
