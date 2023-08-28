package com.example.mythirdapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class CustomListViewClass(var cxt: Context, var resource: Int, var objects: MutableList<ListModelClass>):
    ArrayAdapter<ListModelClass>(cxt, resource, objects)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Getting data using view.
        val layoutInflater = LayoutInflater.from(cxt)
        val view = layoutInflater.inflate(resource, null)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)
        val switchBtn = view.findViewById<Button>(R.id.switchBtn)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBox)
        val mItem: ListModelClass =objects[position]

        // Setting values fetched from view.
//        imageView.setImageDrawable(cxt.resources.getDrawable(mItem.img)) // From ListModelClass.
        imageView.setImageResource(mItem.img)
        textView.text = mItem.title // From ListModelClass.

        switchBtn.tag = position
        switchBtn.setOnClickListener {
            val itemSelected = objects.get(it.tag as Int)
//            val itemSelected = objects.get(position)
            objects.remove(itemSelected)
            notifyDataSetChanged()
        }
        return view
    }

}