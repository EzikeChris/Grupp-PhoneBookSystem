package com.phonebooksystem.phonebooksystem.service

import com.phonebooksystem.phonebooksystem.dto.ContactDTO
import com.phonebooksystem.phonebooksystem.entity.Contact
import com.phonebooksystem.phonebooksystem.repository.ContactRepository
import org.springframework.stereotype.Service

@Service
class ContactService(val contactRepository : ContactRepository) {
    fun addContact(contactDTO: ContactDTO) {

        val contactEntity =  contactDTO.let {
            Contact(null, it.name, it.phoneNumber, it.address)
        }
        contactRepository.save(contactEntity)

        return contactEntity.let {
            ContactDTO(null, it.name, it.phoneNumber, it.address)
        }
    }

    fun getAllContact(): List<ContactDTO> {
     return  contactRepository.findAll()
            .map {
                ContactDTO(null, it.name, it.phoneNumber, it.address)
            }
    }
}