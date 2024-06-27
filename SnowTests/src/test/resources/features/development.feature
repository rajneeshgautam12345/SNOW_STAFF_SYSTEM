Feature: develop feature      
 
  Scenario Outline: DIA Offnet Order submit to snow
    Given User is in SFA url
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
    #When User clicks on the "<DIAWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User fillup the tdg records for "<Offnet>" order
    #And User navigates to gather_order_details tab
    #And fillup the access type and access subtype details under tdg form
    #And enters the details for IP subnets and save it
    #And enters the details for transport access and save it
    #
    #And user navigates back to customer order page  
    #When User navigates to the order line "<Component1>" Item 
    #Then User successfully navigated to order line "<Component1>" Item
    #When User enters characteristic values for order line "<Component1>" Item
    #When User navigates to order tasks section of "<Component1>"
    #
    #Then User validates "<diaTasksName3>" task is open state
    #
    #And User completes the "<diaTasksName3>" task
    #Then User validates "<diaTasksName3>" task is completed state    
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
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for credit check status
    #When User navigates to order tasks section of "<Component1>"
    #And user navigates back to customer order page
    #And User approve the credit check status
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for IIQ task
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
    #And User validates the workflow "<AccessWorkflow>" completed successfully
   #
    #When User navigates to order tasks section of "<Component2>"
    #And User reload the order line item
    #Then User validates "<OffnetTasksName>" task is open state
    #And User successfully navigates to the workflow in flow designer   
    #When User open the flow "< Offnet>" in flow designer
    #Then User validates "< Offnet>" flow waiting for "<Offnet Manual Design Template>" task
    #When User logs in flightdeck application
    #Then User validates the "<Offnet Manual Design Template>" task kicked off for order
    #When User enters the mandatory field and completes the task
    #Then User validates the "<FOC Recieved>" task kicked off for order
    #And User successfully navigates to the workflow in flow designer
    #Then User successfully validates the "<OffnetWorkflow>" is waiting for "<FOC Recieved>"
    #When User logs in EASE application
    #And User completes the asr tasks
    #Then User validates the workflow "<Offnet>" completed successfully
    #When User navigates to the customer order page
    #And User navigates to the service order enrichment tab
    #Then User validates the port service alias updated successfully
        #
    #And User navigates to the order line "<Component3>" Item
    #Then User successfully navigated to order line "<Component3>" Item
    #When User navigates to product order section of Internet Service
    #Then User validates the "<InternetWorkflow>" kicked off for "<Component3>" under flow context
      #
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |Component1                |DIAWorkflow                  |Component2     |AccessWorkflow            |Component3       |InternetWorkflow            |diaTasksName1    |diaTasksName2        |diaTasksName3             | diaTasksName4             |diaTasksName5 |              
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Adam Millican |	Dedicated Internet Access|LMN-ORCH-DIA-Order Validation|Access Service |LMN-ORCH-SOM-Discover Path|Internet Service |	LMN-ORCH-DIA-IP Assignment |Order Validation |Customer Coordination|	Gather Order Details TDE|LMN-SOM-Initiate TDG-MS    |TDG SLA Timer |
   #
  #@Onnet
   #Scenario Outline: DIA Offnet Order submit to snow
    #Given User is in SFA url
    #When User search the order in customer orders submodule
    #Then successfully displayed the searched order records
    #When User clicks on Customer order
    #Then User successfully landed to order deatils
    #When User clicks on approve button
    #Then order successfully gets approved
    #When User clicks on show related items link  
    #When User clicks on related order entities
    #Then User successfully validates the SM id, Opportunity Id
    #
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to product order section of DIA
    #Then User validates the "<DIAWorkflow>" kicked off for "<Component1>" under flow context      
    #When User clicks on the "<DIAWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User fillup the tdg records for "<Offnet>" order
    #And User navigates to gather_order_details tab
    #And fillup the access type and access subtype details under tdg form
    #And enters the details for IP subnets and save it
    #And enters the details for transport access and save it
    #
    #And user navigates back to customer order page  
    #When User navigates to the order line "<Component1>" Item 
    #Then User successfully navigated to order line "<Component1>" Item
    #When User enters characteristic values for order line "<Component1>" Item
    #When User navigates to order tasks section of "<Component1>"
    #
    #Then User validates "<diaTasksName3>" task is open state  
    #And User completes the "<diaTasksName3>" task
    #Then User validates "<diaTasksName3>" task is completed state    
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for CCM Task
    #When User navigates to order tasks section of "<Component1>"
    #And User reload the order line item
    #Then User validates "<diaTasksName2>" task is open state
    #And User completes the "<diaTasksName2>" task
    #Then User validates "<diaTasksName2>" task is completed state
    #And User validates the order validation wait workflow status   
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName1>" task is open state
    #When User completes the "<diaTasksName1>" task
    #Then User validates "<diaTasksName1>" task is completed state   
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for credit check status
    #When User navigates to order tasks section of "<Component1>"
    #And user navigates back to customer order page
    #And User approve the credit check status
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for IIQ task
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" completed successfully
    #
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User navigates to the order line "<Component2>" Item
    #Then User successfully navigated to order line "<Component2>" Item
    #When User navigates to product order section of Access Service
    #When User navigates to order tasks section of "<Component2>"
    #Then User validates the "<path comp>" order task kicked off
    #And User validates the Path Comp workflow kicked off
    #When User open the "<path comp workflow>" in flow designer
    #And User navigates to the path comp mesh action
    #Then User validates the device and port details of mesh response
    #Then User validates the "<AccessWorkflow>" kicked off for "<Component2>" under flow context 
    #When User clicks on the "<AccessWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #And User validates the workflow "<AccessWorkflow>" completed successfully
    #When User navigates to order tasks section of "<Component2>"
    #And User reload the order line item
    #Then User validates the "<layer 1>" task kicked off time
    #When User navigates to the flow designer
    #When User open the "<layer1 workflow>" in flow designer
    #Then User validates the Create UNI action completed successfully
    #When User navigates to order tasks section of "<Component2>"
    #When User navigates to the customer order page
    #And User navigates to the service order enrichment tab
    #Then User validates the port service alias updated successfully
   #
   #
    #When User navigates to order tasks section of "<Component2>"
    #And User reload the order line item
    #Then User validates "<OffnetTasksName>" task is open state
    #And User successfully navigates to the workflow in flow designer   
    #When User open the flow "< Offnet>" in flow designer
    #Then User validates "< Offnet>" flow waiting for "<Offnet Manual Design Template>" task
    #When User logs in flightdeck application
    #Then User validates the "<Offnet Manual Design Template>" task kicked off for order
    #When User enters the mandatory field and completes the task
    #Then User validates the "<FOC Recieved>" task kicked off for order
    #And User successfully navigates to the workflow in flow designer
    #Then User successfully validates the "<OffnetWorkflow>" is waiting for "<FOC Recieved>"
    #When User logs in EASE application
    #And User completes the asr tasks
    #Then User validates the workflow "<Offnet>" completed successfully
    #When User navigates to the customer order page
    #And User navigates to the service order enrichment tab
    #Then User validates the port service alias updated successfully
        #
    #And User navigates to the order line "<Component3>" Item
    #Then User successfully navigated to order line "<Component3>" Item
    #When User navigates to product order section of Internet Service
    #Then User validates the "<InternetWorkflow>" kicked off for "<Component3>" under flow context
      #
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |Component1                |DIAWorkflow                  |Component2     |AccessWorkflow            |Component3       |InternetWorkflow            |diaTasksName1    |diaTasksName2        |diaTasksName3             | diaTasksName4             |diaTasksName5 |              
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Adam Millican |	Dedicated Internet Access|LMN-ORCH-DIA-Order Validation|Access Service |LMN-ORCH-SOM-Discover Path|Internet Service |	LMN-ORCH-DIA-IP Assignment |Order Validation |Customer Coordination|	Gather Order Details TDE|LMN-SOM-Initiate TDG-MS    |TDG SLA Timer |
   #
  #
  #
