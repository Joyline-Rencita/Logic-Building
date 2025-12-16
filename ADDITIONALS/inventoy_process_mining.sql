TOTAL IOH:

SUM(
  PU_SUM(
    "o_celonis_MaterialMasterPlant", TO_FLOAT("o_custom_StorageLocation"."UnrestrictedStock")
  ) 
)

