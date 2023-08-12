package com.ingkoon.ingsKotlin.common.exception.common

import java.lang.RuntimeException

class PreconditionFailedException : RuntimeException {
    constructor() : super("Body is Incorrect form")
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}