package com.user.Service.Entites;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    private String hotelid;
    private String name;
    private String location;
    private String about;
}
