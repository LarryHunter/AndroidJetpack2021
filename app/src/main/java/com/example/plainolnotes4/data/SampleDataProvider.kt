package com.example.plainolnotes4.data

import java.util.*

class SampleDataProvider {

    companion object {
        private val sampleText1 = "A simple note"
        private val sampleText2 = "A note with\na line feed"
        private val sampleText3 = """
		Lorem ipsum dolor sit amet consectetur adipisicing elit. Eveniet esse est nulla corporis? Cum, ex aliquam explicabo dolore nihil optio consequatur magnam inventore corrupti distinctio temporibus magni! Magnam maiores esse voluptates. 

        Ipsum fuga, quasi aperiam suscipit beatae perspiciatis aut in libero? Maxime quae ex dolore itaque illum officiis dolor eos quam nam, consequatur impedit cumque est repudiandae ipsam nobis reiciendis culpa beatae molestiae nemo, sed ipsa hic laudantium. Inventore, repudiandae incidunt. Et perferendis explicabo molestiae numquam praesentium culpa sunt repellat quibusdam deserunt eligendi exercitationem, doloribus quas omnis optio alias vel possimus corporis perspiciatis accusamus ab id similique minus quidem? Nemo maxime blanditiis vero soluta dolorem repellat reiciendis magnam excepturi reprehenderit tempore, ad amet debitis corrupti sint ducimus natus ipsam magni eius, et voluptate voluptas, necessitatibus quo sapiente! Vel omnis voluptatum inventore illo nobis harum saepe voluptate explicabo praesentium officia, tempora obcaecati eligendi iusto nam amet quis neque similique exercitationem ipsa dolorum commodi doloremque suscipit nihil. Dignissimos quae eos ipsam nisi quam aliquid neque illo nesciunt minima nemo? Quas dolorum, labore, sed sunt nihil possimus maxime iste numquam ad similique harum consectetur perspiciatis ut earum dignissimos veniam nisi debitis rerum consequatur officia ullam voluptas? Dicta officia maxime incidunt aliquid minus sit iusto quam ratione harum magnam earum suscipit quas laboriosam nesciunt expedita quo, temporibus sapiente itaque at, reprehenderit id cumque atque non alias! Odit dolores at, doloremque quisquam error sint vero tenetur repellendus laudantium veniam quo ipsam dolor, iure eligendi alias debitis porro? Quos nulla quod, doloremque ex nobis soluta officia.
        """.trimIndent()

        private fun getDate(diff: Int): Date {
            return Date(Date().time + diff)
        }

        fun getSampleNotes() = arrayListOf(
            NoteEntity(getDate(0), sampleText1),
            NoteEntity(getDate(1), sampleText2),
            NoteEntity(getDate(2), sampleText3)
        )
    }
}
