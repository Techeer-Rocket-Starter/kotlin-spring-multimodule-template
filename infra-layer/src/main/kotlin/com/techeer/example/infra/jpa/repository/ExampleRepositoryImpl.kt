package com.techeer.example.infra.jpa.repository

import com.techeer.example.domain.example.Example
import com.techeer.example.domain.example.ExampleRepository
import com.techeer.example.infra.jpa.entity.ExampleEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
internal class ExampleRepositoryImpl(
    private val exampleJpaRepository: ExampleJpaRepository,
) : ExampleRepository {
    override fun save(example: Example) {
        exampleJpaRepository.save(example.entity)
    }

    override fun findById(id: UUID): Example? = exampleJpaRepository.findByIdOrNull(id)?.domain

    private val ExampleEntity.domain: Example
        get() = Example(id = id, name = name)

    private val Example.entity: ExampleEntity
        get() = ExampleEntity(id = id, name = name)
}
