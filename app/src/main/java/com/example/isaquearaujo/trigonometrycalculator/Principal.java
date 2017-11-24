package com.example.isaquearaujo.trigonometrycalculator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class Principal extends FragmentActivity implements View.OnClickListener, Runnable {
    public static ViewPager viewpagerprincipal;
    private ListView mDrawerList;
    private RelativeLayout mDrawerPane;
    private DrawerLayout mDrawerLayout;
    DrawerListAdapter adapterdrawer;
    boolean gambiarra = true;
    int clickopenmenu = 0;
    Button openmenu;
    TextView titleView;
    Typeface typeface;
    Typeface typeface2;
    TextView teste;
    TextView tv;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        openmenu = (Button) findViewById(R.id.openmenu);
        ImageView loadingImageView = (ImageView)findViewById(R.id.logo);
        //Glide.with(this).load(R.drawable.logogif).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(loadingImageView);

        openmenu.setOnClickListener(this);
        mNavItems.add(new NavItem("Triangulo Retangulo", R.drawable.iconelivrosp));
        mNavItems.add(new NavItem("Lei dos Senos", R.drawable.iconelivrosp));
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerList.setDivider(null);
        adapterdrawer = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapterdrawer);
        typeface = Typeface.createFromAsset(getAssets(), "OpenSans-Semibold.ttf");
        typeface2 = Typeface.createFromAsset(getAssets(), "OpenSans-ExtraBold.ttf");
        viewpagerprincipal = (ViewPager)findViewById(R.id.viewpagerprincipal);
        viewpagerprincipal.setAdapter(new NavigatePrincipal(getSupportFragmentManager()));
        viewpagerprincipal.setOffscreenPageLimit(2);
        viewpagerprincipal.setCurrentItem(0);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //aqui tem que mecher de novo


                if(teste != null)
                {
                    teste.setTextColor(Color.parseColor("#79a2b8"));
                    teste.setTypeface(typeface);
                }

                tv = (TextView) view.findViewById(R.id.title);
                teste = tv;
                tv.setTypeface(typeface2);
                tv.setTextColor(Color.parseColor("#0c4a66"));
                adapterdrawer.notifyDataSetChanged();
                for (int i = 0; i < mDrawerList.getChildCount(); i++) {
                    if (position == i) {
                        mDrawerList.getChildAt(i).setBackgroundColor(Color.parseColor("#DCDCDC"));
                    } else {
                        mNavItems.get(0).mIcon = R.drawable.iconelivrosp;
                        mNavItems.get(1).mIcon = R.drawable.iconelivrosp;

                        mDrawerList.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                if (position == 0) {
                    ViewPager viewPager2 = (ViewPager)findViewById(R.id.viewpagerprincipal);
                    viewPager2.setCurrentItem(0, false);
                    //number = 0;
                    gambiarra = true;
                    mNavItems.get(0).mIcon = R.drawable.iconelivrosp;
                } else if (position == 1) {
                    ViewPager viewPager2 = (ViewPager)findViewById(R.id.viewpagerprincipal);
                    viewPager2.setCurrentItem(1, false);
                    gambiarra = false;
                    mNavItems.get(1).mIcon = R.drawable.iconelivrosp;
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                // adapterdrawer.notifyDataSetChanged();
            }
        });
        run();

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.openmenu) {
            clickopenmenu += 1;
            if (clickopenmenu == 1) {
                mDrawerLayout.openDrawer(mDrawerPane);
            } else if (clickopenmenu == 2) {
                mDrawerLayout.closeDrawer(mDrawerPane);
                clickopenmenu = 0;
            }
        }
    }

    class NavItem {
        String mTitle;
        int mIcon;

        public NavItem(String title, int icon) {
            mTitle = title;
            mIcon = icon;
        }
    }

    class DrawerListAdapter extends BaseAdapter {
        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.drawer_item, null);
            } else {
                view = convertView;
            }
            titleView = (TextView) view.findViewById(R.id.title);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);
            //titleView.setTypeface(typeface);
            if(gambiarra == true)
            {
                titleView.setTypeface(typeface);
                if (position == 0) {
                    view.setBackgroundColor(Color.parseColor("#DCDCDC"));
                    titleView.setTextColor(Color.parseColor("#0c4a66"));
                    titleView.setTypeface(typeface2);
                }

            }
            else if(gambiarra == false)
            {
                if (position == 0) {
                    view.setBackgroundColor(Color.TRANSPARENT);
                    titleView.setTextColor(Color.parseColor("#79a2b8"));
                    titleView.setTypeface(typeface);
                }


            }

            titleView.setText(mNavItems.get(position).mTitle);
            iconView.setImageResource(mNavItems.get(position).mIcon);
            titleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((ListView) parent).performItemClick(v, position, 0);
                }
            });
            return view;
        }
    }

    @Override
    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (mDrawerLayout.isDrawerOpen(mDrawerPane)) {
                        clickopenmenu = 1;
                    } else {
                        clickopenmenu = 0;
                    }
                }
            }
        }).start();
    }
}
