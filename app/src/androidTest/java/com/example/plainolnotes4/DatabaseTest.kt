package com.example.plainolnotes4

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.plainolnotes4.data.AppDatabase
import com.example.plainolnotes4.data.NoteDao
import com.example.plainolnotes4.data.NoteEntity
import com.example.plainolnotes4.data.SampleDataProvider
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var dao: NoteDao
    private lateinit var database: AppDatabase

    @Before
    fun createDb() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        dao = database.noteDao()!!
    }

    @Test
    fun createNotes() {
        dao.insertAll(SampleDataProvider.getSampleNotes())
        val count = dao.getCount()
        assertEquals(count, SampleDataProvider.getSampleNotes().size)
    }

    @Test
    fun enterNoteWithTextOnly() {
        val note = NoteEntity()
        note.text = "This is the first note test!"
        dao.insertNote(note)
        val newNote = dao.getNoteById(1)
        assertEquals(newNote?.id ?: 0, 1)
    }

    @Test
    fun enterNoteWithDateAndText() {
        val date = Date()
        val text = "This is a test Note..."
        val note = NoteEntity(date, text)
        dao.insertNote(note)

        val newNote = dao.getNoteById(1)
        assertEquals(newNote!!.date, date)
        assertEquals(newNote.text, text)
    }

    @Test
    fun enterMultipleNotes() {
        val noteList = mutableListOf<NoteEntity>()
        for (i in 0..1) {
            noteList.add(i, NoteEntity(Date(), "This is note #${(i + 1)}"))
        }
        dao.insertAll(noteList)
        val countOfNotes = dao.getCount()
        assertEquals(countOfNotes, noteList.size)
    }

    @After
    fun closeDb() {
        database.close()
    }
}
