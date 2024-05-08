package com.whatsapp.api.backend.service.user;

import com.whatsapp.api.backend.service.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUser(Long userId);

    UserDTO updateUser(Long id, UserDTO userDTO);
}

