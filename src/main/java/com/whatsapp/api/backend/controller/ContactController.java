package com.whatsapp.api.backend.controller;

import com.whatsapp.api.backend.service.contact.Contactservice;
import com.whatsapp.api.backend.service.dto.ContactDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final Contactservice contactservice;

    public ContactController(Contactservice contactservice) {

        this.contactservice = contactservice;
    }

    @PostMapping("")
    public ResponseEntity<ContactDTO> creteContact(@RequestBody ContactDTO contactDTO ){

        ContactDTO contact = contactservice.createContact(contactDTO);

        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Page<ContactDTO>> getAllContact(Pageable pageable){

        return ResponseEntity.ok(contactservice.getAllContact(pageable));
    }

    @GetMapping("/search/{nameOrPhone}")
    public ResponseEntity<Page<ContactDTO>> searchContact(@PathVariable("nameOrPhone") String nameOrPhone,Pageable pageable){

        return ResponseEntity.ok(contactservice.searchContact(nameOrPhone, pageable));

    }

}
