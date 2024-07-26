Feature: Gestión Pedido

  Scenario Outline: Registrar Pedido
    Given cargo la página TpidoWeb
    And inicio sesión con el usuario <usuario> y la clave <clave>
    When cargo la página Registrar Pedido
    And añado el nombre del producto <producto1> y la cantidad <cantidad1>
    And añado el nombre del producto <producto2> y la cantidad <cantidad2>
    And guardo pedido
    Then el aplicativo muestra el mensaje <mensajeEsperado>

    Examples: 
      | usuario                   | clave   | producto1   | producto2     | cantidad1   |  cantidad2   | mensajeEsperado                           |
      | "janethjrha@gmail.com"    | "1234"  | "INCA COLA" | "COCA COLA"   | "4"         |  "5"         | "Se guardó de manera correcta el Pedido"  |
      | "pedrosanchez01@gmail.com"| "1234"  | "SUBLIME"   | "PRINCESA"    | "30"        |  "10"        | "Se guardó de manera correcta el Pedido"  |
      | "pedrosanchez02@gmail.com"| "1234"  | "PRINCESA"  | "COCA COLA"   | "30"        |  "10"        | "Se guardó de manera correcta el Pedido"  |
