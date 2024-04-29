package com.example.inspirehubtask

import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val arrayList: List<Data>) :RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder (ItemView: View):RecyclerView.ViewHolder(ItemView){
        val button1: Button = itemView.findViewById(R.id.btnItem1)
        val button2: Button = itemView.findViewById(R.id.btnItem2)
        val button3: Button = itemView.findViewById(R.id.btnItem3)
        val button4: Button = itemView.findViewById(R.id.btnItem4)
        val button5: Button = itemView.findViewById(R.id.btnItem5)
        val button6: Button = itemView.findViewById(R.id.btnItem6)
        val button7: Button = itemView.findViewById(R.id.btnItem7)
        val button8: Button = itemView.findViewById(R.id.btnItem8)
        val button9: Button = itemView.findViewById(R.id.btnItem9)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rec_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = arrayList[position]
        holder.button1.text = underlineText(data.btn1)
        holder.button2.text = underlineText(data.btn2)
        holder.button3.text = underlineText(data.btn3)
        holder.button4.text = underlineText(data.btn4)
        holder.button5.text = underlineText(data.btn5)
        holder.button6.text = underlineText(data.btn6)
        holder.button7.text = underlineText(data.btn7)
        holder.button8.text = underlineText(data.btn8)
        holder.button9.text = underlineText(data.btn9)



    }

}
private fun underlineText(text: String): SpannableString {
    val spannableString = SpannableString(text)
    val underlineSpan = UnderlineSpan()
    spannableString.setSpan(underlineSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    return spannableString
}