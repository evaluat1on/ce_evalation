package ce.evalution.ce_evaluation.evaluation

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ce.evalution.ce_evaluation.Filter.Student_re
import ce.evalution.ce_evaluation.R
import ce.evalution.ce_evaluation.Update_Grade
import kotlinx.android.synthetic.main.item_student.view.*

class Recyclestudent(val context: Context,
                     val items : ArrayList<Student_re>
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
            val intent = Intent(mView.context, Update_Grade::class.java)
            intent.putExtra("coId",items[mViewHolder.layoutPosition].ss_id)
            mView.context.startActivity(intent)


        }
        // return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        return  mViewHolder
    }

    override fun onBindViewHolder(p0: ViewHolder,p1: Int) {
        p0.name.text = items[p1].full_name
        p0.code.text = items[p1].stdCode
        p0.group.text = " เกรด" + items[p1].ss_grade
        println("55555555555555555555555555555555555555555555555555555555")
        //Picasso.get().load(items[p1].imageUrl).placeholder(R.mipmap.ic_launcher).into(p0.thumbnailImageView)

    }

}

//class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
//    val name = view.textView13
//    val code = view.textView14//
//    val group = view.textView15
//}