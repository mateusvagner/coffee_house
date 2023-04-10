package com.ifrs.coffeehouse.domain.mapper

import com.ifrs.coffeehouse.data.entity.CoffeeEntity
import com.ifrs.coffeehouse.domain.Coffee
import com.ifrs.coffeehouse.domain.RoastingLevel

class CoffeeMapper {

    fun toEntity(domain: Coffee): CoffeeEntity {
        return CoffeeEntity(
            id = domain.id,
            name = domain.name,
            country = domain.country,
            roastingLevel = domain.roastingLevel.name
        )
    }

    fun toDomain(entity: CoffeeEntity): Coffee {
        return Coffee(
            id = entity.id,
            name = entity.name,
            country = entity.country,
            roastingLevel = RoastingLevel.valueOf(entity.roastingLevel)
        )
    }
}
