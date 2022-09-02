package com.weekendesk.graphqlleangen.room.domain;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import java.util.Collection;

public interface RoomRepository {

    Room byId(Long id);

    Room save(Room room);

    void delete(Long id);

    Collection<Room> byHotelId(Long hotelId);
}
