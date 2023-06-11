package com.example.uts_if10k_10120917_ristian_aditya

import MusicAdapter
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_if10k_10120917_ristian_aditya.models.MusicModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicFragment : Fragment() {
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
        val rootView = inflater.inflate(R.layout.fragment_music, container, false)
        val videoView = rootView.findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.music_video

        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(requireContext())
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        mediaController.requestFocus()

        val imageButton = rootView.findViewById<ImageButton>(R.id.play_button)
        imageButton.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start()
                imageButton.visibility = View.GONE
            }
        }

        val recyclerview = rootView.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        // ArrayList of class ItemsViewModel
        val data = ArrayList<MusicModel>()

        data.add(MusicModel(R.drawable.happier, "Olivia Rodrigo - happier ", R.raw.happier))
        data.add(MusicModel(R.drawable.alan, "Alan Jackson - Remember When ", R.raw.remeber))
        data.add(MusicModel(R.drawable.rod, "I Don't Want To Talk About It ", R.raw.idont))
        data.add(MusicModel(R.drawable.hall, "Hal L ", R.raw.hal))

        // This will pass the ArrayList to our Adapter
        val adapter = MusicAdapter(data)
        recyclerview.isNestedScrollingEnabled = false;
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}