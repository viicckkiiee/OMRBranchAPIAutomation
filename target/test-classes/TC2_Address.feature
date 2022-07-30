@Address
Feature: Address Module API Automation

  @AddAddress
  Scenario Outline: Verify add new address to the application through API
    Given User should add headers
    And User should add required data for adding the address  "<first_name>" , "<last_name>", "<mobile>", "<apartment>", <state>, <city>, <country>, "<zipcode>", "<address>" and "<address_type>"
    When User should send "POST" request to AddAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addAddress response body message matches "Address added successfully" and get the address id saved

    Examples: 
      | first_name | last_name | mobile     | apartment  | state | city | country | zipcode | address             | address_type |
      | Vignesh    | V         | 1234567898 | DreamHouse |    33 | 3378 |     101 |  606107 | 64/63 West mambalam | Home         |

  @UpdateAddress
  Scenario Outline: Verify update address in the application through API
    Given User should add headers
    And User should add required data for updating the address  "<first_name>" , "<last_name>", "<mobile>", "<apartment>", <state>, <city>, <country>, "<zipcode>", "<address>" and "<address_type>"
    When User should send "PUT" request to UpdateAddress endpoint
    Then User should verify the status code is 200
    And User should verify the updateAddress response body message matches "Address updated successfully"

    Examples: 
      | first_name | last_name   | mobile     | apartment  | state | city | country | zipcode | address             | address_type |
      | MohanDass  | Chidambaram | 1234567898 | DreamHouse |    33 | 3378 |     101 |  606107 | 64/63 West mambalam | Home         |

  @GetAddress
  Scenario: Verify get address from the appilcation through API
    Given User should add headers
    When User should send "GET" request to getAddress endpoint
    Then User should verify the status code is 200
    And User should verify the getaddress response body message matches "OK"

  @DeleteAddress
  Scenario: Verify delete address from the application through API
    Given User should add headers
    And User should add addressId in request body for deleting the address
    When User should send "DELETE" request to deleteaddress endpoint
    Then User should verify the status code is 200
    And User should verify the deleteAddress response body message matches "Address deleted successfully"
