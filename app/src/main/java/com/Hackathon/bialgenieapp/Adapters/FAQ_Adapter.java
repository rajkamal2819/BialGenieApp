package com.Hackathon.bialgenieapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.FAQ_Model;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;

public class FAQ_Adapter extends RecyclerView.Adapter<FAQ_Adapter.myviewholder>{

    ArrayList<FAQ_Model> faqholder;

    public FAQ_Adapter(ArrayList<FAQ_Model> faqholder) {
        this.faqholder = faqholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        FAQ_Model model = faqholder.get(position);
        holder.q.setText(model.getQ());
        holder.ans.setText(model.getAns());
//      holder.tags.setText(model.getTags());

        boolean isExpandable = faqholder.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return faqholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView q,ans,tags;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            q = itemView.findViewById(R.id.faq_question);
            ans = itemView.findViewById(R.id.faq_answer);
//          tags = itemView.findViewById(R.id.faq_tags);

            linearLayout = itemView.findViewById(R.id.faq_linearLayout);
            expandableLayout = itemView.findViewById(R.id.Expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FAQ_Model model = faqholder.get(getAdapterPosition());
                    model.setExpandable(!model.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
