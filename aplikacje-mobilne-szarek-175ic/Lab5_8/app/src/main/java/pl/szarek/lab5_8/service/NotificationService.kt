package pl.szarek.lab5_8.service

import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import pl.szarek.lab5_8.R

class NotificationService : IntentService(SERVICE_NAME) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onHandleIntent(intent: Intent?) {
        val text = intent?.getStringExtra(TEXT_KEY)
        Log.i(SERVICE_NAME, text ?: SERVICE_NAME)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = Notification.Builder(this)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "channel", NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)
        manager.notify(1, notification)
    }

    companion object {
        const val TEXT_KEY: String = "time_value"
        const val SERVICE_NAME: String = "notification_service"
        const val NOTIFICATION_CHANNEL_ID: String = "notification_channel_id"
    }
}