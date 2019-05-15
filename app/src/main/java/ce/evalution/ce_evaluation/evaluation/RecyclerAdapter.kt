package ce.evalution.ce_evaluation.evaluation

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import ce.evalution.ce_evaluation.Filter.Subject
import ce.evalution.ce_evaluation.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_subject.view.*

class RecycleAdapter(val context: Context,
                     val items : ArrayList<Subject>
) : RecyclerView.Adapter<ViewHolder>()
{
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        println("55555555555555555555555555555555555555555555555555555555")
        val mView = LayoutInflater
            .from(context)
            .inflate(R.layout.item_subject,parent,false)
        val mViewHolder = ViewHolder(mView)

        mView.setOnClickListener{
            var text = "Subject "+items[mViewHolder.layoutPosition].crsName
            Toast.makeText(context,text, Toast.LENGTH_SHORT).show()

                val intent = Intent(mView.context, List_component::class.java)
            intent.putExtra("coId",items[mViewHolder.layoutPosition].coId)
                mView.context.startActivity(intent)


        }
         // return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        return  mViewHolder
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.name.text = items[p1].crsName
        p0.code.text = items[p1].crsCode
        p0.group.text = " กลุ่ม"+items[p1].sgId
        println("55555555555555555555555555555555555555555555555555555555")
        //Picasso.get().load(items[p1].imageUrl).placeholder(R.mipmap.ic_launcher).into(p0.thumbnailImageView)

    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val name = view.textView5
    val code = view.textView8
    val group = view.textView9
}