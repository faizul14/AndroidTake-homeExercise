package com.example.atheokegarden.layoutone

import androidx.lifecycle.ViewModel
import com.example.atheokegarden.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelFirstMainLayout @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun data(key: String, country: String) = useCase.getSuhu(key, country)
}