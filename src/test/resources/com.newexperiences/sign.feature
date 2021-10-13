Feature: Iniciar sesion en http://automationpractice.com/


  Scenario Outline: Autenticacion fallida
    Given Abre http://automationpractice.com/index.php?controller=authentication
    When Ingresa email <email> y <password>
    And Presiona SIGN IN
    Then Muestra mensaje <result>

    Examples:
      | email               | password | result                                 |
      | jurado@yopmail.com  | Pass123# | There is 1 error Authentication failed |
      | jurados@yopmail.com | Pass123# | There is 1 error Authentication failed |




