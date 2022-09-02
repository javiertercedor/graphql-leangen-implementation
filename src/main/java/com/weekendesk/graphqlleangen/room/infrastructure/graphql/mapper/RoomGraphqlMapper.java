package com.weekendesk.graphqlleangen.room.infrastructure.graphql.mapper;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.model.HotelGraphql;
import com.weekendesk.graphqlleangen.room.domain.Room;
import com.weekendesk.graphqlleangen.room.infrastructure.graphql.model.RoomGraphql;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomGraphqlMapper {

    RoomGraphql fromRoomGraphql(Room room);

    HotelGraphql map(Hotel value);
}
