class Libro(
    var tituloLibro: String,
    var autorLibro: String,
    var numeroPaginas: Int,
    var calificacionLibro: Int
) {

    init {
        require(numeroPaginas > 0) { "El numero de paginas es negativo" }
        require(calificacionLibro in 0..10) { "La calificicacion no entra dentro de los limites establecidos" }
    }

    fun informacionLibro(): String =
        "Titulo: $tituloLibro, Autor/a: $autorLibro, Numero de paginas: $numeroPaginas, Calificacion del Libro: $calificacionLibro"
}

class ConjuntoLibros() {
    var librosContenidos: Array<Libro?> = kotlin.arrayOfNulls<Libro>(5)
    var contador: Int = 0
    var libroAñadido: Boolean = false

    fun insertarLibro(libroPorAñadir: Libro): String{
        contador = 0
        libroAñadido = false
        while(contador < 4){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.tituloLibro.toString() == libroPorAñadir.tituloLibro.toString()) {
                    contador = 4
                } else {
                    contador++
                }
            } else {
                librosContenidos[contador] = libroPorAñadir
                libroAñadido = true
                contador = 4
            }
        }

        return if (libroAñadido) {
            "Libro Añadido"
        } else {
            "Libro no Añadido"
        }
    }

    fun imprimirLibros(){
        contador = 0
        while (librosContenidos[contador] != null){
            println("${librosContenidos[contador]?.tituloLibro}, ${librosContenidos[contador]?.autorLibro}")
            contador++
        }
    }

}

fun main() {
    var libro1 = Libro(
        "Geronimo Stilton: Viaje al Reino de la Fantasia",
        "Elisabetta Dami",
        352,
        10
    )
    var libro2 = Libro(
        "El Señor de los Anillos: La comunidad del Anillo",
        "J.R.R Tolkien",
        412,
        9
    )

    var coleccionLibros = ConjuntoLibros()

    println(libro1.informacionLibro())
    println(libro2.informacionLibro())
    println("")
    println(coleccionLibros.insertarLibro(libro1))
    println(coleccionLibros.insertarLibro(libro1))
    println(coleccionLibros.insertarLibro(libro2))
    println("")

    coleccionLibros.imprimirLibros()

}

