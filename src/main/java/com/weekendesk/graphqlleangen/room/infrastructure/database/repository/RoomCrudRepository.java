package com.weekendesk.graphqlleangen.room.infrastructure.database.repository;

import com.weekendesk.graphqlleangen.hotel.infrastructure.database.model.HotelDto;
import com.weekendesk.graphqlleangen.room.infrastructure.database.model.RoomDto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RoomCrudRepository extends CrudRepository<RoomDto, Long> {

    List<RoomDto> findByHotelId(Long hotelId);
}
