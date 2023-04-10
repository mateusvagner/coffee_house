package com.ifrs.coffeehouse.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ifrs.coffeehouse.data.dao.CoffeeDao
import com.ifrs.coffeehouse.data.entity.CoffeeEntity

@Database(
    entities = [CoffeeEntity::class],
    version = 1
)
abstract class CoffeeHouseAppDatabase : RoomDatabase() {

    abstract fun coffeeDao(): CoffeeDao

}