package com.techeer.example.application

import com.techeer.example.application.dto.request.ExampleCreateRequest
import com.techeer.example.application.dto.response.ExampleCreateResponse
import com.techeer.example.application.dto.response.ExampleDetailResponse
import com.techeer.example.common.error.BusinessException
import com.techeer.example.domain.example.Example
import com.techeer.example.domain.example.ExampleRepository
import com.techeer.example.domain.example.exception.ExampleErrorCode
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ExampleService(
    private val exampleRepository: ExampleRepository,
) {
    fun createExample(exampleCreateRequest: ExampleCreateRequest): ExampleCreateResponse {
        val example = Example.create(name = exampleCreateRequest.name)
        exampleRepository.save(example)
        return ExampleCreateResponse(example.id)
    }

    fun findExampleById(id: UUID): ExampleDetailResponse {
        val example: Example = exampleRepository.findById(id) ?: throw BusinessException(ExampleErrorCode.NOT_FOUND)
        return ExampleDetailResponse(
            id = example.id,
            name = example.name,
        )
    }
}
