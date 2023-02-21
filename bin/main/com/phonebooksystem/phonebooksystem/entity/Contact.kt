package com.phonebooksystem.phonebooksystem.entity

import javax.persistence.*


@Entity
@Table(name = "Contact")
data class Contact (
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id : Int?,
    var name : String,
    var phoneNumber : Number,
    var address: String
)