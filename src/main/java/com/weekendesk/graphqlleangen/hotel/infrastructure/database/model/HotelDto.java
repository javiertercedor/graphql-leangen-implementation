package com.weekendesk.graphqlleangen.hotel.infrastructure.database.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity(name = "Hotel")
@Data
@NoArgsConstructor
@Immutable
public class HotelDto {
    
    @Id
    private Long id;
    private String name;
    private String description;
}
