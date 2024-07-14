@All_Scenario
Feature: Exa Switch Feature

  #@ExaSwitch 
  #@TEST_EDPSF-59286
  #Scenario Outline: TC-15-ExaSwitch Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" "<pdays>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    #And User adds exaSwitch product "<smyproduct>" "<bandwidth>" "<alocationBuilExtension>" "<cloudServiceProvider>" "<cspLocationName>" "<customRoute>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    #And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"

    #When User submitted the order to DOP "<floorAndRoom1>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom1     | fstate   | fplcode      | smyproduct | bandwidth          | accessSubbandwidth | alocationBuilExtension                              | cloudServiceProvider | cspLocationName   | customRoute | term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | scenario  | contact       |
      #| Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0031189037 | ExaSwitch  | 100GIG-E <Default> | 1000 Mbps          | Standard Delivery - To the MPoE (Customer Provided) | Azure                | Harlan Test 12345 | No          |   12 | No             | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | ExaSwitch | Andrew Parada |

  @Wavelength_A_Onnet_and_Z_Onnet
  @TEST_EDPSF-56975
  Scenario Outline: TC-17-Wavelength A_Onnet and Z_Onnet Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    And User adds wavelength product "<smyproduct>" "<bandwidth>" "<buildingExt_A>" "<buildingExt_Z>" "<Custom_Route>" "<Protection>" "<Circuit_Divesity>" "<Latency_guarantee>" "<Encryption>" "<Contract_Type>" "<Term>"
    And User submit the product configured
    And User switch the pre-depoloy status "OFF"
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"

    #When User submitted the order to DOP "<floorAndRoom1>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | smyproduct | faddress1 | floorAndRoom1  | faddress2 | floorAndRoom2  | bandwidth   | buildingExt_A                                       | buildingExt_Z                                       | Custom_Route | Protection  | Circuit_Divesity | Latency_guarantee | Encryption | Contract_Type | Term | futureday | scenario                       | contact       |
      | Costco Wholesale Corporation |     2 | Wavelength | DNVTCO56  | Floor 1 Room 1 | NYCMNYZR  | Floor 0 Room 0 | 10GIG-E LAN | Standard Delivery - To the MPoE (Customer Provided) | Standard Delivery - To the MPoE (Customer Provided) | No           | Unprotected | No               | None              | No         | Lease         |   24 |         3 | Wavelength_A_Onnet_and_Z_Onnet | Andrew Parada |

  @Wavelength_A_Onnet_and_Z_Offnet 
  @TEST_EDPSF-56976
  Scenario Outline: TC-18-Wavelength Pre-deploy off with A side Onnet & Z side Offnet Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    And User adds wavelength product "<smyproduct>" "<bandwidth>" "<buildingExt_A>" "<buildingExt_Z>" "<Custom_Route>" "<Protection>" "<Circuit_Divesity>" "<Latency_guarantee>" "<Encryption>" "<Contract_Type>" "<Term>"
    And User submit the product configured
    #And User switch the pre-depoloy status "OFF"
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"

    #When User submitted the order to DOP "<floorAndRoom1>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | smyproduct | faddress1 | floorAndRoom1  | faddress2 | floorAndRoom2     | bandwidth   | buildingExt_A                                       | buildingExt_Z                                       | Custom_Route | Protection  | Circuit_Divesity | Latency_guarantee | Encryption | Contract_Type | Term | futureday | scenario                        | contact       |
      | Costco Wholesale Corporation |     2 | Wavelength | DNVTCO56  | Floor 1 Room 1 | ASBNVASG  | Floor 1 Room TELC | 10GIG-E LAN | Standard Delivery - To the MPoE (Customer Provided) | Standard Delivery - To the MPoE (Customer Provided) | No           | Unprotected | No               | None              | No         | Lease         |   24 |         3 | Wavelength_A_Onnet_and_Z_Offnet | Andrew Parada |

  @Wavelength_A_Onnet_and_Z_Onnet_3rdParty 
  @TEST_EDPSF-59297
  Scenario Outline: TC-19-Wavelength A_Onnet and Z_Onnet with 3rd Party cross connect Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    And User adds wavelength product "<smyproduct>" "<bandwidth>" "<buildingExt_A>" "<buildingExt_Z>" "<Custom_Route>" "<Protection>" "<Circuit_Divesity>" "<Latency_guarantee>" "<Encryption>" "<Contract_Type>" "<Term>"
    And User adds wavelength a side access details "<promotion>" "<aAccessService>" "<aLoc3rdPartyXconnect>"
    And User adds wavelength z side access details "<zAccessService>" "<zLoc3rdPartyXconnect>"
    And User submit the product configured
    And User switch the pre-depoloy status "OFF"
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"

    #When User submitted the order to DOP "<floorAndRoom1>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | smyproduct | faddress1 | floorAndRoom1  | faddress2 | floorAndRoom2  | bandwidth   | buildingExt_A                                       | buildingExt_Z                                       | Custom_Route | Protection  | Circuit_Divesity | Latency_guarantee | Encryption | Contract_Type | Term | promotion      | aAccessService        | aLoc3rdPartyXconnect | zAccessService        | zLoc3rdPartyXconnect | futureday | scenario                                | contact       |
      | Costco Wholesale Corporation |     2 | Wavelength | DNVTCO56  | Floor 1 Room 1 | NYCMNYZR  | Floor 0 Room 0 | 10GIG-E LAN | Standard Delivery - To the MPoE (Customer Provided) | Standard Delivery - To the MPoE (Customer Provided) | No           | Unprotected | No               | None              | No         | Lease         |   24 | Standard Price | Lumen Provided Access | No                   | Lumen Provided Access | Yes                  |         3 | Wavelength_A_Onnet_and_Z_Onnet_3rdParty | Andrew Parada |

  @Wavelength_Protected 
  @TEST_EDPSF-56978
  Scenario Outline: TC-20-Wavelength Pre-deploy off with Protected Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    And User adds wavelength product "<smyprohduct>" "<bandwidth>" "<buildingExt_A>" "<buildingExt_Z>" "<Custom_Route>" "<Protection>" "<Circuit_Divesity>" "<Latency_guarantee>" "<Encryption>" "<Contract_Type>" "<Term>"
    And User submit the product configured
    And User switch the pre-depoloy status "OFF"
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"
    When User submitted the order to DOP "<floorAndRoom1>"

    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | smyproduct | faddress1 | floorAndRoom1  | faddress2 | floorAndRoom2  | bandwidth   | buildingExt_A                                       | buildingExt_Z                                       | Custom_Route | Protection | Circuit_Divesity | Latency_guarantee | Encryption | Contract_Type | Term | futureday | scenario             | contact       |
      | Costco Wholesale Corporation |     2 | Wavelength | DNVTCO56  | Floor 1 Room 1 | NYCMNYZR  | Floor 0 Room 0 | 10GIG-E LAN | Standard Delivery - To the MPoE (Customer Provided) | Standard Delivery - To the MPoE (Customer Provided) | No           | Protected  | No               | None              | No         | Lease         |   24 |         3 | Wavelength_Protected | Andrew Parada |

  @Wavelength_Encrypted 
  @TEST_EDPSF-56977
  Scenario Outline: TC-21-Wavelength Pre-deploy off with Encrypted Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    And User adds wavelength product "<smyproduct>" "<bandwidth>" "<buildingExt_A>" "<buildingExt_Z>" "<Custom_Route>" "<Protection>" "<Circuit_Divesity>" "<Latency_guarantee>" "<Encryption>" "<Contract_Type>" "<Term>"
    And User submit the product configured
    And User switch the pre-depoloy status "OFF"
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"

    #When User submitted the order to DOP "<floorAndRoom1>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | smyproduct | faddress1 | floorAndRoom1  | faddress2 | floorAndRoom2  | bandwidth   | buildingExt_A                                       | buildingExt_Z                                       | Custom_Route | Protection  | Circuit_Divesity | Latency_guarantee | Encryption | Contract_Type | Term | futureday | scenario             | contact       |
      | Costco Wholesale Corporation |     2 | Wavelength | DNVTCO56  | Floor 1 Room 1 | NYCMNYZR  | Floor 0 Room 0 | 10GIG-E LAN | Standard Delivery - To the MPoE (Customer Provided) | Standard Delivery - To the MPoE (Customer Provided) | No           | Unprotected | No               | None              | Yes        | Lease         |   24 |         3 | Wavelength_Encrypted | Andrew Parada |

  @Wavelength_Predoply_On 
  @TEST_EDPSF-56977
  Scenario Outline: TC-22-Wavelength Pre-deploy ON Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User creates an Opportunity "<sAccount>" "<pdays>"
    And User creates a Secenario
    And User adds first valid locations with floor "<faddress1>" "<floorAndRoom1>" "<fstate>" "<fplcode>"
    And User adds second valid locations with floor "<faddress2>" "<floorAndRoom2>" "<fstate>" "<fplcode>"
    And User adds wavelength product "<smyproduct>" "<bandwidth>" "<buildingExt_A>" "<buildingExt_Z>" "<Custom_Route>" "<Protection>" "<Circuit_Divesity>" "<Latency_guarantee>" "<Encryption>" "<Contract_Type>" "<Term>"
    And User submit the product configured
    And User switch the pre-depoloy status "ON"
    And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom1>"
    And User submit the TDF and SDF form "<floorAndRoom1>" "<scenario>"
    When User submitted the order to DOP "<floorAndRoom1>"

    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | smyproduct | faddress1 | floorAndRoom1  | faddress2 | floorAndRoom2  | bandwidth   | buildingExt_A                                       | buildingExt_Z                                       | Custom_Route | Protection  | Circuit_Divesity | Latency_guarantee | Encryption | Contract_Type | Term | futureday | scenario               | contact       |
      | Costco Wholesale Corporation |     2 | Wavelength | DNVTCO56  | Floor 1 Room 1 | NYCMNYZR  | Floor 0 Room 0 | 10GIG-E LAN | Standard Delivery - To the MPoE (Customer Provided) | Standard Delivery - To the MPoE (Customer Provided) | No           | Unprotected | No               | None              | No         | Lease         |   24 |         3 | Wavelength_Predoply_On | Andrew Parada |
