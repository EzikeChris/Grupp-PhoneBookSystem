package com.phonebooksystem.phonebooksystem.service

import com.phonebooksystem.phonebooksystem.dto.ContactDTO
import com.phonebooksystem.phonebooksystem.entity.Contact
import com.phonebooksystem.phonebooksystem.exception.ContactNotFoundException
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

    fun updateContact(contactId: Int, contactDTO: ContactDTO ): Any {
        val  existingContact = contactRepository.findById(contactId)
      return   if (existingContact.isPresent) {
            existingContact.get()
                .let {
                    it.name = contactDTO.name
                    it.address= contactDTO.address
                    it.phoneNumber = contactDTO.phoneNumber
                    contactRepository.save(it)
                    ContactDTO(it.id, it.name, it.phoneNumber, it.address)
                }

        }else {
            throw ContactNotFoundException("No Contact Found for the Passed id : $contactId")
        }
    }

    fun deleteContact(contactId: Int) {
        val  existingContact = contactRepository.findById(contactId)
        if (existingContact.isPresent) {
            existingContact.get()
                .let {
                    contactRepository.deleteById(contactId)
                }
        }else {
            throw ContactNotFoundException("No Contact Found for the Passed id : $contactId")
        }
    }
}