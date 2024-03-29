package com.example.apipractice.data.adapter

import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ApiPractice.databinding.EachRowBinding
import com.example.apipractice.data.Phone

class PhoneAdapter
constructor(private val listener: Listener) : ListAdapter<Phone,PhoneAdapter.PhoneViewHolder>(Diff) {



    inner class PhoneViewHolder(private val binding: EachRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(phone: Phone){
            binding.apply {
                name.text = phone.name
                phoneNo.text = phone.phoneNo.toString()
                delete.setOnClickListener {
                    listener.deleteOnClick(adapterPosition,phone.userId)
                }
                root.setOnClickListener {
                    listener.updateOnClick(adapterPosition,phone.userId,phone.name,phone.phoneNo)
                }
            }
        }
    }

    object Diff : DiffUtil.ItemCallback<Phone>(){
        override fun areItemsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(EachRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = getItem(position)
        if(phone != null){
            holder.bind(phone)
        }
    }
}