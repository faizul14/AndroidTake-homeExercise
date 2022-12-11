package com.example.atheokegarden.layoutone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atheokegarden.core.domain.model.ModelSuhu
import com.example.atheokegarden.core.domain.usecase.UseCase

class ViewModelFirstMainLayout(private val useCase: UseCase): ViewModel() {
    val _data = MutableLiveData<ModelSuhu>()
    val data: LiveData<ModelSuhu> = _data

    fun getSuhu(key: String, country: String){
        _data.value = useCase.getSuhu(key,country)
    }
}