package com.weekendesk.graphqlleangen.hotel.infrastructure.graphql;

import com.weekendesk.graphqlleangen.hotel.application.HotelService;
import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.mapper.HotelGraphqlMapper;
import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.mapper.HotelDomainMapper;
import com.weekendesk.graphqlleangen.hotel.infrastructure.graphql.model.HotelGraphql;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HotelQuery {

    private final HotelService hotelService;
    private final HotelDomainMapper hotelMapper;
    private final HotelGraphqlMapper hotelGraphqlMapper;

    @GraphQLMutation(name = "saveHotel")
    public HotelGraphql saveHotel(@GraphQLArgument(name = "hotel") HotelGraphql hotel) {
        final Hotel hotelDomain = hotelMapper.fromHotelGrapqhql(hotel);
        final Hotel save = hotelService.save(hotelDomain);

        return hotelGraphqlMapper.fromHotel(save);
    }

    @GraphQLMutation(name = "deleteHotel")
    public void deleteHotel(@GraphQLNonNull @GraphQLArgument(name = "id") Long id) {
        hotelService.delete(id);
    }

    @GraphQLQuery(name = "hotelById")
    public HotelGraphql hotelById(@GraphQLNonNull @GraphQLArgument(name = "id") Long id) {
        final Hotel hotel = hotelService.byId(id);

        return hotelGraphqlMapper.fromHotel(hotel);
    }

    @GraphQLQuery(name = "allHotels")
    public Collection<HotelGraphql> allHotels() {
        return hotelService.all().stream()
                .map(hotelGraphqlMapper::fromHotel)
                .toList();
    }
}
