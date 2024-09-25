package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Data for the paintings
    private val paintingNames = arrayOf(
        "Dancing",
        "Portrait of Maria Maurizio",
        "The Siege Of Saragossa",
        "A Good Point",
        "A Male Nude Standing"
    )

    private val authors = arrayOf(
        "Manuel Cabral Aguado Bejarano",
        "Jan Matejko",
        "Horace Vernet",
        "Thomas Blinks",
        "Anna Bilińska-Bohdanowicz"
    )

    private val years = arrayOf(
        "1889", "1860", "1819", "Unknown", "1884"
    )

    private val images = arrayOf(
        R.drawable.dancing,
        R.drawable.portrait,
        R.drawable.siege,
        R.drawable.a_good_point,
        R.drawable.male
    )

    private var currentIndex = 0

    // Views
    private lateinit var pictureView: ImageView
    private lateinit var nameView: TextView
    private lateinit var authorView: TextView
    private lateinit var yearView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pictureView = findViewById(R.id.pictures)
        nameView = findViewById(R.id.name)
        authorView = findViewById(R.id.author)
        yearView = findViewById(R.id.year)

        val prevButton: Button = findViewById(R.id.prev)
        val nextButton: Button = findViewById(R.id.next)

        updateGallery()

        prevButton.setOnClickListener {
            currentIndex = getPreviousIndex(currentIndex)
            updateGallery()
        }

        nextButton.setOnClickListener {
            currentIndex = getNextIndex(currentIndex)
            updateGallery()
        }
    }

    private fun getPreviousIndex(index: Int): Int {
        return when {
            index > 0 -> index - 1
            else -> paintingNames.size - 1
        }
    }

    private fun getNextIndex(index: Int): Int {
        return when {
            index < paintingNames.size - 1 -> index + 1
            else -> 0
        }
    }

    private fun updateGallery() {
        pictureView.setImageResource(images[currentIndex])
        nameView.text = paintingNames[currentIndex]
        authorView.text = authors[currentIndex]
        yearView.text = years[currentIndex]
    }
}
