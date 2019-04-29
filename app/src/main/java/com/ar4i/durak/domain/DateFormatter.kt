package com.ar4i.durak.domain

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    companion object {
        private val PATTERN: String = "dd.MM.yyyy"

        fun converTimeStampToDate(timestamp: Long): String {
            val date = Date(timestamp)
            val format = SimpleDateFormat(PATTERN)
            return format.format(date)
        }
    }

}