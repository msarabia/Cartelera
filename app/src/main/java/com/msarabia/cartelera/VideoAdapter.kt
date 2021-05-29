package com.msarabia.cartelera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/***
 * Generic Adapter for Video Items
 * @param items: List of Items
 * @param itemLayout : Layout to use to render information
 * @param listener is a anonymous function callback to process the event
 */
class VideoAdapter(val items:List<Any>, val itemLayout:Int, val istener:()->Unit) : RecyclerView.Adapter<VideoAdapter.ItemViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding  : ViewDataBinding =  DataBindingUtil.inflate(inflater,itemLayout,parent,false)
        return  ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(val binding:ViewDataBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(obj:Any?){
            //binding.setVariable(BR.data,obj)
            binding.executePendingBindings()
        }

    }

}