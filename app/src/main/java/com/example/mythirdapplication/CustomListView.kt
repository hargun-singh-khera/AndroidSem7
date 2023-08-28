package com.example.myfourthapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mythirdapplication.R


class CustomListView(context: Context, var resource: Int, var objects: MutableList<ContactDetails>) :
    ArrayAdapter<ContactDetails>(context, resource, objects)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource,null)
        val ImageView:ImageView = view.findViewById(R.id.image)
        val titleTextView = view.findViewById<TextView>(R.id.textView1)
        val descriptionTextView = view.findViewById<TextView>(R.id.textView2)
        val mItem:ContactDetails = objects[position]
        ImageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        titleTextView.text = mItem.title
        descriptionTextView.text = mItem.description
        return view
    }

}