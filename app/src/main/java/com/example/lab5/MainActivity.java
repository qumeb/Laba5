package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.example.lab5.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private static final String CHANEL_ID = "ch1";
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MenuFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            int menuId = item.getItemId();
            if(menuId == R.id.menu){
                replaceFragment(new MenuFragment());

            } else if (menuId == R.id.question) {
                replaceFragment(new QuestionFragment());

            } else if (menuId == R.id.notification) {
                replaceFragment(new TextFragment());
                onclick_notification();
            }

            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
    public void onclick_notification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANEL_ID,
                    "channel_2",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManagerCompat = notificationManagerCompat.from(this);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(), CHANEL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Лаба №5")
                        .setContentText("Климов Кирилл Т-403901-ИСиТ")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat.notify(1, builder.build());
    }
}