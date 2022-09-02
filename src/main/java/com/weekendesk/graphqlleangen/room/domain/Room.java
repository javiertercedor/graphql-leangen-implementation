package com.weekendesk.graphqlleangen.room.domain;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;

public record Room(Long id,
                   Long hotelId,
                   String name,
                   String description,
                   Hotel hotel) {

}
