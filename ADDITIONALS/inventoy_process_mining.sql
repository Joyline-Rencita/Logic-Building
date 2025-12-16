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

