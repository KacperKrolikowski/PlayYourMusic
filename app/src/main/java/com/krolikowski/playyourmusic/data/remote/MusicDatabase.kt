package com.krolikowski.playyourmusic.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.krolikowski.playyourmusic.data.entities.Song
import com.krolikowski.playyourmusic.others.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception){
            emptyList()
        }
    }

}