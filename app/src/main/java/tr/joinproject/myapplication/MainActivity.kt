package tr.joinproject.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.VISIBLE
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navigation: NavigationView = findViewById(R.id.navigation)
        val drawer: DrawerLayout = findViewById(R.id.drawer)


        //saat için
        val today = Date()
        val formatter = SimpleDateFormat("HH:MM")
        clock.text = formatter.format(today)
        blink()


        toolbar.title = "Namaz Vakti"
        setSupportActionBar(toolbar)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, 0, 0)
        toggle.syncState()


    }

    fun blink() {
        var hander = Handler()
        Thread(Runnable {

            run {
                try {
                    Thread.sleep(550)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                hander.post(Runnable {

                    run {
                        if (clock.visibility == VISIBLE) {
                            clock.visibility = View.INVISIBLE
                        } else {
                            clock.visibility = VISIBLE
                        }
                        blink()
                    }
                })
            }
        }).start()

    }
}
