package com.example.multigaming

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (
    private val context: Context,
    private var dataset: MutableList<Affirmation>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){


    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val button: Button = view.findViewById(R.id.button)

    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        holder.button.setOnClickListener(View.OnClickListener {
         val context = holder.view.context

            val builder = AlertDialog.Builder( context )
            builder.setTitle(R.string.app_name)
            builder.setMessage(R.string.title)
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes"){dialogInterface, which ->

               // val newPosition = holder.adapterPosition

                Log.d("position"," "+position)
                Log.d("item"," "+context.resources.getString(item.stringResourceId))
                Log.d("adapter"," "+holder.adapterPosition)
                Log.d("Layout"," "+holder.layoutPosition)

//                (0 until dataset.size).forEach { Log.d("dataset"," "+context.resources.getString(dataset[it].stringResourceId))
//                }

                dataset.remove(item)
                notifyItemRemoved(holder.adapterPosition)

//                (0 until dataset.size).forEach { Log.d("datasetdelete"," "+context.resources.getString(dataset[it].stringResourceId))
//                }


                //notifyItemRangeChanged(newPosition, dataset.size)
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(context,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(context,"clicked No",Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        })
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size
}