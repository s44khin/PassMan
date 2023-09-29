package dev.s44khin.passman.core.util

import androidx.compose.runtime.Immutable
import java.util.UUID

@Immutable
data class UID(val uuid: UUID) {

    companion object {

        fun randomUID() = UID(UUID.randomUUID())
    }

    override fun equals(other: Any?) = uuid == other

    override fun hashCode() = uuid.hashCode()

    override fun toString() = uuid.toString()
}
