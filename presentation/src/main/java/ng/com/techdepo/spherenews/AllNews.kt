package ng.com.techdepo.spherenews


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import ng.com.techdepo.domain.usecases.specific.GetNewsRemote
import ng.com.techdepo.dto.Article

/**
 * A simple [Fragment] subclass.
 */
class AllNews : Fragment() {

    private lateinit var newsApiConfig: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_all_news, container, false)


           activity!!.toolbar_title.text = "All News"
        newsApiConfig = resources.getString(R.string.api_key)
        val mutableList = mutableListOf("US",newsApiConfig)

//        val getNewsRemote = GetNewsRemote()
//
//       getNewsRemote.execute(mutableList,{feed->
//            Toast.makeText(context,feed.size,Toast.LENGTH_SHORT).show()
//       },
//           { error ->
//               Toast.makeText(context,error.toString(),Toast.LENGTH_SHORT).show()
//           }
//       )
        return root
    }



}
