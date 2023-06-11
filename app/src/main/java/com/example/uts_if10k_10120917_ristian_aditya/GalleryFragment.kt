package com.example.uts_if10k_10120917_ristian_aditya

//nama : Ristian Aditya
//NIM  : 10120917
//Kelas : IF10K
//TGL Pengerjaan : 29 Mei 2023

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_if10k_10120917_ristian_aditya.adapters.GalleryAdapter
import com.example.uts_if10k_10120917_ristian_aditya.models.GalleryModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GalleryFragment : Fragment() {
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
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_gallery, container, false)

        val courseRV = rootView.findViewById<RecyclerView>(R.id.recycleGallery)

        val courseList = ArrayList<GalleryModel>()

        val layoutManager = GridLayoutManager(requireContext(), 3)

        courseRV.layoutManager = layoutManager

        // on below line we are adding data to our list
        courseList.add(GalleryModel( R.drawable.profile))
        courseList.add(GalleryModel(R.drawable.militer))
        courseList.add(GalleryModel(R.drawable.cover_photo))
        courseList.add(GalleryModel(R.drawable.all))
        courseList.add(GalleryModel(R.drawable.team))
        courseList.add(GalleryModel(R.drawable.hall))
        courseList.add(GalleryModel(R.drawable.wgs))
        courseList.add(GalleryModel(R.drawable.must))
        courseList.add(GalleryModel(R.drawable.rudi))
        courseList.add(GalleryModel(R.drawable.alvin))
        courseList.add(GalleryModel(R.drawable.me))
        courseList.add(GalleryModel(R.drawable.deni))
        courseList.add(GalleryModel(R.drawable.john))
        courseList.add(GalleryModel(R.drawable.sandi))
        courseList.add(GalleryModel(R.drawable.team_sesko))

        // on below line we are initializing our adapter
        val galleryAdapter = GalleryAdapter(courseList, requireContext())

        courseRV.adapter = galleryAdapter
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GalleryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GalleryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}