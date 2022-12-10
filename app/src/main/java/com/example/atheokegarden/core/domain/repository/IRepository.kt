package com.example.atheokegarden.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.atheokegarden.core.domain.model.ModelSuhu

interface IRepository {
    fun getSuhu(api: String, country: String) : LiveData<ModelSuhu>
}