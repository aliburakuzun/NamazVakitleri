package tr.joinproject.myapplication

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navigation: NavigationView = findViewById(R.id.navigation)
        val drawer: DrawerLayout = findViewById(R.id.drawer)
        toolbar.title = "Namaz Vakti"
        setSupportActionBar(toolbar)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, 0, 0)
        toggle.syncState()




    }
}
