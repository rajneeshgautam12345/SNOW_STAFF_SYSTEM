@Full_Scenario
Feature: Service Now DIA E2E Scenarios

  @DIA_Simple_Onnet
  @TEST_EDPSF-52271
  Scenario Outline: TC-01-DIA Onnet Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |


  @DIA_Simple_Offnet
  @TEST_EDPSF-52272
   Scenario Outline: TC-02-DIA Offnet Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>" 
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records
  
     Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | BNNTCOAP | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
 

  #|WHOLE FOODS MARKET SERVICES, INC.|     2 | 1092 CEDAR ST BENNETT CO 80102 USA       | Floor 1       |                | PL0000714932 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000)|1000 Mbps         |Flat Rate      | Standard Delivery - To the MPoE (Customer Provided) |        No       |1000 | 1000 |  36   |  No         |                                                     |                                          |                |  3        | Dedicated_Internet_Access_On_Net |Alex Yuen   |
  # --#2-WWGLDX
 
  @DIA_Colorless
  @TEST_EDPSF-52274
  Scenario Outline: TC-03-DIA Onnet colourless address order submit to snow.
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress    | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQES04 | Floor DN         | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

  #|Robert Half International -Indirect |     2 | LABMRLCOS02| Floor 1 Room 1| | PL0000005093 | Dedicated Internet Access | 10 GigE - Ethernet Switched Access (500-6,000) | 1000 Mbps         |Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) |        No       |1000 | 1000 |  36   |         No   | Managed Router    |CISCO C4431-ET-01 |Level 3 Provided|  3        | Dedicated_Internet_Access_On_Net | Eric Brown   |
  #1-8WXSVE
  @DIA_Onnet_With_MR_&_MIAD
  @TEST_EDPSF-52275
  Scenario Outline: TC-04-DIA Onnet with MIAD and Managed Router Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

  #| Village Practice Management Company LLC|     2 | 700 W MINERAL AVE LITTLETON CO 80120 USA| Floor 1 Room 1| North Carolina | PL0000005093 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps        |Flat Rate     | Standard Delivery - To the MPoE (Customer Provided)  |        No       |1000 | 1000 |  36   |         Yes    | Managed Router and Managed Integrated Access Device|CISCO C4451X-ET-01 and CISCO C4451X-T1-01 |Level 3 Provided|  3        | Dedicated_Internet_Access_On_Net | Brian Patton   |
  
  @DIA_Onnet_ASRI_Manual
  @TEST_EDPSF-52277
  Scenario Outline: TC-06-DIA Onnet ASRI manual submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | ATLA134O | Floor 1 Room LL10 | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

@Wave
  @DIA_Onnet_Wave
  @TEST_EDPSF-52278
  Scenario Outline: TC-07-DIA Onnet Wave order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom      | fstate  | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | NWYK36G2 | Floor 43 Room MDF | NEWYORK | PL0027228028 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

  @DIA_Onnet_With_BE
  @TEST_EDPSF-52279
  Scenario Outline: TC-08-DIA Onnet with BE Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

  @DIA_Onnet_With_MR
  @TEST_EDPSF-52281
  Scenario Outline: TC-09-DIA Onnet with Managed Router Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |


  @DIA_Offnet_Wave
  @TEST_EDPSF-52282
  Scenario Outline: TC-10-DIA Offnet wave bandwidth Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | LSAHCAXP | Floor 4 Room MMR | COLORADO | PL0027228028 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |


  @DIA_Offnet_GPOM
  @TEST_EDPSF-52283
  Scenario Outline: TC-11-DIA Offnet GPOM Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<accessSolution>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | accessSolution                                                                                                      | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | CLMBGABA | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Level 3 - BELLSOUTH TELECOMM INC - GA -> Level3 - 1000 - 1000 - Best Effort - Pt-Pt - ILEC - USD - $656.25 - $0.00  | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

  #@DIA_SNOW_TC_12
  #Scenario Outline: TC-12-DIA Offnet with ROC Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" "<pdays>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | accessSolution  | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | CLMBGABA | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Firm Vendor Bid | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |


  @DIA_Affiliate
  @TEST_EDPSF-52285
  Scenario Outline: TC-13-DIA Colorless Simply Onnet order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | SLKCUTSC | Floor 1 Room 9999 | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

     
   @DIA_Onnet_With_BE_&_MR
  @TEST_EDPSF-52288
  Scenario Outline: TC-14-DIA Onnet with Building extension and Managed Router Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records

    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | tasknum                          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB| COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |

   @DIA_Headless
  @TEST_EDPSF-52271
  Scenario Outline: TC-15-DIA Onnet headless Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    And User submit the product configured
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    When User submitted the order to DOP "<floorAndRoom>" "<scenario>"
    And User logs in DOP application
    Then User successfully logged in DOP application
    When User search the quotes in DOP
    Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario      | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided|         3 | DIA_Headless | Andrew Parada |

     