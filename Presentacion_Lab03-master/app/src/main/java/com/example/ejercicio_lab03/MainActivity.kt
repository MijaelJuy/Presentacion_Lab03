package com.example.ejercicio_lab03

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establecer el LinearLayout principal como la vista de contenido
        setContentView(createMainLinearLayout(this))
    }

    // Función para crear el LinearLayout principal
    private fun createMainLinearLayout(context: Context): LinearLayout {
        return LinearLayout(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#D3E6D1"))
            gravity = Gravity.CENTER_HORIZONTAL

            // Agregar vistas al LinearLayout principal
            addView(createTextView(context, "Cesar Nuñez", 32f, Color.BLACK, Gravity.CENTER))
            addView(createTextView(context, "Android Developer Extraordinaire", 18f, Color.parseColor("#388E3C"), Gravity.CENTER))
            addView(createContactLayout(context).apply {
                addView(createContactRow(context, "937587072"))
                addView(createContactRow(context, "@AndroidDev"))
                addView(createContactRow(context, "cesar.nunez@tecsup.edu.pe"))
            })
        }
    }

    // Función para crear un TextView
    private fun createTextView(context: Context, text: String, textSize: Float, textColor: Int, gravity: Int): TextView {
        return TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 8)
                this.gravity = gravity
            }
            this.text = text
            this.textSize = textSize
            setTextColor(textColor)
        }
    }

    // Función para crear un LinearLayout para los contactos
    private fun createContactLayout(context: Context): LinearLayout {
        return LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 32, 0, 0)
            }
            orientation = LinearLayout.VERTICAL
        }
    }

    // Función para crear una fila de contacto con solo texto
    private fun createContactRow(context: Context, text: String): LinearLayout {
        return LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 16, 0, 0)
            }
            orientation = LinearLayout.HORIZONTAL

            addView(TextView(context).apply {
                textSize = 18f
                setTextColor(Color.BLACK)
                this.text = text
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(16, 0, 0, 0)
                }
            })
        }
    }
}

