package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter( private val wishlist : List<Wish>) :RecyclerView.Adapter<WishAdapter.ViewHolder>()
{
    class ViewHolder( itemView : View) : RecyclerView.ViewHolder( itemView )
    {
        val name : TextView
        val price : TextView
        val link : TextView

        init
        {
            name = itemView.findViewById( R.id.nameTxt )
            price = itemView.findViewById( R.id.priceTxt )
            link = itemView.findViewById( R.id.linkTxt )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val context = parent.context
        val inflater = LayoutInflater.from( context )

        val contactView = inflater.inflate( R.layout.wish_item, parent, false )

        return ViewHolder( contactView )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val wishItem = wishlist.get( position )

        holder.name.text = wishItem.name
        holder.price.text = String.format("$ %.2f", wishItem.price )
        holder.link.text = wishItem.link
    }

    override fun getItemCount(): Int
    {
        return wishlist.size
    }
}