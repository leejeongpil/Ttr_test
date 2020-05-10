package com.example.ttr_test.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ttr_test.Fragment.MarketInfo.MarketInfoActivity
import com.example.ttr_test.R
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentsListModel>(
            ContentsListModel("a1", "b1", 1, "c1"),
            ContentsListModel("a2", "b2", 2, "c2"),
            ContentsListModel("a3", "b3", 3, "c3"),
            ContentsListModel("a4", "b4", 4, "c4"),
            ContentsListModel("a5", "b5", 5, "c5"),
            ContentsListModel("a6", "b6", 6, "c6"),
            ContentsListModel("a7", "b7", 7, "c7")
        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter= list_adapter

        view.listview_first_fragment.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}
