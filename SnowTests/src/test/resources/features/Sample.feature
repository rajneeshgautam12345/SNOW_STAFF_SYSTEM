Feature: Sample Feature

  @Sample1
  Scenario Outline: TC-09-DIA Onnet with Managed Router Order submit to snow
    Given User is in SFA url
    When User logs in as a "Valid" user
    And User adds wavelength a side access details "<promotion>" "<aAccessService>" "<aLoc3rdPartyXconnect>"
    And User adds wavelength z side access details "<zAccessService>" "<zLoc3rdPartyXconnect>"

    #When User do the following
    #When User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" "<pdays>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    Examples: 
      | sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | scenario          | contact       |
      | Costco Wholesale Corporation |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | DIA_Onnet_With_MR | Andrew Parada |
