package com.example.atheokegarden.core.di

import com.example.atheokegarden.core.data.Repository
import com.example.atheokegarden.core.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(suhuRepository: Repository): IRepository
}