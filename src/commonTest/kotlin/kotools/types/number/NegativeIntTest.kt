package kotools.types.number

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotools.types.Package
import kotools.types.assertHasAMessage
import kotools.types.shouldEqual
import kotools.types.shouldNotEqual
import kotlin.test.Test
import kotlin.test.assertFailsWith

class NegativeIntCompanionTest {
    @Test
    fun min_should_equal_the_minimum_value_of_Int() {
        val result: StrictlyNegativeInt = NegativeInt.min
        result.asInt shouldEqual Int.MIN_VALUE
    }

    @Test
    fun max_should_equal_zero() {
        val result: ZeroInt = NegativeInt.max
        result shouldEqual ZeroInt
    }

    @Test
    fun random_should_return_different_values() {
        val result: NegativeInt = NegativeInt.random()
        result.asInt shouldNotEqual NegativeInt.random().asInt
    }
}

class NegativeIntTest {
    @Test
    fun int_asNegativeInt_should_pass_with_a_negative_Int() {
        val value: Int = NegativeInt.random().asInt
        val result: Int = value.asNegativeInt.getOrThrow().asInt
        result shouldEqual value
    }

    @Test
    fun int_asNegativeInt_should_fail_with_a_strictly_positive_Int() {
        val result: Result<NegativeInt> = strictlyPositiveIntRange.random()
            .asNegativeInt
        assertFailsWith<IllegalArgumentException>(block = result::getOrThrow)
            .assertHasAMessage()
    }
}

class NegativeIntSerializerTest {
    @ExperimentalSerializationApi
    @Test
    fun descriptor_should_have_the_qualified_name_of_NegativeInt_as_serial_name() {
        val result: String = NegativeIntSerializer.descriptor.serialName
        result shouldEqual "${Package.number}.NegativeInt"
    }

    @Test
    fun serialization_should_behave_like_an_Int() {
        val x: NegativeInt = NegativeInt.random()
        val result: String = Json.encodeToString(NegativeIntSerializer, x)
        result shouldEqual Json.encodeToString(x.asInt)
    }

    @Test
    fun deserialization_should_pass_with_a_negative_Int() {
        val value: Int = NegativeInt.random().asInt
        val encoded: String = Json.encodeToString(value)
        val result: NegativeInt =
            Json.decodeFromString(NegativeIntSerializer, encoded)
        result.asInt shouldEqual value
    }

    @Test
    fun deserialization_should_fail_with_a_strictly_positive_Int() {
        val value: Int = strictlyPositiveIntRange.random()
        val encoded: String = Json.encodeToString(value)
        val exception: SerializationException = assertFailsWith {
            Json.decodeFromString(NegativeIntSerializer, encoded)
        }
        exception.assertHasAMessage()
    }
}
