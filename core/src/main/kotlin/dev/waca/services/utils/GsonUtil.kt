package dev.waca.services.utils

import com.google.gson.Gson

fun <V> stringGsonMapper(json: String, cls: Class<V>): V {
    return Gson().fromJson(json, cls);
}


