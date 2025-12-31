TOTAL IOH:

SUM(
  PU_SUM(
    "o_celonis_MaterialMasterPlant", TO_FLOAT("o_custom_StorageLocation"."UnrestrictedStock")
  ) 
)

Total Demand ( for 3 months) :
  
SUM(
  PU_SUM(
    "o_celonis_MaterialMasterPlant",
    CASE
      WHEN
        "o_celonis_SalesOrderScheduleLine"."ConfirmedDeliveryDate"
        <= ADD_MONTHS(TODAY(), 3)
      THEN
        "o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity"
      ELSE 0
    END
  )
)


Excess Inventory :
CASE
  WHEN
    SUM(
      PU_SUM(
        "o_celonis_MaterialMasterPlant",
        TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
      )
    )
    >
    SUM(
      PU_SUM(
        "o_celonis_MaterialMasterPlant",
        CASE
          WHEN
            "o_celonis_SalesOrderScheduleLine"."ConfirmedDeliveryDate"
            <= ADD_MONTHS(TODAY(), 3)
          THEN
            "o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity"
          ELSE 0
        END
      )
    )
  THEN
    SUM(
      PU_SUM(
        "o_celonis_MaterialMasterPlant",
        TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
      )
    )
    -
    SUM(
      PU_SUM(
        "o_celonis_MaterialMasterPlant",
        CASE
          WHEN
            "o_celonis_SalesOrderScheduleLine"."ConfirmedDeliveryDate"
            <= ADD_MONTHS(TODAY(), 3)
          THEN
            "o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity"
          ELSE 0
        END
      )
    )
  ELSE 0
END

Shortage Inventory :

CASE
  WHEN SUM(
    PU_SUM(
      "o_celonis_MaterialMasterPlant",
      CASE
        WHEN "o_celonis_SalesOrderScheduleLine"."ConfirmedDeliveryDate" <= ADD_MONTHS(TODAY(), 3)
        THEN "o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity"
        ELSE 0
      END
    )
  )
  >
  SUM(
    PU_SUM(
      "o_celonis_MaterialMasterPlant",
      TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
       )
  )
  THEN
    SUM(
      PU_SUM(
        "o_celonis_MaterialMasterPlant",
        CASE
          WHEN "o_celonis_SalesOrderScheduleLine"."ConfirmedDeliveryDate" <= ADD_MONTHS(TODAY(), 3)
          THEN "o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity"
          ELSE 0
        END
      )
    )
    -
    SUM(
      PU_SUM(
        "o_celonis_MaterialMasterPlant",
        TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
      )
    )
  ELSE 0
END 


Allocation Potentials :

SUM(
  CASE WHEN
    PU_SUM(
      "o_celonis_MaterialMasterPlant",
      TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
    )
    >
    PU_SUM(
      "o_celonis_MaterialMasterPlant",
      -- ("o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity")
      "o_celonis_SalesOrderItem"."OrderedQuantity"
    )
  THEN
    PU_SUM(
      "o_celonis_MaterialMasterPlant",
      TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
    )  
    -
    PU_SUM(
      "o_celonis_MaterialMasterPlant",
      -- ("o_celonis_SalesOrderScheduleLine"."ConfirmedQuantity")
      "o_celonis_SalesOrderItem"."OrderedQuantity"
    ) 
  END
)


Stock Ready SO Count:

COUNT(
 CASE WHEN
  PU_FIRST("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   >= "o_celonis_SalesOrderItem"."OrderedQuantity"
 THEN "o_celonis_SalesOrderItem"."ID" END
)


Stock Ready SO Value:

SUM(
  CASE WHEN
  
     PU_FIRST("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
        >= "o_celonis_SalesOrderItem"."OrderedQuantity"
 
     AND "o_celonis_SalesOrderItem"."Plant_ID" = PU_FIRST("o_celonis_MaterialMasterPlant","o_custom_StorageLocation"."Plant")
  THEN "o_celonis_SalesOrderItem"."NetAmount"
  END
)

Stock Transfer SO Count:

COUNT(
 CASE WHEN
  PU_FIRST("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   < "o_celonis_SalesOrderItem"."OrderedQuantity"
 AND
  PU_SUM("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   >= "o_celonis_SalesOrderItem"."OrderedQuantity"
 THEN "o_celonis_SalesOrderItem"."ID" 
END
)

Stock Transfer SO Value:

SUM(
 CASE WHEN
  PU_FIRST("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   < "o_celonis_SalesOrderItem"."OrderedQuantity"
 AND
  PU_SUM("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   >= "o_celonis_SalesOrderItem"."OrderedQuantity"
 THEN "o_celonis_SalesOrderItem"."NetAmount" 
END
)

Procure To Fulfil Count:

COUNT(
 CASE WHEN
  PU_FIRST("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   < "o_celonis_SalesOrderItem"."OrderedQuantity"
 AND
  PU_SUM("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
   < "o_celonis_SalesOrderItem"."OrderedQuantity"
 THEN "o_celonis_SalesOrderItem"."ID" 
END 
)

Procure To Fulfil Value:

SUM(
  CASE WHEN
      -- Condition 1 fails: primary plant stock < ordered qty
      PU_FIRST("o_celonis_MaterialMasterPlant", TO_INT("o_custom_StorageLocation"."UnrestrictedStock"))
        < "o_celonis_SalesOrderItem"."OrderedQuantity"
 
      -- Condition 2 fails: No other plant stock available
      AND PU_SUM(
            "o_celonis_MaterialMasterPlant",
            TO_INT("o_custom_StorageLocation"."UnrestrictedStock")
          ) < "o_celonis_SalesOrderItem"."OrderedQuantity"
 
  THEN "o_celonis_SalesOrderItem"."NetAmount"
  END
)
