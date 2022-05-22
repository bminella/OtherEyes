package com.bminella.othereyes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bminella.othereyes.Model.OtherEyesModel
import com.bminella.othereyes.R

class OtherEyesAdapter(private val context: Context, private var otherEyesList: List<OtherEyesModel>): RecyclerView.Adapter<OtherEyesAdapter.OtherEyesViewModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherEyesViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return OtherEyesViewModel(view)
    }

    override fun onBindViewHolder(holder: OtherEyesViewModel, position: Int) {
        val otherEyesList = otherEyesList[position]
        holder.ivOtherEyes.setImageResource(otherEyesList.image)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, ""+otherEyesList.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return otherEyesList.size
    }

    class OtherEyesViewModel(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivOtherEyes = itemView.findViewById<ImageView>(R.id.ivOtherEyes);
    }
}