package com.whatsapp.api.backend.service.contact;

import com.whatsapp.api.backend.entity.Contact;
import com.whatsapp.api.backend.repository.ContactRepository;
import com.whatsapp.api.backend.service.dto.ContactDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements Contactservice{

    private final ContactRepository contactRepository;

    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {

        Contact contact = contactRepository.save(modelMapper.map(contactDTO, Contact.class));

        return modelMapper.map(contact, ContactDTO.class);

    }

    @Override
    public Page<ContactDTO> getAllContact(Pageable pageable) {

        Page<Contact> contactList = contactRepository.findAll(pageable);

        List<ContactDTO> dtoList = contactList.stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, contactList.getTotalElements());
    }

    @Override
    public Page<ContactDTO> searchContact(String nameOrPhone, Pageable pageable) {

        Page<Contact> contactList = contactRepository.searchContactByNameOrMobileNumber(nameOrPhone, nameOrPhone, pageable);

        List<ContactDTO> dtoList = contactList.stream()
                .map(contact -> modelMapper.map(contact, ContactDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, contactList.getTotalElements());
    }
}
