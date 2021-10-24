// Clase Cuenta, su funcion es almacenar dinero de una persona
class Cuenta(var numeroCuenta: Int, var saldoDisponible: Double) {

    // Comprueba el saldo de la cuenta
    fun consultarSaldo(): String = "El saldo actual de la cuenta $numeroCuenta es $saldoDisponible"

    // Recibe una cantidad de dinero X
    fun recibirAbono(cantidad: Double): String {
        saldoDisponible += cantidad
        return "Cantidad abonada: $cantidad"
    }

    // Se sustrae una cantidad de dinero X
    fun realizarPago(cantidad: Double): String {
        saldoDisponible -= cantidad
        return "Cantidad pagada: $cantidad"
    }

}

//Clase Persona, su function es identificarse y ser propietario/a de cuentas
class Persona(val dni: String) {

    var cuentas = Array(3) { Cuenta(0, 0.0) }
    var cuentaAlmacenada: Boolean = false
    var contador: Int = 0
    var finBucle: Boolean = false
    var esMorosa: Boolean = false

    // Añade una cuenta a su propiedad, previamente creada. Maximo de 3
    fun anadirCuenta(cuenta: Cuenta): String {
        cuentaAlmacenada = false
        contador = 0
        finBucle = false
        while (finBucle.equals(false)) {
            if (cuentas[contador].numeroCuenta.toString() == "0") {
                cuentas[contador] = cuenta
                cuentaAlmacenada = true
                finBucle = true
            }
            contador++
            if (contador > 2)
                finBucle = true
        }
        return if (cuentaAlmacenada == true) {
            "La persona $dni ahora es propietaria de la cuenta ${cuenta.numeroCuenta}"
        } else {
            "No se han podido añadir mas cuentas"
        }
    }

    // Comprueba si alguna de las cuentas de la persona estan por debajo de 0
    fun personaMorosa(): String {
        contador = 0
        esMorosa = false
        finBucle = false
        while (finBucle.equals(false)) {
            if (cuentas[contador].saldoDisponible < 0.0) {
                esMorosa = true
                contador++
            }
            contador++
            if (contador > 2)
                finBucle = true
        }
        return if (esMorosa == true) {
            "La persona $dni es morosa"
        } else {
            "La persona $dni no es morosa"
        }
    }

    // Transfiere una cantidad X de la cuenta A a la cuenta B
    fun transferirDineroCuentas(cuentaOriginaria: Cuenta, cuentaDestinatario: Cuenta, cantidad: Double): String {
        cuentaOriginaria.realizarPago(cantidad)
        cuentaDestinatario.recibirAbono(cantidad)
        return "La cuenta ${cuentaDestinatario.numeroCuenta} ha recibido $cantidad Euros de la cuenta ${cuentaOriginaria.numeroCuenta}"
    }

    // Comprueba las cuentas de la persona
    fun cuentasPersona(): String = "${cuentas[0]}, ${cuentas[1]}, ${cuentas[2]}"

}

fun main() {

    var cuenta1 = Cuenta(123456789, 700.0)
    var cuenta2 = Cuenta(683456223, 0.0)
    println(cuenta1.recibirAbono(0.69))


    var humano1 = Persona("69420694-D")
    println(humano1.anadirCuenta(cuenta1))
    println(humano1.anadirCuenta(cuenta2))

    println(cuenta1.recibirAbono(1100.00))
    println(cuenta2.realizarPago(750.0))
    println(humano1.personaMorosa())

    println(humano1.transferirDineroCuentas(cuenta1, cuenta2, 750.00))
    println(humano1.personaMorosa())

}