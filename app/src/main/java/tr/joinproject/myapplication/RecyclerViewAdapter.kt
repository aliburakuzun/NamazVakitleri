package tr.joinproject.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**     Code with ❤
╔════════════════════════════╗
║  Created by Buğra Yetkin  ║
╠════════════════════════════╣
║ bugrayetkinn@gmail.com ║
╠════════════════════════════╣
║     19/02/2020 - 21:39     ║
╚════════════════════════════╝
 */
class RecyclerViewAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.NesneTutucu>() {


    class NesneTutucu(view: View) : RecyclerView.ViewHolder(view) {

        val textViewKod: TextView = view.findViewById(R.id.textView1)
        val textViewSehirler: TextView = view.findViewById(R.id.textView2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NesneTutucu {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sehirler_fragment, parent, false)
        return NesneTutucu(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NesneTutucu, position: Int) {
        holder.textViewSehirler.text = list.get(position).toString()
        holder.textViewSehirler.setOnClickListener(View.OnClickListener {


        })
    }

    fun sehirEkle() {

        list.add("İstanbul")
        list.add("Ankara")

    }


}