//nama : Ristian Aditya
//NIM  : 10120917
//Kelas : IF10K
//TGL Pengerjaan : 29 Mei 2023

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_if10k_10120917_ristian_aditya.R
import com.example.uts_if10k_10120917_ristian_aditya.models.MusicModel
class MusicAdapter(private val mList: List<MusicModel>) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null
    var currentPlayingPosition = -1

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_list_music, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(itemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.text

        holder.buttonPlay.setOnClickListener {
            if (currentPlayingPosition == position) {
                if (mediaPlayer?.isPlaying == true) {
                    mediaPlayer?.pause()
                    holder.buttonPlay.setImageResource(R.drawable.baseline_play_arrow_24)
                } else {
                    mediaPlayer?.start()
                    holder.buttonPlay.setImageResource(R.drawable.baseline_pause_24)
                }
            } else {
                currentPlayingPosition = position
                releaseMediaPlayer()

                mediaPlayer = MediaPlayer.create(holder.itemView.context, itemsViewModel.songResId)
                mediaPlayer?.setOnCompletionListener {
                    releaseMediaPlayer()
                    holder.buttonPlay.setImageResource(R.drawable.baseline_play_arrow_24)
                }

                mediaPlayer?.start()
                holder.buttonPlay.setImageResource(R.drawable.baseline_pause_24)
            }
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val buttonPlay: ImageButton = itemView.findViewById(R.id.imagePlay)

    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}