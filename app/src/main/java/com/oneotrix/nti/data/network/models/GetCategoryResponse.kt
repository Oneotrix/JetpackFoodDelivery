package com.oneotrix.nti.data.network.models

import kotlinx.serialization.Serializable

@Serializable
data class GetCategoryResponse(
    val id: Int,
    val name: String,
)
