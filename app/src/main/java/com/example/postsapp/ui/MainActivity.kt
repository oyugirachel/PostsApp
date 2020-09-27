package com.example.postsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsapp.R
import com.example.postsapp.repository.PostsRepository
import com.example.postsapp.viewmodel.PostsViewModel
import com.example.postsapp.viewmodel.PostsViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            startActivity(Intent(baseContext,ToDoActivity::class.java))
            Snackbar.make(view, "Heading to the TODOS", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        val postsRepository= PostsRepository()
        postsViewModelFactory= PostsViewModelFactory(postsRepository)
        postsViewModel=
            ViewModelProvider(this, postsViewModelFactory).get(PostsViewModel::class.java)

        postsViewModel.getPosts()

        postsViewModel.postsLiveData.observe(this, Observer { postsList->
            recycler_post.apply{
                layoutManager=LinearLayoutManager(this@MainActivity)
                hasFixedSize()
                adapter=PostsAdapter(postsList)
            }
            Toast.makeText(baseContext,"${postsList.size} posts fetched",Toast.LENGTH_LONG).show()
        })
        postsViewModel.postsFailedLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
}