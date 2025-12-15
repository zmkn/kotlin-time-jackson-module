package com.zmkn.jackson.module.time.serializers

import tools.jackson.core.JsonGenerator
import tools.jackson.databind.SerializationContext
import tools.jackson.databind.ValueSerializer
import kotlin.time.Instant

class InstantToStringSerializer : ValueSerializer<Instant>() {
    override fun serialize(value: Instant, gen: JsonGenerator, ctxt: SerializationContext) {
        gen.writeString(value.toString())
    }
}
