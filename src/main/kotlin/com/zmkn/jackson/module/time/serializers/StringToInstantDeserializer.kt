package com.zmkn.jackson.module.time.serializers

import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.ValueDeserializer
import kotlin.time.Instant

class StringToInstantDeserializer : ValueDeserializer<Instant>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Instant = Instant.parse(p.string)
}
