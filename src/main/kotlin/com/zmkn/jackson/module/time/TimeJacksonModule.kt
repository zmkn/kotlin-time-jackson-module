package com.zmkn.jackson.module.time

import com.fasterxml.jackson.databind.module.SimpleModule
import com.zmkn.jackson.module.time.serializers.InstantToStringSerializer
import com.zmkn.jackson.module.time.serializers.StringToInstantDeserializer
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

object TimeJacksonModule {
    @OptIn(ExperimentalTime::class)
    val instantSerializers = fun SimpleModule.() {
        addSerializer(Instant::class.java, InstantToStringSerializer())
        addDeserializer(Instant::class.java, StringToInstantDeserializer())
    }

    val all: SimpleModule by lazy {
        generateModule(
            instantSerializers,
        )
    }

    fun generateModule(vararg serializers: SimpleModule.() -> Unit): SimpleModule {
        return SimpleModule().apply {
            serializers.forEach {
                it()
            }
        }
    }
}
