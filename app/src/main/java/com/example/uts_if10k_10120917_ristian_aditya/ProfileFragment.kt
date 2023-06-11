package com.example.uts_if10k_10120917_ristian_aditya

import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
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
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        val whatsapp = rootView.findViewById<Button>(R.id.whatsappButton)
        val instagram = rootView.findViewById<Button>(R.id.instagramButton)
        val gmail = rootView.findViewById<Button>(R.id.emailButton)
        val maps = rootView.findViewById<Button>(R.id.mapsButton)
        val about = rootView.findViewById<Button>(R.id.aboutButton)

        whatsapp.setOnClickListener {
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=+6285352585444")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        instagram.setOnClickListener {
            val packageManager = activity?.packageManager
            val intent = Intent(Intent.ACTION_VIEW)
            val url = "https://www.instagram.com/_u/rstnadty"

            intent.data = Uri.parse(url)

            try {
                val packageInfo = packageManager?.getPackageInfo("com.instagram.android", 0)
                intent.setPackage("com.instagram.android")
                startActivity(intent)
            } catch (e: PackageManager.NameNotFoundException) {
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }

        gmail.setOnClickListener {
            val recipientEmail = "ristianaditya35@gmail.com"
            val subject = "10120917"
            val body = "Nama : Ristian Aditya, Nim : 10120917"

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, body)
            val packageManager = activity?.packageManager
            val activities = packageManager?.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)

            if (activities?.size!! > 0) {
                startActivity(intent)
            } else {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/?extsrc=mailto&url=${Uri.encode("mailto:$recipientEmail?subject=$subject&body=$body")}"))
                startActivity(webIntent)
            }
        }

        maps.setOnClickListener {
            val latitude = -6.887303157629754
            val longitude = 107.55432948450122
            val label = "Lokasi Rumah"
            val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($label)")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            val packageManager = activity?.packageManager
            val activities = packageManager?.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)

            if (activities?.size!! > 0) {
                startActivity(intent)
            } else {
                // Tidak ada aplikasi Google Maps yang terpasang, buka Google Maps melalui browser
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=$latitude,$longitude"))
                startActivity(webIntent)
            }
        }

        about.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.version_dialog)
            val buttonOke = dialog.findViewById<Button>(R.id.buttonOkeKembali)
            buttonOke?.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

        // Inflate the layout for this fragment
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}