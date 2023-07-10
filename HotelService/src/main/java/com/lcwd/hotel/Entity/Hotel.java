package com.lcwd.hotel.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String hotelid;
    private String name;
    private String location;
    private String about;

}
