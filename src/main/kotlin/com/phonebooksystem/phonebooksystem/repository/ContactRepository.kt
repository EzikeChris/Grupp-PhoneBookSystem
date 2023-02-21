package com.phonebooksystem.phonebooksystem.repository

import com.phonebooksystem.entity.Contact
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Contact, Int> {
}