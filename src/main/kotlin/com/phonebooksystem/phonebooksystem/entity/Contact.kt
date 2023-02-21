package com.phonebooksystem.phonebooksystem.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue



@Entity
@Table(name = "Contact")
data class Contact (
    @Id
    @GeneratedValue(strategy = GeneratedType.AUTO)
    val id : Int?,
    val name : String,
    val phoneNumber : Number,
    val address: String
)