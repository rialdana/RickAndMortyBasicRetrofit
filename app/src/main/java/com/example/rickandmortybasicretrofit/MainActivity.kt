package com.example.rickandmortybasicretrofit

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rickandmortybasicretrofit.network.RMApi
import com.example.rickandmortybasicretrofit.network.response.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)

        RMApi.retrofitService.getCharactersList().enqueue(object : Callback<CharactersResponse>{
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Log.e("MainActivity", "Error ", t)

            }

            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                Log.i("MainActivity", "Success")

                response.body()!!.results.forEach {character ->
                    Log.i("MainActivity", "Name: ${character.nameCharacter}")
                }

                Glide.with(this@MainActivity).load(response.body()!!.results[0].image).into(image)
            }
        })
    }
}
