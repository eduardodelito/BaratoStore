package com.enaz.baratostore.common.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Utility class that add proper margin to grid items on recyclerView
 *
 * Created by eduardo.delito on 4/29/20.
 */
class MarginItemDecoration(private val space: Int, private val spanCount: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

        val itemPosition = parent.getChildAdapterPosition(view)
        val itemColumn = itemPosition % spanCount

        with(outRect) {
            left = itemColumn * space / spanCount
            right = space - (itemColumn + 1) * space / spanCount
            if (itemPosition >= spanCount) {
                top = space
            }
        }
    }
}
