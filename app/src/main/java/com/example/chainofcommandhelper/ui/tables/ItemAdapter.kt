package com.example.chainofcommandhelper.ui.tables

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chainofcommandhelper.R

import com.github.chrisbanes.photoview.PhotoView

class ItemAdapter(
    private val context: Context,
    private val dataset: List<TableModel>
    ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.table_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.titleResId)
        holder.imageView.setImageResource(item.imageResId)
        holder.imageView.setOnClickListener {
            val builder = AlertDialog.Builder(this.context)
            val view: View = LayoutInflater.from(context)
                .inflate(R.layout.photo_dialog_view, null)
            val photoView = view.findViewById(R.id.photo_view) as PhotoView
            photoView.setImageResource(item.imageResId)
            builder.setView(view)
            builder.create().show()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}