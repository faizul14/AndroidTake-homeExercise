package com.example.atheokegarden.core.utils

import com.example.atheokegarden.core.data.remote.response.Current
import com.example.atheokegarden.core.data.remote.response.ResponseSuhu
import com.example.atheokegarden.core.domain.model.ModelSuhu

object DataMapper {
    fun DataResponseToModel(input: Current): ModelSuhu{
        val data = ModelSuhu(
            tempC = input.tempC,
            tempF = input.tempF
        )
        return data
    }
}