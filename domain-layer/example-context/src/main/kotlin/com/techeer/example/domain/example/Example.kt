package com.techeer.example.domain.example

import com.techeer.example.common.error.BusinessException
import com.techeer.example.domain.example.exception.ExampleErrorCode.NAME_IS_BLANK
import java.util.UUID

class Example(
    val id: UUID,
    val name: String,
) {
    init {
        if (name.isBlank()) throw BusinessException(NAME_IS_BLANK)
    }

    companion object {
        fun create(name: String): Example = Example(id = UUID.randomUUID(), name = name)
    }
}
