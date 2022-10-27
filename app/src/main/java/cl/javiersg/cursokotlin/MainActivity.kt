/* Javier Suárez Guzmán
    Octubre */

package cl.javiersg.cursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

val TAG = ":::TAG"

class MainActivity : AppCompatActivity() {

    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //botDeSeguridad() //reto Pasado al primer intento :)
        botDeSeguridadRodrigo()
    }

    private fun botDeSeguridadRodrigo() {
        val persona = Persona( "Rodrigo", 26, arrayListOf("Programar", "TV", "Deportes"))

        if (persona.name == "Rodrigo"){
            Log.d(TAG, "Bienvenido ${persona.name}")

            when(persona.age){
                in 0..17 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres muy joven para acceder.")
                }
                in 18..64 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, bienvenido.")

                    for (hobbie in persona.hobbies){
                        Log.d(TAG, "Tus hobbies son ${hobbie}")
                    }
                }
                else -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres muy viejo para acceder.")
                }
            }
        }else{
            Log.d(TAG, "¡Largo de aquí ${persona.name}!")
        }
    }

    private fun botDeSeguridad(){
        val javier = Persona(
            "Javier",
            34,
            arrayListOf("Programar", "Estudiar", "Jugar", "Senderismo")
        )
        /*public constructor Persona(
        val name: String,
        val age: Int,
        val hobbies: ArrayList<String> = arrayListOf())*/

        if (javier.name != "Javier"){
            Log.d(TAG, "Lo siento tu nombre no es el correcto")
        }else{
            Log.d(TAG, "Felicitaciones ${javier.name}, puedes ingresar")
            if (javier.age > 0 && javier.age < 18){
                Log.d(TAG, "Lo siento, eres menor de edad no puedes acceder")
            }else if (javier.age >= 65 && javier.age <= 100){
                Log.d(TAG, "Lo siento, eres un viejito y no puedes acceder")
            } else {
                Log.d(TAG, "Felicitaciones ${javier.name}, tienes ${javier.age}" +
                        " años por lo que puedes acceder ")
                for (hobbie in javier.hobbies){
                    Log.d(TAG, hobbie)
                }
            }
        }
    }

    data class Persona(
        val name: String,
        val age: Int,
        val hobbies: ArrayList<String> = arrayListOf() //val hobbies: ArrayList<String> //profe

    )

}