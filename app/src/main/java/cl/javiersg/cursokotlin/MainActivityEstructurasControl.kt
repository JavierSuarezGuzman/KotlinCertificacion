/* Javier Suárez Guzmán
    Octubre */

package cl.javiersg.cursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

val TAG3 = ":::TAG"

class MainActivityEstructurasControl : AppCompatActivity() {

    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //condicionalesIf()
        //condicionalesWhen() //switchcase
        //listados()
        //bucleFor()
        //bucleWhile()
        //bucleDoWhile()
        //controlDeErrores() //en ejecución
    }

    private fun controlDeErrores() { //errores en tiempo de ejecución
        val myArrayList = arrayListOf(1,2,3,4,5,6,7)
        val myString: String? = null

        try {
            for (position in 0..myArrayList.size){
                Log.d(TAG, myString!!) //esto dijimos que nunca lo íbamos a hacer
            }
        }catch (exception: NullPointerException){
            //(exception: IndexOutOfBoundsException) este no es el error que nos da por lo que bota la app
            exception.printStackTrace()
        }finally {
            //cuando usamos bbdd es comun cerrarla acá para que no quede consumiendo recursos
        }

        /*try { //gracias al trycatch la app no se cae como abajo
            for(position in 0..myArrayList.size){
                Log.d(TAG, myArrayList[position].toString())
            }
        }catch (exception: IndexOutOfBoundsException){ //(exception: Exception) es genérico
            exception.printStackTrace() //java.lang.IndexOutOfBoundsException: Index: 7, Size: 7
        }*/

        /*for(position in 0..myArrayList.size){
            Log.d(TAG, myArrayList[position].toString())
            //Esto entrega error:   Caused by: java.lang.IndexOutOfBoundsException: Index: 7, Size: 7
            //y bota la app
        }*/
    }

    private fun bucleDoWhile() {
        var myNumber2 = 20

        do {
            Log.d(TAG, "Entrando en el bucle do")
            myNumber2++
        } while (myNumber2 <= 10)
    }

    private fun bucleWhile() {
        var myNumber = 10

        while (myNumber <= 20){//evitar hacer whiles dentro de whiles ya que consumen mucha memoria
            Log.d(TAG, myNumber.toString())
            myNumber += 2
        }
    }

    private fun bucleFor() {
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "David", "Lurena", "Alison")
        for(nombre in myArrayList) {
            Log.d(TAG, "$nombre Rodriguez, son todos familia")
        }
        for (position in 0..10){
            Log.d(TAG, position.toString())
        }
        for (position in 0 until 5){ //instructor: "la forma anterior se llama forEach en Java"
            Log.d(TAG, position.toString())
        }
        for (position in 0..15 step 3){
            Log.d(TAG, position.toString())
        }
        for (position in 10 downTo 0 step 2){
            Log.d(TAG, position.toString())
        }
    }

    private fun listados() {
        val list1 = listOf<String>()
        val list2: List<String> = listOf()

        val arrayList1 = arrayListOf<String>()
        val arrayList2: ArrayList<String> = arrayListOf()

        val miLista = listOf<String>("Nombre", "nombre2", "nombre3") //podríamos borrar el <String> ya que el lenguaje sabe que son cadenas de texto
        val miArray = arrayListOf("Nombre", "nombre2", "nombre3", "nombre4") //aquí no está el <String>

        val listItem = miLista[0]
        Log.d(TAG, listItem)//:::TAG: Nombre

        //editar
        //list1[2] = "Javier" //esto da error porque aquí las lists NO son editables
        arrayList2[0] = "Javier" //esto se puede hacer porque aquí los array SON editables

        //borrar
        arrayList1.remove("nombre2")
        arrayList1.removeAt(4)
        miArray.clear()
        miArray.addAll(miLista)
        miArray.sortDescending()
        //miArray.
    }

    private fun condicionalesWhen() { //switchcase
        /*val language = "VB"

        when (language) {
            "Kotlin" -> Log.d(TAG, "Lenguaje Seleccionado: Kotlin")
            "Java" -> Log.d(TAG, "Lenguaje Seleccionado: Java")
            "C#", "F#", "VB" -> Log.d(TAG, "Lenguaje Seleccionado: .Net")
            else -> Log.d(TAG, "No es un lenguaje soportado")
        }*/
        val myNumber = 102

        when (myNumber) {
            0 -> Log.d(TAG, "Número 0")
            in 101..102 -> Log.d(TAG, "Lo mismo de abajo")
            100,101,102 -> Log.d(TAG, "Lo mismo de arriba") //detecta el primero y corta el when ahí
            42 -> Log.d(TAG, "Número 42")
            else -> Log.d(TAG, "No es un número soportado")
        }
    }

    private fun condicionalesIf() {
        val primerNumero = 11
        val segundoNumero = 6
        val valorBoleano = true

        if (primerNumero > segundoNumero){
            Log.d(TAG, "Correcto")
            if(segundoNumero == 6){
                "6 es igual a 6"
            }
        }else if (valorBoleano){
            Log.d(TAG, "Incorrecto")
        }else{
            Log.d(TAG, "Tercera opción")
        }

        val edad: Int = if (!valorBoleano){
            17
        }else {
            26
        }
        Log.d(TAG, edad.toString())
    }

}