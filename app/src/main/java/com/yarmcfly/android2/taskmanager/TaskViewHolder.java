package com.yarmcfly.android2.taskmanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yarmcfly.android2.R;
import com.yarmcfly.android2.db.Task;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvTaskName;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTaskName = itemView.findViewById(R.id.tvTaskName);
    }

    public void setData(Task task) {
        tvTaskName.setText(task.name);
    }
}