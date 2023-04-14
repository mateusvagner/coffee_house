package com.ifrs.coffeehouse.data.dao

import androidx.room.*
import com.ifrs.coffeehouse.data.entity.CoffeeEntity

@Dao
interface CoffeeDao {

    @Query("SELECT * FROM coffee")
    fun getAll(): List<CoffeeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg coffee: CoffeeEntity)

    @Delete
    fun delete(coffee: CoffeeEntity)

}