import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
class LoginActivity : AppCompatActivity() {
    private var usernameEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var errorMessageTextView: TextView? = null

    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.login_button)
        errorMessageTextView = findViewById(R.id.error_message)

        loginButton.setOnClickListener { login() }
    }

    private fun login() {
        val username = usernameEditText!!.text.toString()
        val password = passwordEditText!!.text.toString()

        if (username == VALID_USERNAME && password == VALID_PASSWORD) {
            val intent: Intent = Intent(
                this@LoginActivity,
                MainActivity::class.java
            )
            ContextCompat.startActivity(intent)
            finish() // Optional: close LoginActivity
        } else {
            errorMessageTextView!!.text = "Invalid credentials. Please try again."
            errorMessageTextView!!.visibility = View.VISIBLE
        }
    }

    companion object {
        private const val VALID_USERNAME = "admin"
        private const val VALID_PASSWORD = "password123"
    }
}