package com.whatsapp.api.backend.service.user;

import com.whatsapp.api.backend.service.dto.UserDTO;
import com.whatsapp.api.backend.entity.Contact;
import com.whatsapp.api.backend.entity.User;
import com.whatsapp.api.backend.exception.UsernameNotFoundException;
import com.whatsapp.api.backend.repository.ContactRepository;
import com.whatsapp.api.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private  final ContactRepository contactRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ContactRepository contactRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        Contact contact = new Contact();

        //Add itself as contact to act as me
        contact.setMobileNumber(userDTO.getMobile());
        contact.setName(userDTO.getName());
        contact = contactRepository.save(contact);

        List<Contact> contacts= new ArrayList<>();
        contacts.add(contact);
        user.setContacts(contacts);

        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUser(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty()){

            throw new UsernameNotFoundException("User not found with userId: " + userId);
        }

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty()){

            throw new UsernameNotFoundException("User not found with userId: " + id);
        }

        User user = modelMapper.map(userDTO, User.class);

        user =userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }
}
