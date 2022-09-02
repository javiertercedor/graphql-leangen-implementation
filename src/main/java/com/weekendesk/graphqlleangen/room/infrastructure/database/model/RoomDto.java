package com.weekendesk.graphqlleangen.room.infrastructure.database.model;

import com.weekendesk.graphqlleangen.hotel.infrastructure.database.model.HotelDto;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity(name = "Room")
@Data
@NoArgsConstructor
@Immutable
public class RoomDto {

    @Id
    private Long id;
    private Long hotelid;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "hotelid", insertable = false, updatable = false)
    private HotelDto hotel;
}
