package com.weekendesk.graphqlleangen.shared;

import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.HotelQuery;
import com.weekendesk.graphqlleangen.room.infrastructure.graphql.RoomQuery;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GraphqlConfig {

    private final HotelQuery hotelQuery;
    private final RoomQuery roomQuery;

    @Bean
    GraphQLSchema schema() {

        GraphQLSchemaGenerator schemaGenerator =
                new GraphQLSchemaGenerator()
                        .withResolverBuilders(
                                new AnnotatedResolverBuilder(),
                                new PublicResolverBuilder("com.weekendesk.graphqlleangen"));

        schemaGenerator = schemaGenerator
                .withOperationsFromSingleton(hotelQuery)
                .withOperationsFromSingleton(roomQuery);
        return schemaGenerator.withValueMapperFactory(new JacksonValueMapperFactory()).generate();
    }
}
