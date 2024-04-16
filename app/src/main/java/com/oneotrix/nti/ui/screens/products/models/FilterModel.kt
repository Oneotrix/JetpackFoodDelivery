package com.oneotrix.nti.ui.screens.products.models

import com.oneotrix.nti.domain.models.CategoryModel

data class FilterModel(
    val id: Int,
    val name: String = "",
    val isSelected: Boolean = false,
) {
    companion object {
        fun map(categoryModel: CategoryModel) : FilterModel {
            return FilterModel(
                id = categoryModel.id,
                name = categoryModel.name,
                isSelected = false
            )
        }
    }
}
