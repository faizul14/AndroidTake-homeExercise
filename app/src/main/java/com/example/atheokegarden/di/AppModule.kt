package com.example.atheokegarden.di

import com.example.atheokegarden.core.domain.usecase.UseCase
import com.example.atheokegarden.core.domain.usecase.UseCaseIteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(useCaseIteractor: UseCaseIteractor): UseCase
}