package com.mertoenjosh.mythoughts

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private var yourThoughtsTitle: String? = null
    private var yourThoughtsBody: String? = null

    lateinit var titleTextView: TextView
    lateinit var bodyTextView: TextView
    lateinit var sendEmail: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.title)
        bodyTextView = findViewById(R.id.thoughts_body)
        sendEmail = findViewById(R.id.email)

        yourThoughtsTitle = intent.getStringExtra("title")
        yourThoughtsBody = intent.getStringExtra("body")

        titleTextView.text = yourThoughtsTitle
        bodyTextView.text = yourThoughtsBody

        sendEmail.setOnClickListener {
            shareEmail()
        }
    }

    private fun shareEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)

        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mertoenjosh@yahoo.com", "martinnjorogethuo@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, yourThoughtsTitle)
        intent.putExtra(Intent.EXTRA_TEXT, yourThoughtsBody)

        startActivity(Intent.createChooser(intent, "Choose an email client"))


    }
}