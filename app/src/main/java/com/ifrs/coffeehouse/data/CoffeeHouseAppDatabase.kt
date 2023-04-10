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

    private var appDatabase: CoffeeHouseAppDatabase? = null

    abstract fun coffeeDao(): CoffeeDao

    open fun getInstance(context: Context): CoffeeHouseAppDatabase? {
        if (appDatabase == null) {
            appDatabase = databaseBuilder(
                context.applicationContext,
                CoffeeHouseAppDatabase::class.java,
                "database_name"
            ).allowMainThreadQueries().build()
        }
        return appDatabase
    }
}