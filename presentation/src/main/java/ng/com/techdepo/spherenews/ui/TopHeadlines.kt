package ng.com.techdepo.spherenews.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import ng.com.techdepo.spherenews.R

/**
 * A simple [Fragment] subclass.
 */
class TopHeadlines : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_top_headlines, container, false)

        activity!!.toolbar_title.text = "Top Headlines"

        return root
    }


}
