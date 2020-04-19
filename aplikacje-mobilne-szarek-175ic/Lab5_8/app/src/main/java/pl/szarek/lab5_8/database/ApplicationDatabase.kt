package pl.szarek.lab5_8.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.szarek.lab5_8.R
import pl.szarek.lab5_8.database.dao.LanguageDao
import pl.szarek.lab5_8.database.entity.Language


@Database(
    entities = [
        Language::class
    ],
    version = 1,
    exportSchema = true
)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun getLanguageDao(): LanguageDao

    companion object {
        private var INSTANCE: ApplicationDatabase? = null

        operator fun invoke(application: Application): ApplicationDatabase {
            return INSTANCE ?: synchronized(ApplicationDatabase::class) {
                build(application).also {
                    INSTANCE = it
                }
            }
        }

        private fun build(application: Application): ApplicationDatabase {
            return Room.databaseBuilder(
                application,
                ApplicationDatabase::class.java,
                application.getString(R.string.database_name)
            )
                .build()
        }
    }
}