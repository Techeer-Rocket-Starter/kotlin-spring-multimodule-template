package com.techeer.example.domain.example

import java.util.UUID

interface ExampleRepository {
    fun save(example: Example)

    fun findById(id: UUID): Example?
}
