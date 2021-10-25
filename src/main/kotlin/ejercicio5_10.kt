class Libro(
    var idLibro: Int,
    var tituloLibro: String,
    var autorLibro: String,
    var numeroPaginasLibro: Int,
    calificacionLibro: Int) {

    var calificacionLibro: Int = comprobarPuntuacion(calificacionLibro)
    set(value){
        field = comprobarPuntuacion(value)
    }

    fun comprobarPuntuacion(puntuacion: Int): Int {
        return if (puntuacion in 0..10) {
            puntuacion
        } else {
            0
        }
    }

    fun infoLibro(): String = "Titulo: $tituloLibro \n Autor: $autorLibro \n Numero de Paginas: $numeroPaginasLibro \n Calificacion $calificacionLibro"

}

class ConjuntoLibros(){
    var conLibro = Array(5) { Libro(0,"", "", 0, 0) }
    var contador: Int = 0
    var posicionLibro: Int = 0
    var libroInsertado: Boolean = false

    fun añadirLibro(libroPorAñadir: Libro): String {
        contador = 0
        posicionLibro = 0
        libroInsertado = false
        while (!libroInsertado or(contador < 4)){
            if (conLibro[contador].idLibro.toInt() != 0){
                contador++
            } else {
                if (conLibro[contador].idLibro.toString() == libroPorAñadir.idLibro.toString()){
                    contador++
                } else {
                    conLibro[contador] == libroPorAñadir
                    libroInsertado = true
                    posicionLibro = contador
                    contador = 4
                }
            }
        }

        return if (libroInsertado) {
            "Libro Añadido en la posicion $posicionLibro"
        } else {
            "Libro no insertado"
        }
    }
}

fun main() {
    var libro1 = Libro(69420,"Guia profesional de caza", "Mimiar", 654, -2)
    var conju1 = ConjuntoLibros()

    println(libro1.infoLibro())
    println(conju1.añadirLibro(libro1))
    println(conju1.añadirLibro(libro1))
}