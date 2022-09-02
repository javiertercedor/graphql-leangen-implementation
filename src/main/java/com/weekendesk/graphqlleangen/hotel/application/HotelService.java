package com.weekendesk.graphqlleangen.hotel.application;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.hotel.domain.HotelRepository;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository repository;

    public Hotel save(Hotel hotel) {
        return repository.save(hotel);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Hotel byId(Long id) {
        return repository.byId(id);
    }

    public Collection<Hotel> all(){
        return repository.all();
    }
}
