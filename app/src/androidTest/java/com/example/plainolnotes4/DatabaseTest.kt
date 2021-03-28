package com.example.plainolnotes4

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.plainolnotes4.data.AppDatabase
import com.example.plainolnotes4.data.NoteDao
import com.example.plainolnotes4.data.SampleDataProvider
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

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

    @After
    fun closeDb() {
        database.close()
    }
}
