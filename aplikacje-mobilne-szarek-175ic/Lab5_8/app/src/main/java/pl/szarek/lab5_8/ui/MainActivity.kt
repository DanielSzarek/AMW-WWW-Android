package pl.szarek.lab5_8.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.afollestad.assent.Permission
import com.afollestad.assent.askForPermissions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pl.szarek.lab5_8.R
import pl.szarek.lab5_8.service.NotificationService

class MainActivity : AppCompatActivity(), LocationListener {
    private lateinit var startButton: FloatingActionButton
    private lateinit var stopButton: FloatingActionButton
    private lateinit var actionButton: FloatingActionButton

    private lateinit var manager: LocationManager
    private var lastLocation: Location? = null
    private var distance: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        showMainFragment()
        findViews()
        setListeners()
    }

    private fun findViews() {
        startButton = findViewById(R.id.start_button)
        stopButton = findViewById(R.id.stop_button)
        actionButton = findViewById(R.id.action_button)
    }

    private fun setListeners() {
        startButton.setOnClickListener {
            getPermission()
        }

        stopButton.setOnClickListener {
            manager.removeUpdates(this)
        }

        actionButton.setOnClickListener {
            showText()
        }
    }

    fun showMainFragment() {
        val mainFragment = MainFragment.getInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mainFragment)
            .commit()
    }

    private fun showText() {
        val intent = Intent(this, NotificationService::class.java)
        intent.putExtra(NotificationService.TEXT_KEY, "Tekst z IntentService")
        startService(intent)
    }

    private fun getPermission() {
        val permission = Permission.ACCESS_FINE_LOCATION
        askForPermissions(permission) {
            if (permission in it.granted()) {
                requestLocation()
            }
        }
    }

    private fun requestLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 0F, this)
    }

    override fun onLocationChanged(location: Location?) {
        Log.i("lab_android", "Location: $location")
        if (lastLocation != null && location != null) {
            distance += location.distanceTo(lastLocation)
            Log.i("lab_android", "Distance: $distance")
        }

        lastLocation = location
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        Log.i("lab_android", "Status changed: $status")
    }

    override fun onProviderDisabled(provider: String?) {
        Log.i("lab_android", "Provider disabled")
    }

    override fun onProviderEnabled(provider: String?) {
        Log.i("lab_android", "Provider enabled")
    }
}
