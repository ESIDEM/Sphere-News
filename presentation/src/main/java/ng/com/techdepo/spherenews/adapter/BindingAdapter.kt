package ng.com.techdepo.spherenews.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ng.com.techdepo.spherenews.R
import ng.com.techdepo.spherenews.dto.PresentationArticle
import ng.com.techdepo.spherenews.timeAgo

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {

    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("time")
fun bindDat(textView: TextView,time:String?){

    textView.text = timeAgo(time!!)
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<PresentationArticle>?) {

    val adapter = recyclerView.adapter as NewsAdapter
    adapter.submitList(data)
}