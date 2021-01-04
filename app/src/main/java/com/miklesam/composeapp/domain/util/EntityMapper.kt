package com.miklesam.composeapp.domain.util

interface EntityMapper<Entity, DomainModule> {

    fun mapFromEntity(entity: Entity): DomainModule

    fun mapToEntity(domainModule: DomainModule): Entity
}