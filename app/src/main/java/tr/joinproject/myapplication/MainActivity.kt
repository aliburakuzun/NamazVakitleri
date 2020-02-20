package tr.joinproject.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var navigation: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)
        navigation = findViewById(R.id.navigation)
        drawer = findViewById(R.id.drawer)
        frameLayout = findViewById(R.id.frameLayout)

        //saat için
        val today = Date()
        val formatter = SimpleDateFormat("HH:MM")
        clock.text = formatter.format(today)
        blink()


        toolbar.title = "Namaz Vakti"
        setSupportActionBar(toolbar)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, 0, 0)
        toggle.syncState()
        navigation.setNavigationItemSelectedListener(this)


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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_item_addLocation) {

            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout, FragmentLocation())
                .commit()

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}
