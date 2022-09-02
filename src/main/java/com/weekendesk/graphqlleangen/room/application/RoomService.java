package com.weekendesk.graphqlleangen.room.application;

import com.weekendesk.graphqlleangen.hotel.domain.Hotel;
import com.weekendesk.graphqlleangen.room.domain.Room;
import com.weekendesk.graphqlleangen.room.domain.RoomRepository;
import java.util.Collection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository repository;

    public Room save(Room room) {
        return repository.save(room);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Room byId(Long id) {
        return repository.byId(id);
    }

    public Collection<Room> byHotelId(Long id) {
        return this.repository.byHotelId(id);
    }
}
