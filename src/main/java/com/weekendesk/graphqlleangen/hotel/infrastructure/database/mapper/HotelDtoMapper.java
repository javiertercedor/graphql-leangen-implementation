package com.weekendesk.graphqlleangen.hotel.infrastructure.database.mapper;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.hotel.infrastructure.database.model.HotelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelDtoMapper {

    HotelDto fromHotel(Hotel hotel);
}
