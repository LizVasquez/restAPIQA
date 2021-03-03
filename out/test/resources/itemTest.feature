Feature: Item

  Scenario: As admin user
    I want to create an item
    So that i am able to manipulate the item


    Given tengo acceso a Todo.ly
    When envio una peticon POST al url https://todo.ly/api/items.json con json
    """
     {
      "Content":"Item Liz",

    }
    """

    Then espero el codigo de respuesta 200

    And espero que el nuevo item sea "Item Liz"

