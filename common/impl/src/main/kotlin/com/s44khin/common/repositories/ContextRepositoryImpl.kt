package com.s44khin.common.repositories

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.s44khin.common.api.repositories.ContextRepository
import javax.inject.Inject


class ContextRepositoryImpl @Inject constructor(
    private val context: Context
) : ContextRepository {

    override fun copyToClipBoard(label: String, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText(label, text)
        clipboard?.setPrimaryClip(clip)
    }
}