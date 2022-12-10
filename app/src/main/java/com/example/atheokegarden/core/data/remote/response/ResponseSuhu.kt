package com.example.atheokegarden.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResponseSuhu(

	@field:SerializedName("current")
	val current: Current? = null
)

@Parcelize
data class Current(

	@field:SerializedName("temp_c")
	val tempC: Double? = null,

	@field:SerializedName("temp_f")
	val tempF: Double? = null
) : Parcelable
