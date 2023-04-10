package com.ifrs.coffeehouse.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ifrs.coffeehouse.data.entity.CoffeeEntity

@Dao
interface CoffeeDao {

    @Query("SELECT * FROM coffee")
    fun getAll(): List<CoffeeEntity>

    @Insert
    fun insertAll(vararg coffee: CoffeeEntity)

    @Delete
    fun delete(coffee: CoffeeEntity)

}