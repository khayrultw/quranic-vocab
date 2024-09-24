package com.khw.quranicvocab.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vocab(
    @PrimaryKey
    val id: Int,
    val word: String,
    val meanings: String,
    val priority: Priority = Priority.MEDIUM,
    val status: Boolean = false,
    val backup: Boolean = false
)

enum class Priority {
    LOW, MEDIUM, HIGH
}