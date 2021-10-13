Feature: Iniciar sesion en http://automationpractice.com/


  Scenario Outline: Autenticacion fallida
    Given que el usuario ingrese a automationpractice.com
    When ingrese en el campo email <email> y en el campo contraseña ingrese <password>
    And presione SIGN IN
    Then el sistema muestra mensaje <result>

    Examples:
      | email               | password | result                                 |
      | jurado@yopmail.com  | Pass123# | There is 1 error Authentication failed |
      | jurados@yopmail.com | Pass123# | There is 1 error Authentication failed |




