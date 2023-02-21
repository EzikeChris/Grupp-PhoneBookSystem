package com.phonebooksystem.phonebooksystem.repository

import com.phonebooksystem.phonebooksystem.entity.Contact
import org.springframework.data.repository.CrudRepository

interface ContactRepository : CrudRepository<Contact, Int> {
}