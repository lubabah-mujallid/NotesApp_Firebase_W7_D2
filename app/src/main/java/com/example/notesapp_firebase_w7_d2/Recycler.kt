package com.example.notesapp_firebase_w7_d2

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp_firebase_w7_d2.databinding.RecyclerLayoutBinding

class Recycler(val activity: MainActivity): RecyclerView.Adapter<Recycler.ViewHolder>() {
    private var messages: ArrayList<Note> = ArrayList()
    class ViewHolder(val binding: RecyclerLayoutBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var message = messages[position]
        holder.binding.apply {
            tvID.text = ""
            tvNote.text = message.text
            edit.setOnClickListener {
                Log.d("TAG RV", "edit button pressed")
                activity.alertDialog(true, message)
            }
            delete.setOnClickListener {
                Log.d("TAG RV", "delete button pressed")
                activity.alertDialog(false, message)
            }
        }
    }

    override fun getItemCount() = messages.size

    fun update(newMessages: ArrayList<Note>){
        this.messages = newMessages
        notifyDataSetChanged()
    }
}