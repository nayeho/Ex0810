package com.example.ex0810;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    Context context; // 현재 페이지 정보
    int layout; // 항목 뷰 디자인
    List<ChatVO> data; // 아이템셋

    LayoutInflater inflater; // xml파일 -> View객체
    ViewHolder viewHolder;

    String currentID; // 현재 로그인한 ID

    public ChatAdapter(Context context, int layout, List<ChatVO> data, String currentID) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        this.currentID = currentID;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            // 무조건 1회만 실행
            // 1회만 처리해야 하는 코드는 다 여기로 모여!!
            // convertView 생성
            // 각 ID 초기화화

            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder(convertView);
        }

        // 현재 내가 로그인한 ID와
        // msg를 보내고 있는 ID가 동일한지 구분

        if (currentID.equals(data.get(position).getName())){
            // 오른쪽 2개 뷰를 보여주고, 왼쪽 4개를 감추자.
            // 1. 오른쪽 2개 뷰 보여짐(user에 해당하는 View객체 2개 보여짐)
            viewHolder.tv_user_msg.setVisibility(View.VISIBLE);
            viewHolder.tv_user_time.setVisibility(View.VISIBLE);
            // 2. user관련 2개의 View에 외부에서 담아 온 정보를 받아주자
            viewHolder.tv_user_msg.setText(data.get(position).getMsg());
            viewHolder.tv_user_time.setText(data.get(position).getTime());
            // 3. Other관련 4개 View객체
            viewHolder.img.setVisibility(View.GONE);
            viewHolder.tv_other_user.setVisibility(View.GONE);
            viewHolder.tv_other_msg.setVisibility(View.GONE);
            viewHolder.tv_other_time.setVisibility(View.GONE);
        }else{
            // 왼쪽 4개 뷰를 보여주고, 오른쪽 2개를 감추자.
            viewHolder.img.setVisibility(View.VISIBLE);
            viewHolder.tv_other_user.setVisibility(View.VISIBLE);
            viewHolder.tv_other_msg.setVisibility(View.VISIBLE);
            viewHolder.tv_other_time.setVisibility(View.VISIBLE);
            // other관련 4개의 View에 외부 정보를 담아주자
            viewHolder.img.setImageResource(data.get(position).getImg());
            viewHolder.tv_other_user.setText(data.get(position).getName());
            viewHolder.tv_other_msg.setText(data.get(position).getMsg());
            viewHolder.tv_other_time.setText(data.get(position).getTime());
            // user관련 2개의 View를 감추자(GONE)
            viewHolder.tv_user_msg.setVisibility(View.GONE);
            viewHolder.tv_user_time.setVisibility(View.GONE);
        }




        return convertView;
    }

    public class ViewHolder {

        ImageView img;
        TextView tv_other_user;
        TextView tv_other_msg;
        TextView tv_other_time;

        TextView tv_user_msg;
        TextView tv_user_time;

        public ViewHolder(View view) {

            img = view.findViewById(R.id.img);
            tv_other_user = view.findViewById(R.id.tv_other_user);
            tv_other_msg = view.findViewById(R.id.tv_other_msg);
            tv_other_time = view.findViewById(R.id.tv_other_time);
            tv_user_msg = view.findViewById(R.id.tv_user_msg);
            tv_user_time = view.findViewById(R.id.tv_user_time);

        }

    }

}
