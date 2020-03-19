package ng.com.techdepo.spherenews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ng.com.techdepo.spherenews.databinding.NewsItemBinding
import ng.com.techdepo.spherenews.dto.PresentationArticle

class NewsAdapter(private val onClickListener: OnClickListener):ListAdapter<PresentationArticle,NewsAdapter.NewsAdapterViewHolder>(DiffCallback) {



    companion object DiffCallback : DiffUtil.ItemCallback<PresentationArticle>() {
        override fun areItemsTheSame(oldItem: PresentationArticle, newItem: PresentationArticle): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PresentationArticle, newItem: PresentationArticle): Boolean {
            return oldItem.title == newItem.title
        }
    }
    class OnClickListener(val clickListener: (article:PresentationArticle) -> Unit) {
        fun onClick(article: PresentationArticle) = clickListener(article)
    }
    class NewsAdapterViewHolder(private var binding:
                                 NewsItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: PresentationArticle) {
            binding.article = article
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        return NewsAdapterViewHolder(NewsItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(newsItem)
        }
        holder.bind(newsItem)
    }
}