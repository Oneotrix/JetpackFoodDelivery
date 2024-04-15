package com.oneotrix.nti.domain.models

data class TagModel(
    var id: Int,
    var name : String
){
    enum class Tag() {
        NEW,
        VEGETARIAN,
        HIT,
        SPICE,
        EXPRESS_MENU,
        NOTHING;

        companion object {
            fun convertTagToString(tag: Tag) = when(tag) {
                NEW -> "Новинка"
                VEGETARIAN -> "Вегетарианское блюдо"
                HIT -> "Хит!"
                SPICE -> "Острое"
                EXPRESS_MENU -> "Экспресс-меню"
                NOTHING -> ""
            }

            fun covertStringToTag(tag: String) = when(tag) {
                "Новинка" -> NEW
                "Вегетарианское блюдо" -> VEGETARIAN
                "Хит!" -> HIT
                "Острое" -> SPICE
                "Экспресс-меню" -> EXPRESS_MENU
                else -> NOTHING
            }
        }
    }
}
