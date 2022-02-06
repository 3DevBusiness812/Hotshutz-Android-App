package com.alpha.posapp;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alpha.posapp.cart_pkg.AddToCart_Activity;
import com.alpha.posapp.cat_pkg.CategoryFragment;
import com.alpha.posapp.chat_pkg.Chat_Activity;
import com.alpha.posapp.home_pkg.HomeFragment;
import com.alpha.posapp.myorder_pkg.MyOrderFragment;
import com.alpha.posapp.notification_pkg.Notification_Activity;
import com.alpha.posapp.payment_history_pkg.Payment_History_Activity;
import com.alpha.posapp.profile_pkg.EditProfile_Activity;
import com.alpha.posapp.profile_pkg.ProfileFragment;
import com.apradanas.prismoji.PrismojiManager;
import com.apradanas.prismoji.one.PrismojiOneProvider;
import com.google.android.material.navigation.NavigationView;


import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "HomeActivity";
    private RelativeLayout rlHomeId, rlHomeofferdId, rlHomeSearchId, rlHomeAccountId, rlNotification, rlCartBackHome, rlCartHomeId;
    private AppCompatImageView ivNotificationHome,ivHomeId, ivOfferId, ivSearchId, ivAccountId;
    private AppCompatTextView title,tvHomeId, tvOfferId, tvsearchId, tvAccountid, ivCartHomeId, tvusername, tvuseremail, ivCartHome;
    private String as, username, useremail, userImage, userid, payment_id;
    private CircleImageView ivNavId;
    private AppCompatTextView useremail_, username_;
    String location_city;
    String token, loggedIn;
    LinearLayout nav_box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PrismojiManager.install(new PrismojiOneProvider());

//        AddCartCustomModel.getInstance().setListener(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        apiServices = RetrofitClient.getClient().create(ApiServices.class);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.gray_clr));
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer_menu);//your icon here

        init();

        title.setText("Categories");
        loadFragment(new CategoryFragment());

//        as = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        googleSignInClient = GoogleSignIn.getClient(this, gso);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.getMenu().getItem(0).setChecked(true);

//        useremail_ = navigationView.getHeaderView(0).findViewById(R.id.useremail);
//        username_ = navigationView.getHeaderView(0).findViewById(R.id.username);
//        ivNavId = navigationView.getHeaderView(0).findViewById(R.id.ivNavId);

      nav_box = navigationView.getHeaderView(0).findViewById(R.id.nav_box);
        nav_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
                startActivity(new Intent(HomeActivity.this, EditProfile_Activity.class));
            }
        });

//        loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//        if (loggedIn == null) {
//            Menu navigationMenu = navigationView.getMenu();
//            MenuItem menuItem = navigationMenu.getItem(10);
//            menuItem.setTitle("Login");
//        } else {
//        }
//
//        useremail_.setText(useremail);
//        username_.setText(username);


//        if (TextUtils.isEmpty(userImage)) {
//
//        } else {
//            Picasso.with(getApplicationContext())
//                    .load(RetrofitClient.PROFILE + userImage)
//                    .into(ivNavId);
//        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    title.setText("Home");
                    loadFragment(new HomeFragment());
                }

                else if (id == R.id.nav_notification) {
//                    loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//                    if (loggedIn == null) {
                        Intent intent = new Intent(HomeActivity.this, Notification_Activity.class);
                        startActivity(intent);
//                    } else {
//                    Intent intent = new Intent(HomeActivity.this, WishlistActivity.class);
//                    startActivity(intent);
                }

//                } else if (id == R.id.nav_product) {
//                    Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
//                    startActivity(intent);
//                }
//
                else if (id == R.id.nav_paymenthistory) {
//                    loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//                    if (loggedIn == null) {
                        Intent intent = new Intent(HomeActivity.this, Payment_History_Activity.class);
                        startActivity(intent);
//                    } else {
//                        Intent intent = new Intent(HomeActivity.this, MyOrderActivity.class);
//                        startActivity(intent);
                }


                else if (id == R.id.nav_myinbox) {
                    Intent intent = new Intent(HomeActivity.this, Chat_Activity.class);
                    startActivity(intent);
                }


