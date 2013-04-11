package com.paperairplane.music.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.paperairplane.music.share.R;

public class MusicListAdapter extends BaseAdapter {
	private Context mcontext;
	private MusicData musicdata[];

	public MusicListAdapter(Context context, MusicData _musicdata[]) {
		mcontext = context;
		musicdata = _musicdata;// ��ҪCursor�ˡ���
	}

	public int getCount() {
		if (musicdata != null) {
			return musicdata.length;
		}
		return 0;
	}

	public Object getItem(int position) {
		return musicdata[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mcontext).inflate(
				R.layout.musiclist_item, null);
		TextView music_title = (TextView) convertView
				.findViewById(R.id.musicname);
		TextView music_singer = (TextView) convertView
				.findViewById(R.id.singer);
		music_title.setText(musicdata[position].getTitle() + Consts.VERY_LONG); // +"("+musicdata[position].getDuration()+")"+VERY_LONG);
		music_singer.setText(musicdata[position].getArtist());
		return convertView;
	}

}