package com.whatsapp.api.backend.service.contact;

import com.whatsapp.api.backend.service.dto.ContactDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Contactservice {

    ContactDTO createContact(ContactDTO contactDTO);

    Page<ContactDTO> getAllContact(Pageable pageable);

    Page<ContactDTO> searchContact(String nameOrPhone, Pageable pageable);

}