package fr.chalon.weekendentreamis.recyclerviews;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import fr.chalon.weekendentreamis.R;

class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageButton btnRemove;
    private ImageButton btnEdit;
    private CheckBox chkSelect;

    private RecyclerViewHolderActions actions;

    public RecyclerViewHolder(@NonNull View itemView, RecyclerViewHolderActions actions) {
        super(itemView);
        textView = itemView.findViewById(R.id.list_item_value);
        this.btnRemove = itemView.findViewById(R.id.btn_list_item_remove);
        this.btnEdit = itemView.findViewById(R.id.btn_list_item_edit);
        this.chkSelect = itemView.findViewById(R.id.chk_list_item_select);
        this.actions = actions;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public ImageButton getBtnRemove()
    {
        return this.btnRemove;
    }

    public ImageButton getBtnEdit()
    {
        return this.btnEdit;
    }

    public CheckBox getChkSelect() { return this.chkSelect; }

    public void setTextValue(String value) {
        this.textView.setText(value);
    }

    public void setId(long id) {
        this.textView.setTag(id);
    }

    public long getId() {
        return (Long)this.textView.getTag();
    }

    public void textViewOnClick() {
        Intent i = new Intent(this.itemView.getContext(), this.actions.getDetailsActivityTarget());
        i.putExtra("id",this.getId());
        this.itemView.getContext().startActivity(i);
    }

    public void buttonEditOnClick() {
        Intent i = new Intent(this.itemView.getContext(), this.actions.getEditActivityTarget());

        i.putExtra("id",this.getId());
        this.itemView.getContext().startActivity(i);
    }

    public void buttonRemoveOnClick() {
        this.actions.getDeleteCommand().accept(this.getId());
    }

    public void buttonSelectOnClick() {
        this.actions.getSelectCommand().accept(this.getId());
    }

}