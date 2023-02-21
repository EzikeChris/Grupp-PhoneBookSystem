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
    fun createContact(@RequestBody contactDTO: ContactDTO){
        return contactService.addContact(contactDTO)
    }

    @GetMapping
    fun fetchAllContact(): List<ContactDTO> = contactService.getAllContact()

    @PutMapping("/{contact_id}")
    fun getContact(@RequestBody contactDTO: ContactDTO, @PathVariable("contact_id") contactId : Int) = contactService.updateContact(contactId, contactDTO)

    @DeleteMapping("/{contact_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteContact(@PathVariable("contact_id") contactId : Int)
    = contactService.deleteContact(contactId)
}