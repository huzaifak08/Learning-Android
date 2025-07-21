package com.huzaifa.learningapp

import android.content.Context
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast

class CustomMenu {
    fun showCustomMenu(context: Context,view: View){
        val pop = PopupMenu(context,view)
        pop.inflate(R.menu.menu)

        pop.setOnMenuItemClickListener {
            when(it!!.itemId){
                R.id.edit -> {
                    Toast.makeText(context, "Click edit", Toast.LENGTH_SHORT).show()
                    true}

                R.id.delete -> {
                    Toast.makeText(context, "Click Delete", Toast.LENGTH_SHORT).show()
                    true}

                R.id.share -> {
                    Toast.makeText(context, "Click Share", Toast.LENGTH_SHORT).show()
                    true}

                else -> false;

            }
        }

        try {
            val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup");
            fieldMPopup.isAccessible = true;
            val mPopup = fieldMPopup.get(pop);

            mPopup.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                .invoke(mPopup,true)

        }catch (err:Exception){

        }finally {
            pop.show();
        }
    }
}