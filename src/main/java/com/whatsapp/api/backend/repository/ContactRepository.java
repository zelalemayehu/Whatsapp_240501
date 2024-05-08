package com.whatsapp.api.backend.repository;

import com.whatsapp.api.backend.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Page<Contact> searchContactByNameOrMobileNumber(String name, String phone, Pageable pageable);

}
