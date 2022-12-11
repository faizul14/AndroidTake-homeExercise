package com.example.atheokegarden.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.atheokegarden.core.data.remote.response.ResponseSuhu
import com.example.atheokegarden.core.domain.model.ModelSuhu

interface UseCase {
    fun getSuhu(api: String, country: String) : LiveData<ModelSuhu>
}