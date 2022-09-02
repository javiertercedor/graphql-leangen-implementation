package com.weekendesk.graphqlleangen.hotel.infrastructure.database.repository;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.hotel.domain.HotelRepository;
import com.weekendesk.graphqlleangen.hotel.infrastructure.database.mapper.HotelDtoMapper;
import com.weekendesk.graphqlleangen.hotel.infrastructure.database.mapper.HotelMapper;
import com.weekendesk.graphqlleangen.hotel.infrastructure.database.model.HotelDto;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class HotelCrudRepositoryAdapter implements HotelRepository {

    private final HotelCrudRepository repository;
    private final HotelMapper hotelMapper;
    private final HotelDtoMapper hotelDtoMapper;

    @Override
    public Hotel byId(Long id) {
        final HotelDto hotelDto = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id %s not found".formatted(id)));

        return hotelMapper.fromHotelDto(hotelDto);
    }

    @Override
    public Hotel save(Hotel hotel) {
        final HotelDto hotelDto = hotelDtoMapper.fromHotel(hotel);
        final HotelDto save = repository.save(hotelDto);
        return hotelMapper.fromHotelDto(save);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Collection<Hotel> all() {
        Collection<Hotel> hotels = new HashSet<>();
        final Iterable<HotelDto> hotelDtos = repository.findAll();
        hotelDtos.forEach(hotel -> hotels.add(hotelMapper.fromHotelDto(hotel)));

        return hotels;
    }
}
