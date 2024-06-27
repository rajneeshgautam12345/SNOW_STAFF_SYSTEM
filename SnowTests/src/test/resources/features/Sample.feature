Feature: Sample Feature



  @TEST_EDPSF-52271
  Scenario Outline: TC-15-DIA Onnet headless Order submit to snow
    Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" "<pdays>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>" "<scenario>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario      | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Headless | Andrew Parada |

     
#@Sample 
 #Scenario Outline: DIA Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User do the following 
    #And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    #And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    #And User adds wavelength product "<smyproduct>" "<bandwidth>" "<alocationBuilExtension>" "<cloudServiceProvider>" "<cspLocationName>" "<customRoute>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #
     #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct    | bandwidth         | accessSubbandwidth | alocationBuilExtension                              | cloudServiceProvider| cspLocationName  |customRoute| term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB| COLORADO | PL0031189037 | ExaSwitch     | 100GIG-E <Default>| 1000 Mbps          | Standard Delivery - To the MPoE (Customer Provided) | Azure               | Harlan Test 12345|   No      |12    | No            | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

     
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
     #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |Component1                |DIAWorkflow                  |Component2     |AccessWorkflow            |Component3       |InternetWorkflow            |diaTasksName1    |diaTasksName2        |diaTasksName3             | diaTasksName4             |diaTasksName5 |              
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Adam Millican |	Dedicated Internet Access|LMN-ORCH-DIA-Order Validation|Access Service |LMN-ORCH-SOM-Discover Path|Internet Service |	LMN-ORCH-DIA-IP Assignment |Order Validation |Customer Coordination|	Gather Order Details TDE|LMN-SOM-Initiate TDG-MS    |TDG SLA Timer |
      

 #@DIA_SNOW_E2E 
  #Scenario Outline: DIA Offnet Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" "<pdays>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>"
    #When User submitted the order to DOP
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #When User logs in Snow application
    #Then User successfully logged in snow application   
    #When User navigate to customer orders submodule
    #Then User succesfully landed to customer orders submodule
    #When User search the order in customer orders submodule
    #Then successfully displayed the searched order records
    #When User clicks on Customer order
    #Then User successfully landed to order deatils
    #When User clicks on approve button
    #Then order successfully gets approved
    #When User clicks on show related items link  
    #When User clicks on related order entities
    #Then User successfully validates the SM id, Opportunity Id
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to product order section of DIA
    #Then User validates the "<DIAWorkflow>" kicked off for "<Component1>" under flow context   
    #
    #When User clicks on the "<DIAWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User navigates to gather_order_details tab
    #And fillup the access type and access subtype details under tdg form
    #And enters the details for IP subnets and save it
    #And enters the details for transport access and save it
    #And user navigates back to customer order page  
    #When User navigates to the order line "<Component1>" Item 
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName3>" task is open state
    #And User completes the "<diaTasksName3>" task
    #Then User validates "<diaTasksName3>" task is completed state
    #Then User validates "<diaTasksName4>" task is open state
    #And User completes the "<diaTasksName4>" task
    #Then User validates "<diaTasksName4>" task is completed state
     #Then User validates "<diaTasksName5>" task is open state
    #And User completes the "<diaTasksName5>" task
    #Then User validates "<diaTasksName5>" task is completed state
    #And User validates the order validation wait workflow status
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName1>" task is open state
    #When User completes the "<diaTasksName1>" task
    #Then User validates "<diaTasksName1>" task is completed state
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for CCM Task
    #When User navigates to order tasks section of "<Component1>"
    #And User reload the order line item
    #Then User validates "<diaTasksName2>" task is open state
    #And User completes the "<diaTasksName2>" task
    #Then User validates "<diaTasksName2>" task is completed state
    #Then User validates "<diaTasksName2SLA>" task is open state
    #And User completes the "<diaTasksName2SLA>" task
    #Then User validates "<diaTasksName2SLA>" task is completed state
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName3>" task is open state
    #And User completes the "<diaTasksName3>" task
    #Then User validates "<diaTasksName3>" task is completed state
    #
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" completed successfully
    #
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User navigates to the order line "<Component2>" Item
    #Then User successfully navigated to order line "<Component2>" Item
    #When User navigates to product order section of Access Service
    #Then User validates the "<AccessWorkflow>" kicked off for "<Component2>" under flow context 
    #When User clicks on the "<AccessWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #And User validates the Path Comp workflow kicked off
    #When User open the "< path comp workflow>" in flow designer
    #
    #And User navigates to the path comp mesh action
    #Then User validates the device and port details of mesh response
        #
    #When User navigates to the customer order page
    #When User navigates to order tasks section of "<Component2>"
    #Then User validates the layer 1 task kicked off time
    #When User navigates to the flow designer
    #When User open the "< layer1 workflow>" in flow designer
    #
    #Then User validates the Create UNI action completed successfully
    #When User navigates to order tasks section of "<Component2>"
    #When User navigates to the customer order page
    #And User navigates to the service order enrichment tab
    #Then User validates the port service alias updated successfully
    #
     #
    #And User navigates to the order line "<Component3>" Item
    #Then User successfully navigated to order line "<Component3>" Item
    #When User navigates to product order section of Internet Service
    #Then User validates the "<InternetWorkflow>" kicked off for "<Component3>" under flow context
    #
    #
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |Component1                |DIAWorkflow                  |Component2     |AccessWorkflow            |Component3       |InternetWorkflow            |diaTasksName1    |diaTasksName2        |diaTasksName3             | diaTasksName4             |diaTasksName5 |              
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Adam Millican |	Dedicated Internet Access|LMN-ORCH-DIA-Order Validation|Access Service |LMN-ORCH-SOM-Discover Path|Internet Service |	LMN-ORCH-DIA-IP Assignment |Order Validation |Customer Coordination|	Gather Order Details TDE|LMN-SOM-Initiate TDG-MS    |TDG SLA Timer |
   #
  #
    