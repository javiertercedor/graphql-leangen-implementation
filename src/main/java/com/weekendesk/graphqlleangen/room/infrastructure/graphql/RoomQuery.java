package com.weekendesk.graphqlleangen.room.infrastructure.graphql;

import com.weekendesk.graphqlleangen.room.application.RoomService;
import com.weekendesk.graphqlleangen.room.domain.Room;
import com.weekendesk.graphqlleangen.room.infrastructure.graphql.mapper.RoomDomainMapper;
import com.weekendesk.graphqlleangen.room.infrastructure.graphql.mapper.RoomGraphqlMapper;
import com.weekendesk.graphqlleangen.room.infrastructure.graphql.model.RoomGraphql;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.Collection;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomQuery {

    private final RoomService service;
    private final RoomDomainMapper roomDomainMapper;
    private final RoomGraphqlMapper roomGraphqlMapper;

    @GraphQLMutation(name = "saveRoom")
    public RoomGraphql saveRoom(@GraphQLArgument(name = "room") RoomGraphql roomGraphql) {
        final Room room = roomDomainMapper.fromRoomGraphql(roomGraphql);
        final Room save = service.save(room);

        return roomGraphqlMapper.fromRoomGraphql(save);
    }

    @GraphQLMutation(name = "deleteRoom")
    public void deleteRoom(@GraphQLNonNull @GraphQLArgument(name = "id") Long id) {
        this.service.delete(id);
    }

    @GraphQLQuery(name = "roomById")
    public RoomGraphql roomById(@GraphQLNonNull @GraphQLArgument(name = "id") Long id) {
        final Room room = service.byId(id);
        return roomGraphqlMapper.fromRoomGraphql(room);
    }

    @GraphQLQuery(name = "roomByHotelId")
    public Collection<RoomGraphql> roomByHotelId(@GraphQLNonNull @GraphQLArgument(name = "id") Long id) {
        final Collection<Room> rooms = service.byHotelId(id);
        return rooms.stream()
                .map(roomGraphqlMapper::fromRoomGraphql)
                .toList();
    }
}
