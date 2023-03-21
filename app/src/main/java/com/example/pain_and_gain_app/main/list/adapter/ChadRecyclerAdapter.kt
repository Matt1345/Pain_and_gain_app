package com.example.pain_and_gain_app.main.list.adapter

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.pain_and_gain_app.DetailsActivity
import com.example.pain_and_gain_app.R
import com.example.pain_and_gain_app.databinding.ChadItemViewBinding
import com.example.pain_and_gain_app.model.NetWorth
import com.example.pain_and_gain_app.model.TopG
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList

class ChadRecyclerAdapter(val context: Context, val chadList: ArrayList<TopG>) :
    RecyclerView.Adapter<ChadRecyclerAdapter.ChadViewHolder>() {

    class ChadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ChadItemViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChadViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.chad_item_view, parent, false)
        return ChadViewHolder(view)
    }

    override fun getItemCount(): Int = chadList.count()

    override fun onBindViewHolder(holder: ChadViewHolder, position: Int) {
        val chad = chadList[position]

        holder.binding.root.backgroundTintList = ColorStateList.valueOf(
            when (chad.netWorth) {
                NetWorth.BROKIE -> {
                    context.getColor(R.color.purple_200)
                }
                NetWorth.DEBT_SLAVE -> context.getColor(R.color.purple_700)
                NetWorth.WAGE_SLAVE -> context.getColor(R.color.chinese_silver)
                NetWorth.STILL_POOR -> context.getColor(R.color.granite_gray)
                NetWorth.TOP_G -> context.getColor(R.color.max_green)
            }
        )

        val doomer = "https://i1.sndcdn.com/artworks-000658878094-4e3trz-t500x500.jpg"
        val zoomer1 = "https://i.kym-cdn.com/photos/images/newsfeed/001/567/815/0d2.png"
        val zoomer2 = "https://miro.medium.com/v2/resize:fit:1177/1*t4k3HaFKtLvFl_JCofsZHA.png"
        val chadwick = "https://www.memetemplates.in/uploads/1628870796.png"

        val listaNoobova = arrayListOf<String>(doomer, zoomer1, zoomer2, chadwick)
        var pic = listaNoobova.get(chad.pictureId)
        if (chad.firstname.toString().equals("Andrew")) {
            pic = "https://phantom-marca.unidadeditorial.es/a398e432c3ab16be1de9482b10182251/crop/0x0/827x551/resize/1320/f/jpg/assets/multimedia/imagenes/2022/12/30/16724168218056.jpg"
        }

        holder.binding.listElement.setOnClickListener {
            val snackbar = Snackbar.make(
                it,
                "Are you sure you want to see details for this BUSTER?",
                Snackbar.LENGTH_LONG
            )

            snackbar.setAction("Yes") {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("message", chad.toString())
                intent.putExtra("name", chad.firstname + " " + chad.lastName)
                intent.putExtra("picture", pic)
                context.startActivity(intent)
            }
            snackbar.show()
        }

        holder.binding.apply {
            firstname.text = chad.firstname
            lastname.text = chad.lastName
            age.text = chad.age.toString()
            // nationality.text = chad.nationality
            placeOfResidence.text = chad.placeOfResidence
            playerStatus.text = chad.nmrOfGirfriends
            picture.load(pic) {
                transformations(CircleCropTransformation())
            }
        }
    }
}
