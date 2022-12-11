package com.example.atheokegarden.core.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.atheokegarden.core.di.Injection
import com.example.atheokegarden.core.domain.usecase.UseCase
import com.example.atheokegarden.layoutone.ViewModelFirstMainLayout
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(private val useCase: UseCase) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideUseCase()
                )
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelFirstMainLayout::class.java)){
            return ViewModelFirstMainLayout(useCase) as T
        }

        throw IllegalArgumentException ("Message ${modelClass.name}")
    }


}