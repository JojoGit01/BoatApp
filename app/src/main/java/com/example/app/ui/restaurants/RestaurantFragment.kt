package com.example.app.ui.restaurants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.ui.restaurants.*
import kotlinx.android.synthetic.main.fragment_restaurants.*

/**
 * A simple [Fragment] subclass.
 */
class RestaurantFragment : Fragment(), CellClickListener {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RestaurantAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    val items = arrayOf(
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
        Restaurant(R.drawable.ic_menu_contact,"France","Nice","23/09/2021"),
    )

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        RestaurantRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RestaurantAdapter(items, this@RestaurantFragment);
        }
    }

    override fun onCellClickListener(nom: String) {
        Toast.makeText(activity, "Restaurant : $nom", Toast.LENGTH_SHORT).show()
    }
}