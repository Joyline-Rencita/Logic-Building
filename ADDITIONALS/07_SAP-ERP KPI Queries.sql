1.  Average Throughput Time :

AVG(CALC_THROUGHPUT(ALL_OCCURRENCE['Process Start'] TO ALL_OCCURRENCE['Process End']
        ,REMAP_TIMESTAMPS("_CEL_O2C_ACTIVITIES"."EVENTTIME", Days)
    )
)

2.  Automation Rate :

AVG(
   CASE WHEN "_CEL_O2C_ACTIVITIES"."USER_TYPE" = 'B' 
        THEN 1.0 
        ELSE 0.0 
END)
