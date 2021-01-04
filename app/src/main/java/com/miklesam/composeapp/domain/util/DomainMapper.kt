package com.miklesam.composeapp.domain.util

interface DomainMapper<T, DomainModule> {

    fun mapToDomainModel(model: T): DomainModule

    fun mapFromDomainModel(domainModule: DomainModule): T
}