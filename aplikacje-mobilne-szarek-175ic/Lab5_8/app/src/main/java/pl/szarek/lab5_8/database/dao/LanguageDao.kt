package pl.szarek.lab5_8.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.szarek.lab5_8.database.entity.Language

@Dao
interface LanguageDao {
    @Query("SELECT * FROM languages")
    suspend fun getAll(): List<Language>

    @Insert
    suspend fun insertAll(languages: List<Language>)

    @Insert
    suspend fun insert(languages: Language)
}