package ce.evalution.ce_evaluation.result

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ce.evalution.ce_evaluation.R


import kotlinx.android.synthetic.main.item_subject_report.view.*

class RecycleAdapterOnSubject(val context: Context,
                              val items : ArrayList<StudentReport>
) : RecyclerView.Adapter<ViewHolder>()
{
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater
            .from(context)
            .inflate(R.layout.item_subject_report,parent,false)
        val mViewHolder = ViewHolder(mView)

        mView.setOnClickListener{
        }
        //  return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        return  mViewHolder
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView14.text = items[p1].stdCode
        p0.textView13.text = items[p1].pfName+" "+items[p1].stdName+" "+items[p1].stdSurname
        p0.textView15.text = "Grade: "+items[p1].ss_grade



    }

}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val textView14 = view.subject_name
    val textView13 = view.subject_id
    val textView15 = view.count_no
}
