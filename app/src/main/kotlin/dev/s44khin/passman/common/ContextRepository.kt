package dev.s44khin.passman.common

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.os.PersistableBundle
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.s44khin.passman.core.util.NativeText
import javax.inject.Inject

class ContextRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    fun copyToClipboard(label: NativeText, content: NativeText, isSensitiveContent: Boolean) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        val clipData = ClipData.newPlainText(label.resolve(context), content.resolve(context)).apply {
            if (isSensitiveContent) {
                description.extras = PersistableBundle().apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        putBoolean(ClipDescription.EXTRA_IS_SENSITIVE, true)
                    } else {
                        putBoolean("android.content.extra.IS_SENSITIVE", true)
                    }
                }
            }
        }

        clipboard.setPrimaryClip(clipData)
    }
}