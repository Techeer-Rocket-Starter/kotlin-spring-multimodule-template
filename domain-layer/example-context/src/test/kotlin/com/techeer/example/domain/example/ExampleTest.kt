package com.techeer.example.domain.example

import com.techeer.example.common.error.AssertUtil
import com.techeer.example.domain.example.exception.ExampleErrorCode.NAME_IS_BLANK
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class ExampleTest {
    @Test
    fun `모든 필드가 유효할 때 Example 생성에 성공한다`() {
        // uuid Mocking
        val uuid = UUID.randomUUID()
        mockkStatic(UUID::class)
        every { UUID.randomUUID() } returns uuid

        // when
        val name = "name"
        val example = Example.create(name)

        // then
        assertEquals(uuid, example.id)
        assertEquals(name, example.name)
    }

    @Test
    fun `이름이 빈 문자열이면 예외가 발생한다`() {
        // uuid Mocking
        val uuid = UUID.randomUUID()
        mockkStatic(UUID::class)
        every { UUID.randomUUID() } returns uuid

        // when
        AssertUtil.assertErrorCode(NAME_IS_BLANK) {
            Example.create("")
        }
    }
}
