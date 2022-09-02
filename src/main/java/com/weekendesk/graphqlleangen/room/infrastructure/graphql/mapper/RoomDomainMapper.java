package com.weekendesk.graphqlleangen.room.infrastructure.graphql.mapper;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.room.domain.Room;
import com.weekendesk.graphqlleangen.room.infrastructure.graphql.model.RoomGraphql;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomDomainMapper {

    Room fromRoomGraphql(RoomGraphql roomGraphql);
}
