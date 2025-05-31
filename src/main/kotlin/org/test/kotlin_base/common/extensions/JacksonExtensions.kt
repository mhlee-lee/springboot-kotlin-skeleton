package org.test.kotlin_base.common.extensions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.test.kotlin_base.common.objectMapper

fun Any?.toJsonOrNull(): String? = try {
    this?.let { objectMapper.writeValueAsString(it) }
} catch (e: Exception) {
    null
}

fun Any?.toJson(default: String): String = try {
    this?.let { objectMapper.writeValueAsString(this) } ?: default
} catch (e: Exception) {
    default
}

fun Any.toJson(): String = objectMapper.writeValueAsString(this)

/**
 * json 문자열을 deserialize 한다. null 또는 실패할 경우 default 값을 반환한다.
 */
inline fun <reified T> String?.toModelOrNull(): T? = try {
    this?.let { objectMapper.readValue(this, jacksonTypeRef<T>()) }
} catch (e: Exception) {
    null
}

inline fun <reified T> String?.toModel(default: T): T = try {
    this?.let { objectMapper.readValue(this, jacksonTypeRef<T>()) } ?: default
} catch (e: Exception) {
    default
}

inline fun <reified T> String.toModel(): T = objectMapper.readValue(this, jacksonTypeRef<T>())
