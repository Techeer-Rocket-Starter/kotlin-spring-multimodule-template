package com.techeer.example.web.controller

import com.techeer.example.application.ExampleService
import com.techeer.example.application.dto.request.ExampleCreateRequest
import com.techeer.example.application.dto.response.ExampleCreateResponse
import com.techeer.example.application.dto.response.ExampleDetailResponse
import com.techeer.example.web.controller.doc.ExampleApiDoc
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/example")
class ExampleController(
    private val exampleService: ExampleService,
) : ExampleApiDoc {
    @PostMapping
    override fun createExample(
        @RequestBody exampleCreateRequest: ExampleCreateRequest,
    ): ResponseEntity<ExampleCreateResponse> = ResponseEntity.ok(exampleService.createExample(exampleCreateRequest))

    @GetMapping("/{exampleId}")
    override fun findExampleById(
        @PathVariable("exampleId") id: UUID,
    ): ResponseEntity<ExampleDetailResponse> = ResponseEntity.ok(exampleService.findExampleById(id))
}
