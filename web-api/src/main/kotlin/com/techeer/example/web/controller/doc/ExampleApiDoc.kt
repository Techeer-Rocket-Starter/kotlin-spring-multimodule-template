package com.techeer.example.web.controller.doc

import com.techeer.example.application.dto.request.ExampleCreateRequest
import com.techeer.example.application.dto.response.ExampleCreateResponse
import com.techeer.example.application.dto.response.ExampleDetailResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

@Tag(name = "Example", description = "Example API")
interface ExampleApiDoc {
    @Operation(summary = "Example 생성 API")
    fun createExample(
        @RequestBody exampleCreateRequest: ExampleCreateRequest,
    ): ResponseEntity<ExampleCreateResponse>

    @Operation(summary = "Example 조회 API")
    fun findExampleById(
        @PathVariable("exampleId") id: UUID,
    ): ResponseEntity<ExampleDetailResponse>
}
