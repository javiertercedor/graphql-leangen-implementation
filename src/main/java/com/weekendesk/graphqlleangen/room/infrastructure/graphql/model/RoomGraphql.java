package com.weekendesk.graphqlleangen.room.infrastructure.graphql.model;

import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.model.HotelGraphql;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomGraphql {

    @GraphQLQuery(name = "id", description = "A room's id")
    private String id;
    @GraphQLQuery(name = "hotelId", description = "A hotel id related")
    private String hotelId;
    @GraphQLQuery(name = "name", description = "Name of the room")
    private String name;
    @GraphQLQuery(name = "description", description = "Description of the room")
    private String description;
    @GraphQLQuery(name = "hotel", description = "Hotel related")
    private HotelGraphql hotel;
}
