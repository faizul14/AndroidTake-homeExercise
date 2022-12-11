package com.example.atheokegarden.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.atheokegarden.core.data.remote.RemoteDataSource
import com.example.atheokegarden.core.domain.model.ModelSuhu
import com.example.atheokegarden.core.domain.repository.IRepository
import com.example.atheokegarden.core.utils.DataMapper

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource
) : IRepository {
    companion object {
        @Volatile
        var INSTANCE: Repository? = null

        fun getInstance(remote: RemoteDataSource): Repository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Repository(remote)
            }
    }

    override fun getSuhu(api: String, country: String): LiveData<ModelSuhu> {
        return Transformations.map(remoteDataSource.getSuhu(api, country)) {
            it?.current?.let { it1 -> DataMapper.DataResponseToModel(it1) }
        }
    }


}