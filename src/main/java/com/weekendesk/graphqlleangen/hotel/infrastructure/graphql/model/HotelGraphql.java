package com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelGraphql {

    @GraphQLQuery(name = "id", description = "A hotel's id")
    private String id;
    @GraphQLQuery(name = "name", description = "A hotel's name")
    private String name;
    @GraphQLQuery(name = "description", description = "A hotel's description")
    private String description;
}
