package com.example.atheokegarden.layoutone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atheokegarden.core.domain.model.ModelSuhu
import com.example.atheokegarden.core.domain.usecase.UseCase

class ViewModelFirstMainLayout(private val useCase: UseCase): ViewModel() {
    fun data(key: String, country: String) = useCase.getSuhu(key,country)
}