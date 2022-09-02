package com.weekendesk.graphqlleangen.room.infrastructure.database.mapper;

import com.weekendesk.graphqlleangen.room.domain.Room;
import com.weekendesk.graphqlleangen.room.infrastructure.database.model.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room fromRoomDto(RoomDto roomDto);
}
