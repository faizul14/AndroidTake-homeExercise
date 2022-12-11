package com.example.atheokegarden.core.data

import androidx.lifecycle.LiveData
import com.example.atheokegarden.core.data.remote.RemoteDataSource
import com.example.atheokegarden.core.domain.model.ModelSuhu
import com.example.atheokegarden.core.domain.repository.IRepository
import com.example.atheokegarden.core.utils.DataMapper

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource
) : IRepository {
    companion object{
        @Volatile
        var INSTANCE : Repository? = null

        fun getInstance(remote: RemoteDataSource): Repository =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Repository(remote)
            }
    }

    override fun getSuhu(api: String, country: String): ModelSuhu {
        val data = remoteDataSource.getSuhu(api,country)
        return data?.current?.let { DataMapper.DataResponseToModel(it) }!!
    }


}