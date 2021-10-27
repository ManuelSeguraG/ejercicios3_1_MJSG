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
    var posicion: Int = 0
    var libroAñadido: Boolean = false
    var libroEliminado: Boolean = false
    var cantidadLibrosEliminados: Int = 0

    fun insertarLibro(libroPorAñadir: Libro): String{
        contador = 0
        posicion = 0
        libroAñadido = false
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.tituloLibro.toString() == libroPorAñadir.tituloLibro.toString()) {
                    contador = 5
                } else {
                    contador++
                }
            } else {
                librosContenidos[contador] = libroPorAñadir
                libroAñadido = true
                posicion = contador
                contador = 5
            }
        }

        return if (libroAñadido) {
            "Libro Añadido en la posicion $posicion"
        } else {
            "Libro no Añadido"
        }
    }

    fun eliminarLibroPorTitulo(informacion: String): String{
        contador = 0
        libroEliminado = false
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.tituloLibro.toString() == informacion) {
                    librosContenidos[contador] = null
                    libroEliminado = true
                    contador = 5
                } else {
                    contador ++
                }
            } else {
                contador ++
            }
        }

        return if (libroEliminado) {
            "El Libro $informacion ha sido eliminado"
        } else {
            "No se ha hecho nada"
        }
    }

    fun eliminarLibroPorAutor(informacion: String): String{
        contador = 0
        cantidadLibrosEliminados = 0
        while(contador < 5){
            if(librosContenidos[contador] != null) {
                if (librosContenidos[contador]?.autorLibro.toString() == informacion) {
                    librosContenidos[contador] = null
                    cantidadLibrosEliminados++
                    contador++
                } else {
                    contador ++
                }
            } else {
                contador ++
            }
        }

        return if (cantidadLibrosEliminados > 0) {
            "$cantidadLibrosEliminados libros del Autor/a $informacion han sido eliminados"
        } else {
            "No se ha hecho nada"
        }
    }

    fun imprimirLibros(){
        contador = 0
        while (contador < 5){
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
    var libro3 = Libro(
        "Harry Potter y la Piedra Filosofal",
        "J.K. Rowling",
        412,
        6
    )
    var libro4 = Libro(
        "Harry Potter y la Prision de Queascodan",
        "J.K. Rowling",
        413,
        4
    )
    var libro5 = Libro(
        "Harry Potter y la mama de Hargrid",
        "J.K. Rowling",
        416,
        7
    )

    var coleccionLibros = ConjuntoLibros()

    println(libro1.informacionLibro())
    println(libro2.informacionLibro())
    println("")
    println(coleccionLibros.insertarLibro(libro1))
    println(coleccionLibros.insertarLibro(libro1))
    println(coleccionLibros.insertarLibro(libro2))
    println(coleccionLibros.insertarLibro(libro3))
    println(coleccionLibros.insertarLibro(libro4))
    println(coleccionLibros.insertarLibro(libro5))
    println("")

    coleccionLibros.imprimirLibros()
    println("")
    println(coleccionLibros.eliminarLibroPorTitulo("El Señor de los Anillos: La comunidad del Anillo"))
    println(coleccionLibros.eliminarLibroPorTitulo("El Señor de los Anillos: La comunidad del Anillo"))
    println("")
    coleccionLibros.imprimirLibros()
    println("")
    println(coleccionLibros.eliminarLibroPorAutor("J.K. Rowling"))
    println(coleccionLibros.eliminarLibroPorAutor("J.K. Rowling"))
    println("")
    coleccionLibros.imprimirLibros()

}

