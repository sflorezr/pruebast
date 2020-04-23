# language: es
Característica: Verificacion de servicio Autenticacion

  @Ejecutar
  Esquema del escenario: Servicio autenticar
    Cuando Ejecuto servicio con usuario: "<usuario>" contrasena: "<contrasena>"
    Entonces Valido respuesta del servicio "<estado>"

    Ejemplos:
      | usuario | contrasena | estado | codigo       |
      | dem1    | 0000       | 500    | UNAUTHORIZED |
      |         |            | 400    | UNAUTHORIZED |
      | demo    | demo       | 200    |              |
  @Ejecutar
  Esquema del escenario:Servicio verificar
    Cuando Ejecuto servicio verificar con tipo "<tipo>"
    Entonces Valido respuesta del servicio "<estado>"

    Ejemplos:
      | tipo    | estado |
      | exitoso | 200    |
      | fallido | 401    |