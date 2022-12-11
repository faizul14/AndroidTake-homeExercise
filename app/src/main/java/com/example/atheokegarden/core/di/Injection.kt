package com.example.atheokegarden.core.di

import com.example.atheokegarden.core.data.Repository
import com.example.atheokegarden.core.data.remote.RemoteDataSource
import com.example.atheokegarden.core.data.remote.network.ApiConfig
import com.example.atheokegarden.core.domain.repository.IRepository
import com.example.atheokegarden.core.domain.usecase.UseCase
import com.example.atheokegarden.core.domain.usecase.UseCaseIteractor

object Injection {
    private fun provideRepository(): IRepository {
        val remote = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        return Repository.getInstance(remote)
    }

    fun provideUseCase(): UseCase {
        val repository = provideRepository()
        return UseCaseIteractor(repository)
    }
}