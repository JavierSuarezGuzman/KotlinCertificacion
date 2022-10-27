/* Javier Suárez Guzmán
    Octubre */

package cl.javiersg.cursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

val TAG2 = ":::TAG"

class MainActivityEmpezando : AppCompatActivity() {

    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        var nombre = "Kotlin"

        var name: String
        name = "Javier"
        */

        //variblesYConstantes()
        //tiposDeDatos()
        //operadores()
        //nullSafety()
        //funciones()
        //clases()
        //interfaces()
        //funcionProgramador() //reto
    }

    private fun funcionProgramador() {
        /*val programador1Data = ProgrammerData("Javier Suárez Guzmán", 34, "Kotlin")
        val programador2Data = ProgrammerData("Programador Dos", 24, "JavaScript")
        val programador3Data = ProgrammerData("Programador Tres", 28, "Java")
        val programador4Data = ProgrammerData("Programador Cuatro", 42, "C#")

        //val JS = Programador(programador1Data)*/
        val programador = Programador()
        val jsg = programador.getProgrammerData()
        Log.d(TAG, "Programador1: ${jsg.name}, edad: ${jsg.age}, lenguaje de programación: ${jsg.language}")
    }
    class Programador: ProgramadorInterface {
        /*private fun nombre(){}
        private fun edad() {}
        private fun lenguajeProg(){}*/ //x
        override fun getProgrammerData(): ProgrammerData = ProgrammerData(getName(), getAge(), getLanguage())
        private fun getName(): String {
            return "Javier Suárez Guzmán"
        }
        private fun getAge(): Int {
            return 2022 - 1988
        }
        private fun getLanguage(): String = "Kotlin" //otra forma de retornar data
    }
    interface ProgramadorInterface {
        //fun getProgrammerData(programmerData: ProgrammerData) //x
        fun getProgrammerData(): ProgrammerData
    }
    data class ProgrammerData(
        val name: String,
        val age: Int,
        val language: String
    )

    private fun interfaces() { // "clase abstracta, no tiene contenido, no tiene valor" https://openwebinars.net/academia/aprende/kotlin-para-android/8847/
        val nombreData = PersonData("Nombre", 111)
        val nombre = SecondPerson(nombreData)
        //nombre.presentacion() //:::TAG: Mi nombre es Nombre y mi edad es 111
        val edad = nombre.returnAge(1897)
        Log.d(TAG,"Tengo ${edad} años") //:::TAG: Tengo 125 años
    }
    class SecondPerson(val data: PersonData): PersonInterface{ // "ahora mismo esta clase está extendiendo de la interfaz PersonInterface
        fun presentacion() {
            Log.d(TAG, "Mi nombre es ${data.nombre} y mi edad es ${data.edad}")
        }
        override fun returnAge(annoNacimiento: Int): Int = 2022 - annoNacimiento

    }
    interface PersonInterface {
        fun returnAge(annoNacimiento: Int): Int
    }

    private fun clases() {
        //Persona() //Llamar a una clase vecía no tiene ni una utilidad
        //val javier = Persona()
        //javier.presentacion()
        //val alejandro = Persona("Alejandro", 34)
        //val kotlin = Persona("Kotlin", 24)
        //alejandro.presentación()
        //kotlin.presentación()

        val kotlinData = PersonData("Kotlin", 42)
        val kotlinDeData = Person(kotlinData)
        kotlinDeData.presentacion()
        val nullNombre = PersonData(null, 33)
        val nulo = Person(nullNombre)
        nulo.presentacion()
    }

    class Persona(val nombre: String, val edad: Int){ //Si tenemos 10 funciones es mejor parametrizar la clase
        fun presentación(){
            Log.d(TAG, "Me llamo ${nombre} y tengo ${edad}")
        }
    }
    class Person(val data: PersonData){
        fun presentacion() {
            Log.d(TAG, "Mi nombre es ${data.nombre} y mi edad es ${data.edad}")
        }
    }
    data class PersonData(//otro tipo de clase que sirve para guardar datos
            val nombre: String?,
            val edad: Int
    )

    private fun funciones() {
        //printNameAge()
        //funcionParametros("Kotlin", 36)
        //funcionParametros("Panchito", 3)
        val calculaEdad = funcionRetorno(1988)
        Log.d(TAG, "Mi edad es ${calculaEdad}")
    }

    private fun printNameAge() {
        Log.d(TAG, "Kotlin")
        Log.d(TAG, 35.toString())
    }

    private fun funcionParametros(nombre: String, edad: Int) {
        Log.d(TAG, "Me llamo ${nombre}")
        Log.d(TAG, "Mi edad es ${edad}")
    }

    private fun funcionRetorno(annoNacimiento: Int) : Int {
        return 2022 - annoNacimiento

        /* diferentes formas
        val edad = 2022 - annoNacimiento
        return edad
    private fun funcionRetorno(annoNacimiento: Int): Int = 2022 - annoNacimiento*/


    }

    private fun nullSafety() {
        val nullString: String? = null

        Log.d(TAG, "Así sale el string ${nullString} 2")

    }

    private fun operadores() {
        val primerValor = 55
        val segundoValor = 22
        val tercerValor = 22

        var suma = primerValor+segundoValor
        var resta = primerValor-segundoValor
        var mult = primerValor*segundoValor
        var divi = primerValor/segundoValor
        var modulus = primerValor%segundoValor
        Log.d(TAG, "Resultado de la suma $suma")
        Log.d(TAG, "Resultado de la resta $resta")
        Log.d(TAG, "Resultado de la multiplicación $mult")
        Log.d(TAG, "Resultado de la división $divi")
        Log.d(TAG, "Resultado % $modulus")

        val igualdad1 = primerValor != segundoValor
        val igualdad2 = segundoValor == tercerValor
        val menor = segundoValor < tercerValor
        val mayor = segundoValor >= tercerValor
        Log.d(TAG, "Es $primerValor distinto que $segundoValor? $igualdad1")
        Log.d(TAG, "Es $segundoValor igual que $tercerValor? $igualdad2")
        Log.d(TAG, "Es $segundoValor menor que $primerValor? $menor")
        Log.d(TAG, "Es $tercerValor mayor o igual que $tercerValor? $mayor")

        // Operadores Lógicos
        var edad = 34
        var nombre = "Kotlin"
        val igualdad3 = nombre == "Kotlin"
        val menorQue = edad < 18

        val conjuncion = igualdad3 && menorQue //y
        val disyuncion = igualdad3 || menorQue //o
        val negacion = !igualdad3
        Log.d(TAG, "El resultado de la conjunción es $conjuncion") //y
        Log.d(TAG, "El resultado de la disyunción es $disyuncion") //o
        Log.d(TAG, "El resultado de la disyunción es $negacion")


    }

    private fun tiposDeDatos() {
        var string = "String de choro"
        //int short long byte
        var numero = 10
        //numero = string //fallo por imcompatibilidad de tipo

        //double float
        var decimal = 10.5
        var float = 10.5f
        //numero = decimal //fallo por imcompatibilidad de tipo

        //boolean
        var bool = true
        var bool2 = false

        Log.d(TAG, "Mi float es ${decimal}\n Mi numero es ${numero}")
    }

    private fun variblesYConstantes(){

        var primeraVariable = "¡Hola Mundo!"
        var segundaVariable = "PHI: 1.618033"

        Log.d(TAG, primeraVariable)
        Log.d(TAG, segundaVariable)
    }

}