package com.techeer.example.infra.jpa.repository

import com.techeer.example.infra.jpa.entity.ExampleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

internal interface ExampleJpaRepository : JpaRepository<ExampleEntity, UUID>
