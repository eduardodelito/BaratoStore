package com.enaz.baratostore.common.util

import android.content.res.AssetManager
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import io.reactivex.disposables.Disposable

/**
 * Created by eduardo.delito on 4/29/20.
 */

/**
 * Extension function to set the text value of textView. It also set the visibility depending on the message value
 *
 * @param message the informative message to display
 */
fun AppCompatTextView.setLabelWithVisibility(message: String?) {
    with(this) {
        visibility = message?.let {
            text = message
            View.VISIBLE
        } ?: View.GONE
    }
}

/**
 * Extension function to set visibility depending on isVisible value.
 *
 * @param isVisible value true or false
 */
fun View.setViewWithVisibility(isVisible: Boolean) {
    with(this) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}

/**
 * Extension function to handle rxJava disposal safely
 *
 * @return boolean object to state the result of safe dispose
 */
fun Disposable?.safeDispose() = if (this != null && !isDisposed) {
    dispose()
    true
} else false

fun AssetManager.readAssetsFile(fileName: String): String =
    open(fileName).bufferedReader().use { it.readText() }
