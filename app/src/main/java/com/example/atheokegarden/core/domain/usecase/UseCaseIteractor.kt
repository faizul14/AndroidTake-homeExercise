package com.example.atheokegarden.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.atheokegarden.core.domain.model.ModelSuhu
import com.example.atheokegarden.core.domain.repository.IRepository
import javax.inject.Inject

class UseCaseIteractor @Inject constructor(private val repository: IRepository) : UseCase {
    override fun getSuhu(api: String, country: String): LiveData<ModelSuhu> {
        return repository.getSuhu(api, country)
    }
}