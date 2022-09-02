package com.weekendesk.graphqlleangen.hotel.domain;

import java.util.Collection;
import java.util.Optional;

public interface HotelRepository {

    Hotel byId(Long id);

    Hotel save(Hotel hotel);

    void delete(Long id);

    Collection<Hotel> all();
}
