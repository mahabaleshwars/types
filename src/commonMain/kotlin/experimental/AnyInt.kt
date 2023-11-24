/*
 * Copyright 2023 Kotools S.A.S.U.
 * Use of this source code is governed by the MIT license.
 */

package kotools.types.experimental

import kotools.types.ExperimentalSinceKotoolsTypes
import kotools.types.number.AnyInt
import kotlin.jvm.JvmSynthetic

/**
 * Returns the negative of this integer number.
 *
 * Here's an example of calling this function from Kotlin code:
 *
 * ```kotlin
 * val number = AnyInt(1)
 * val result: AnyInt = -number // or number.unaryMinus()
 * println(result) // -1
 * ```
 *
 * Please note that this function is currently not available for Java users.
 */
@ExperimentalKotoolsTypesApi
@ExperimentalSinceKotoolsTypes("4.3.2")
@JvmSynthetic
public operator fun AnyInt.unaryMinus(): AnyInt {
    val value: Int = -toInt()
    return AnyInt(value)
}