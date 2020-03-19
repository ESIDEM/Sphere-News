package ng.com.techdepo.spherenews.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class NewsItemDecorator(private val hori:Int, private  val vert:Int):RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = hori
        outRect.left = hori

        if(parent.getChildLayoutPosition(view)==0){
            outRect.top = vert
        }

        outRect.bottom = vert
    }
}