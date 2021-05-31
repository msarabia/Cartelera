package com.msarabia.cartelera.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.msarabia.cartelera.BR

/***
 * Generic Adapter for Video Items
 * @param items: List of Items
 * @param itemLayout : Layout to use to render information
 * @param listener is a anonymous function callback to process the event
 */
class VideoAdapter(val items:List<Any>, val itemLayout:Int, val imageSize:String, val listener:(Any)->Unit?) : RecyclerView.Adapter<VideoAdapter.ItemViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding  : ViewDataBinding =  DataBindingUtil.inflate(inflater,itemLayout,parent,false)
        return  ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item,imageSize)
        holder.binding.root.setOnClickListener {
            listener(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(val binding:ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(obj:Any?,imageSize: String){
            binding.setVariable(BR.data,obj)
            binding.setVariable(BR.imageSize,imageSize)
            binding.executePendingBindings()
        }

    }

}