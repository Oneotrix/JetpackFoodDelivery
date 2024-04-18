package com.oneotrix.nti.data.local.models

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class SingleProductRealm() : RealmObject {

    @PrimaryKey var id: Int = 0
    var categoryId: Int = 0
    var name: String = ""
    var description: String = ""
    var priceCurrent: Int = 0
    var priceOld: Int? = null
    var measure: Int = 0
    var measureUnit: String = ""
    var energyPer100Grams: Double = 0.0
    var proteinsPer100Grams: Double = 0.0
    var fatsPer100Grams: Double = 0.0
    var carbohydratesPer100Grams: Double = 0.0
    var tagsIds: RealmList<Int> = realmListOf()

}