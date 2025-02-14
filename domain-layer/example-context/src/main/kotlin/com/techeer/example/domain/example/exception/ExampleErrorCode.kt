package com.techeer.example.domain.example.exception

import com.techeer.example.common.error.ErrorCode

enum class ExampleErrorCode(
    override val code: String,
    override val message: String,
) : ErrorCode {
    NAME_IS_BLANK("EX001", "이름이 비어있습니다."),
}
