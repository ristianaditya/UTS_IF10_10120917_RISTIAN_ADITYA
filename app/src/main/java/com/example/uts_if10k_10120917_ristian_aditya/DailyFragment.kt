package com.example.uts_if10k_10120917_ristian_aditya

import ActivityAdapter
import ListFriendsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_if10k_10120917_ristian_aditya.models.FriendViewModel
import com.example.uts_if10k_10120917_ristian_aditya.models.ItemsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DailyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DailyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_daily, container, false)
        val recyclerview = rootView.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
            false)

        val data = ArrayList<FriendViewModel>()

        data.add(FriendViewModel(R.drawable.deni, "Deni Alfianies"))
        data.add(FriendViewModel(R.drawable.john, "Johndy Panca"))
        data.add(FriendViewModel(R.drawable.must, "Mustapa Hadzi"))
        data.add(FriendViewModel(R.drawable.alvin, "Muhammad Alvin "))
        data.add(FriendViewModel(R.drawable.rudi, "Randika Rudiadi"))
        data.add(FriendViewModel(R.drawable.sandi, "Sandi Setiawan"))

        // This will pass the ArrayList to our Adapter
        val adapter = ListFriendsAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter




        val recyclerActivity = rootView.findViewById<RecyclerView>(R.id.recyclerviewContents)
        recyclerActivity.layoutManager = LinearLayoutManager(requireContext())

        // ArrayList of class ItemsViewModel
        val dataActivity = ArrayList<ItemsViewModel>()

        dataActivity.add(ItemsViewModel(R.drawable.wgs, "Pelatihan Sekolah Komando Militer", "Dalam demo tersebut, peserta akan terlibat dalam skenario perang yang realistis, memerankan peran penting dalam mengambil keputusan strategis, taktis, dan operasional untuk mencapai kemenangan dalam pertempuran. Melalui penggunaan teknologi canggih dan model simulasi yang akurat, kegiatan demo Wargaming System di Sesko TNI memberikan peluang berharga bagi para pemimpin militer "))
        dataActivity.add(ItemsViewModel(R.drawable.militer, "Demo Wargaming Sesko TNI ", "Kegiatan demo Wargaming System di Sesko TNI merupakan suatu upaya untuk memperkenalkan dan menguji sistem permainan perang secara simulasi yang digunakan dalam konteks pendidikan dan pelatihan militer."))
        dataActivity.add(ItemsViewModel(R.drawable.team_sesko, "My Team", "Dalam kerangka ini, setiap anggota tim memiliki peran dan tanggung jawab yang spesifik, berkontribusi dengan keahlian dan wawasan mereka masing-masing. Kolaborasi dan sinergi di antara anggota tim menjadi faktor kunci dalam mencapai keberhasilan"))
        dataActivity.add(ItemsViewModel(R.drawable.all, "Hangout", "Selama hangout, orang-orang dapat melakukan berbagai aktivitas, seperti berbincang-bincang, bermain game, menikmati makanan dan minuman, atau bahkan melakukan kegiatan yang lebih aktif seperti olahraga atau piknik. "))
        dataActivity.add(ItemsViewModel(R.drawable.games, "Bermain Games", "Games dapat menjadi sarana hiburan dan menghilangkan stres. Mereka menyediakan cara yang bagus untuk bersantai, melepaskan tekanan sehari-hari, dan merasakan kesenangan dalam dunia virtual."))

        // This will pass the ArrayList to our Adapter
        val adapterActivity = ActivityAdapter(dataActivity)
        recyclerActivity.isNestedScrollingEnabled = false;
        // Setting the Adapter with the recyclerview
        recyclerActivity.adapter = adapterActivity

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DailyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DailyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}