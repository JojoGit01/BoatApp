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

    val items = arrayOf(
            Restaurant(R.drawable.guy_savoy,"Guy Savoy","12:00-14:30, 19h00-23h00"),
            Restaurant(R.drawable.alain_ducasse,"Alain Ducasse au Plaza Athénée","11h00-15h30, 18h00-23h30"),
            Restaurant(R.drawable.vague_or,"La Vague d’Or","08h00-18h00"),
            Restaurant(R.drawable.ambroisie,"L'Ambroisie","08h00-15h00"),
            Restaurant(R.drawable.auberge_vieux_puit,"L’Auberge du Vieux Puits","10h00-23h00"),
            Restaurant(R.drawable.assiete_champenoise,"L’Assiette Champenoise","24h/24"),
            Restaurant(R.drawable.arpege," L’Arpège", "12h00-22h30"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        RestaurantRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RestaurantAdapter(items, this@RestaurantFragment);
        }
    }

    override fun onCellClickListener(nom: String, horaire: String) {
        Toast.makeText(activity, "Restaurant : $nom\nHoraire : $horaire", Toast.LENGTH_SHORT).show()
    }
}