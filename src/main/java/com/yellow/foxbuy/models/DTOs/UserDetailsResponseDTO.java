package com.yellow.foxbuy.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsResponseDTO {
    private String username;
    private String email;
    private String role;
    private List<AdResponseDTO> ads;
}
