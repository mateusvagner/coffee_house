package com.ifrs.coffeehouse.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.ifrs.coffeehouse.data.dao.CoffeeDao
import com.ifrs.coffeehouse.data.entity.CoffeeEntity


@Database(
    entities = [CoffeeEntity::class],
    version = 1
)
abstract class CoffeeHouseAppDatabase : RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDao

    companion object {
        private var appDatabase: CoffeeHouseAppDatabase? = null
        fun getInstance(context: Context) = appDatabase ?: synchronized(this) {

            val localInstanceAppDatabase = databaseBuilder(
                context.applicationContext,
                CoffeeHouseAppDatabase::class.java,
                "database_name"
            ).allowMainThreadQueries().build()

            appDatabase = localInstanceAppDatabase
            appDatabase!!
        }
    }
}