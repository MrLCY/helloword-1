package com.helloword.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.helloword.R;
import com.helloword.domain.QuestionLibType;
import com.helloword.gsonObject.RankTotal;
import com.helloword.service.GameService;
import com.helloword.service.NetworkService;
import com.helloword.util.UsersApplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class PVPRankTotalActivityUpdate extends Activity{
	
	private UsersApplication user;
	private int[] photo_resIds = {R.drawable.ic_photo1, R.drawable.ic_photo2,
			R.drawable.ic_photo3, R.drawable.ic_photo4,
			R.drawable.ic_photo5, R.drawable.ic_photo6,
			R.drawable.ic_photo7, R.drawable.ic_photo8,
			R.drawable.ic_photo9, R.drawable.ic_photo10};
	private String[] Level = {"first","second","third","four","five","six",
			"seven","eight","nine","ten"};
	
	private String rankStringName;
	private List<RankTotal> rankTotal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_pvp_rank_total_update);
		 user = (UsersApplication) getApplication();
		 
		 ListView gridView = (ListView) findViewById(R.id.pvp_rank_total_list);
	   
	   /*     List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 1; i++) {
				Map<String, Object> cell = new HashMap<String, Object>();
				cell.put("imageview", photo_resIds[i]);
				String rankString = user.getuserRank() +
						". " + "得分：" + user.getTotalScore();
				cell.put("title",rankString);
				list.add(cell);
			}
			SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankTotalActivityUpdate.this,
					(List<Map<String, Object>>)list, R.drawable.rankcell, new String[] { "imageview","title" },
					new int[] { R.id.ItemCell, R.id.ItemTitle});
			gridView.setAdapter(simpleAdapter);*/
			
		 rankStringName = user.getRankTotal().iterator().next().getuserNickname();
		 rankTotal = new ArrayList<RankTotal>();
		 rankTotal = user.getRankTotal();
 		 Iterator<RankTotal> iter = rankTotal.iterator();
 		 Log.d("Name",rankStringName);
 
		 
		 String rankString = "孙悟空";
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
/*			for (int i = 0; i < 10; i++) {
				Map<String, Object> cell = new HashMap<String, Object>();
				cell.put("rankId", i+1);				
				cell.put("rankName",rankString);
				cell.put("rankScore", 10000);
				list.add(cell);
			}*/
		 Map<String, Object> cellph = new HashMap<String, Object>();
			cellph.put("rankId", "排名");				
			cellph.put("rankName","昵称");
			cellph.put("rankScore","得分");
			list.add(cellph);		
		 int i=1;
		 RankTotal rank_iter = new RankTotal();
		 while(iter.hasNext()){
			 Map<String, Object> cell = new HashMap<String, Object>();
			 	rank_iter = iter.next();
				cell.put("rankId", i++);
				cell.put("rankName",rank_iter.getuserNickname());
				cell.put("rankScore", rank_iter.gettotalScore());
				list.add(cell);
		 }
		 
			SimpleAdapter simpleAdapter = new SimpleAdapter(PVPRankTotalActivityUpdate.this,
					(List<Map<String, Object>>)list, R.drawable.rankcell1, new String[] { "rankId","rankName","rankScore" },
					new int[] { R.id.RankId, R.id.RankName, R.id.RankScore});
			gridView.setAdapter(simpleAdapter);	
			
			
		}
}