//                else if (id == R.id.nav_aboutus) {
//                    Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
//                    startActivity(intent);
//                } else if (id == R.id.nav_contact) {
//                    loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//                    if (loggedIn == null) {
//                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                    } else {
//                        Intent intent = new Intent(HomeActivity.this, ContactActivity.class);
//                        startActivity(intent);
//                    }
//                } else if (id == R.id.nav_forgot_password) {
//                    loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//                    if (loggedIn == null) {
//                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                    } else {
//                        Intent intent = new Intent(HomeActivity.this, ChangePasswordActivity.class);
//                        startActivity(intent);
//                    }
//                } else if (id == R.id.nav_logout) {
//                    loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//                    if (loggedIn == null) {
//                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                    } else {
//                        log_out();
//                    }
//                } else if (id == R.id.nav_termsandConditons) {
//                    Intent intent = new Intent(HomeActivity.this, TermsAndConditionsActivity.class);
//                    startActivity(intent);
//                }
//
                else if (id == R.id.nav_logout) {
                    onBackPressed();
//                    try {
//                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                        shareIntent.setType("text/plain");
//                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Grosirie");
//                        String shareMessage = "\nLet me recommend you this application\n\n";
//                        shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
//                        startActivity(Intent.createChooser(shareIntent, "choose one"));
//                    } catch (Exception e) {
//                        //e.toString();
//                    }
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    private void init() {
        rlCartHomeId = findViewById(R.id.rlCartHomeId);
        rlCartBackHome = findViewById(R.id.rlCartBackHomeId);
        ivCartHomeId = findViewById(R.id.ivCartHomeId);
        rlNotification = findViewById(R.id.rlNotificationId);
        ivNotificationHome = findViewById(R.id.ivNotificationHomeId);
        rlHomeId = findViewById(R.id.rlHomeId);
        ivHomeId = findViewById(R.id.ivHomeId);
        tvHomeId = findViewById(R.id.tvHomeId);
        rlHomeofferdId = findViewById(R.id.rlHomeofferdId);
        ivOfferId = findViewById(R.id.ivOfferId);
        tvOfferId = findViewById(R.id.tvOfferId);
        rlHomeSearchId = findViewById(R.id.rlHomeSearchId);
        ivSearchId = findViewById(R.id.ivSearchId);
        tvsearchId = findViewById(R.id.tvsearchId);
        rlHomeAccountId = findViewById(R.id.rlHomeAccountId);
        ivAccountId = findViewById(R.id.ivAccountId);
        tvAccountid = findViewById(R.id.tvAccountid);
        ivCartHomeId = findViewById(R.id.ivCartHomeId);
        tvuseremail = findViewById(R.id.useremail);
        tvusername = findViewById(R.id.username);
        title = findViewById(R.id.title);

        rlHomeofferdId.setOnClickListener(this);
        rlHomeId.setOnClickListener(this);
        rlHomeSearchId.setOnClickListener(this);
        rlCartHomeId.setOnClickListener(this);
        rlHomeAccountId.setOnClickListener(this);
        ivCartHomeId.setOnClickListener(this);
        rlNotification.setOnClickListener(this);

//        username = AppSession.getStringPreferences(HomeActivity.this, Constants.USERNAME);
//        useremail = AppSession.getStringPreferences(HomeActivity.this, Constants.USEREMAIL);
//        userid = AppSession.getStringPreferences(HomeActivity.this, Constants.USEREId);
//        userImage = AppSession.getStringPreferences(HomeActivity.this, Constants.USERIMAGE);

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        androidx.appcompat.app.AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlNotificationId:
                Intent intent = new Intent(HomeActivity.this, Notification_Activity.class);
                startActivity(intent);
                break;

            case R.id.rlHomeId:
                title.setText("Categories");
                loadFragment(new CategoryFragment());
                break;
            case R.id.rlHomeofferdId:
                title.setText("Home");
                loadFragment(new HomeFragment());
                break;
            case R.id.rlHomeSearchId:
                title.setText("My Orders");
                loadFragment(new MyOrderFragment());
//                search();
                break;
            case R.id.rlHomeAccountId:
                title.setText("My Profile");
                loadFragment(new ProfileFragment());
//                loggedIn = AppSession.getStringPreferences(HomeActivity.this, Constants.LOGIN);
//                if (loggedIn == null) {
//                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                } else {
//                    account();
//                }
                break;
            case R.id.rlCartHomeId:
                Intent intent11 = new Intent(HomeActivity.this, AddToCart_Activity.class);
                startActivity(intent11);
                break;
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }

        return false;
    }


    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.addToBackStack(null);
        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_right);
        ft.replace(R.id.nav_host_fragment, fragment, tag);
        ft.commitAllowingStateLoss();
    }


   /* @Override
    public void passData(String data) {
        ivCartHomeId.setText(data);
    }*/

}


