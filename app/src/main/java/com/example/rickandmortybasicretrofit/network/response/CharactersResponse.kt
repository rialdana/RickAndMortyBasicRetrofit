package com.example.rickandmortybasicretrofit.network.response

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    val info: Info,

    val results: List<CharacterInfo>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)

data class CharacterInfo(
    val id: Int,

    @SerializedName("name")
    val nameCharacter: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Url,
    val location: Url,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

data class Url(
    val name: String,
    val url: String
)