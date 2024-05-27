package com.mustaqim.homework

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.mustaqim.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        }

    fun mgSnack (view: View) {
        Snackbar.make(
            findViewById(R.id.sendMessage),
            "Your Email has been sent successfully", Snackbar.LENGTH_LONG).setAction("OK"){}.setActionTextColor(
            Color.RED).show()
    }

    fun save(view: View) {
        val saveAlert = AlertDialog.Builder(this)
        saveAlert.setTitle("Save")
        saveAlert.setMessage("Are you sure you want to save your changes?")
        saveAlert.setPositiveButton("Yes")
        { dialogInterface: DialogInterface,_:Int -> Snackbar.make(findViewById(R.id.button),
            "Saved",Snackbar.LENGTH_LONG).show()}
        saveAlert.show()
    }

    fun courseupdate(view: View) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel_id = "channel_01"
            val channel_Name = "notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(channel_id,channel_Name,importance)
            mChannel.description = "test description"
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)

            val notification: Notification = Notification.Builder(this,channel_id)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Android ATC Notification")
                .setContentText("Check ANdroid ATC New Course !!")
                .build()

            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE)
                    as NotificationManager

            if (mNotificationManager!=null) {
                mNotificationManager.createNotificationChannel(mChannel)

                mNotificationManager.notify(1,notification)

            }
        }
    }


}