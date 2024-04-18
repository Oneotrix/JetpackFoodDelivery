package com.oneotrix.nti.data.local.models

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import org.mongodb.kbson.BsonObjectId

class ProductsRealm : RealmObject {

    var id: BsonObjectId = BsonObjectId()
    var products: RealmList<SingleProductRealm> = realmListOf()
}