Feature: Item

  Scenario: As admin user
  I want to create an item
  So that i am able to manipulate the item


    Given tengo acceso a Todo.ly
    When envio una peticon POST al url http://todo.ly/api/items.json con json
    """
     {
      "Content":"Item Liz"

    }
    """

    Then espero el codigo de respuesta 200
    And espero que el response body sea
    """
    {
    "Id": "IGNORE",
    "Content": "Item Liz",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": null,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "IGNORE",
    "Deleted": false,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": "IGNORE"
    }
    """
    And  tengo el Id y lo guardo en ID_ITEM
    When envio una peticion PUT al url http://todo.ly/api/items/ID_ITEM.json con json
    """
     {
      "Content":"Item Liz"

    }
    """
    Then espero el codigo de respuesta 200
    And espero que el response body sea
    """
   {
    "Id": ID_ITEM,
    "Content": "Item Liz",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": null,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "IGNORE",
    "Deleted": false,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": "IGNORE"
}
    """
    When envio una peticion GET al url http://todo.ly/api/items/ID_ITEM.json con json
    """
    """
    Then espero el codigo de respuesta 200
    And espero que el response body sea
    """
     {
    "Id": ID_ITEM,
    "Content": "Item Liz",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": null,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "IGNORE",
    "Deleted": false,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": "IGNORE"
}
    """
    When envio una peticion DELETE al url http://todo.ly/api/items/ID_ITEM.json con json
    """
    """
    Then espero el codigo de respuesta 200
    And espero que el response body sea
    """
     {
    "Id": ID_ITEM,
    "Content": "Item Liz",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "IGNORE",
    "Children": [

    ],
    "DueDateTime": null,
    "CreatedDate": "IGNORE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "IGNORE",
    "Deleted": true,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": "IGNORE"
}
    """
