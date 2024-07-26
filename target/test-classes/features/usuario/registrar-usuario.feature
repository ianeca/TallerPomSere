Feature: Gestión de Usuarios

Scenario Outline: Registrar Usuario
    Given cargo la página TpidoWeb
    When registro al usuario con los datos <nombre> , <apellido> , <correo> y <clave>
    Then el aplicativo muestra el mensaje <mensajeEsperado>

    Examples: 
      | nombre  | apellido   | correo                     |  clave    |  mensajeEsperado                      	  |         
      | "Pedro" | "Sanchez"  | "pedrosanchez01@gmail.com" | "1234"    | "Se guardó de manera correcta el Cliente" |
      | "Pablo" | "Suarez"   | "pedrosanchez02@gmail.com" | "1234"    | "Se guardó de manera correcta el Cliente" |
      | "Pepe"  | "Nuñez"    | "pedrosanchez03@gmail.com" | "1234"    | "Se guardó de manera correcta el Cliente" |
      | "Juana" | "Gomez"    | "janethjrha@gmail.com"     | "1234"    | "Ya existe un Cliente con el mismo correo"|
      | "Pedro" | "Sanchez"  | "pedrosanchez"             | "1234"    | "Formato de correo no valido"             |
  