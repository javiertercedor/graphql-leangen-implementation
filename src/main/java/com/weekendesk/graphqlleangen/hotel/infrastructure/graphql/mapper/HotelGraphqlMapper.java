package com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.mapper;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.model.HotelGraphql;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelGraphqlMapper {

    HotelGraphql fromHotel(Hotel hotel);
}
