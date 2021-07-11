package com.mertoenjosh.mythoughts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var yourThoughtsTitle: String? = null
    private var yourThoughtsBody: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterYourThoughtsTitle = findViewById<EditText>(R.id.enterYourThoughtsEditTextTitle)
        val enterYourThoughtsBody = findViewById<EditText>(R.id.enterYourThoughtsEditTextBody)
        val saveYourThoughtsButton = findViewById<Button>(R.id.saveYourThoughts)
        val viewYourThoughtsTextView = findViewById<TextView>(R.id.viewYourThoughtsTextView)

        saveYourThoughtsButton.setOnClickListener {
            yourThoughtsTitle = enterYourThoughtsTitle.text.toString()
            yourThoughtsBody = enterYourThoughtsBody.text.toString()
            if (yourThoughtsTitle!!.isNotBlank() && yourThoughtsBody!!.isNotBlank()) {
                viewYourThoughtsTextView.text = " $yourThoughtsTitle \n$yourThoughtsBody"
                viewYourThoughtsTextView.visibility = View.VISIBLE
                enterYourThoughtsTitle.setText("")
                enterYourThoughtsBody.setText("")
            }
        }

        viewYourThoughtsTextView.setOnClickListener{
            if (yourThoughtsTitle.isNullOrEmpty() || yourThoughtsBody.isNullOrEmpty()) return@setOnClickListener

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", yourThoughtsTitle)
            intent.putExtra("body", yourThoughtsBody)
            startActivity(intent)
        }
    }
}