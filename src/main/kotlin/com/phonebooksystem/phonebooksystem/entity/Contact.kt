package com.phonebooksystem.phonebooksystem.entity

import javax.persistence.*


@Entity
@Table(name = "Contact")
data class Contact (
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id : Int?,
    val name : String,
    val phoneNumber : Number,
    val address: String
)