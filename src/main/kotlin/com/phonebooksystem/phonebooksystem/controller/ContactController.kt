package com.phonebooksystem.phonebooksystem.controller


import com.phonebooksystem.phonebooksystem.dto.ContactDTO
import com.phonebooksystem.phonebooksystem.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/* API CONTROLLERS  */
@RestController
@RequestMapping("/v1/contact")
class ContactController(val contactService: ContactService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addContact(@RequestBody contactDTO: ContactDTO){
        return contactService.addContact(contactDTO)
    }

    @GetMapping
    fun getAllContact(): List<ContactDTO> = contactService.getAllContact()


}