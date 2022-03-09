package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.socialapp.daos.PostDao
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class CreatePostActivity : AppCompatActivity() {

    private lateinit var postDao: PostDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postDao = PostDao()

        val postInput: EditText = findViewById(R.id.postInput)
        val postButton: Button = findViewById(R.id.postButton)

        postButton.setOnClickListener {
            val input = postInput.text.toString().trim()
            if(input.isNotEmpty())
            {
                postDao.addPost(input)
                finish()
            }
        }

    }
}