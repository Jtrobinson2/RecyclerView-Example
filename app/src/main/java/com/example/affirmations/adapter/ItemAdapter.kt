package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation


class ItemAdapter(private val context: Context, private val dataSet: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)


    }


    /**
     * This creates the view holder and creates the views held by the viewholder. This is invoked by the layout manager
     * @param viewType number of different list item layout files used for the recyclerview
     * @param viewGroup  that the list item is attached to
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //inflates the xml layout into a heirarchy of view objects you can use in code
        val adapterLayout =
            //attach to root is false because recyclerview attaches the layout to the root (the recyclerview) for you
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false);

        return ItemViewHolder(adapterLayout)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    /**
     * Called to update the Viewholder and it's child views with the data from the actual object in the list at this point
     * @param holder viewholder that onCreateViewholder just made
     * @param position
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //get the current dataobject by it's position in the list
        val currentItem = dataSet[position]

        //update the views in the viewholder with the objects data
        holder.textView.text = context.resources.getString(currentItem.stringResourceID)
        holder.imageView.setImageResource(currentItem.imageResourceID)


    }
}