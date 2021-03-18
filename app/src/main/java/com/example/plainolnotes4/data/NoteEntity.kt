package com.example.plainolnotes4.data

import java.util.*

data class NoteEntity(
    val id: Int,
    val date: Date,
    val text: String
) {
    constructor() : this(NEW_NOTE_ID, Date(), "")
    constructor(date: Date, text: String) : this(NEW_NOTE_ID, date, text)
}
