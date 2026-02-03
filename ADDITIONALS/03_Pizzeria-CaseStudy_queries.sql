-- 1. Time between 'Pizza arrives at customer' and 'Payment customer'
SELECT
    AVG(
        CALC_THROUGHPUT(
            FIRST_OCCURRENCE["Pizza arrives at customer"] TO FIRST_OCCURRENCE["Payment customer"],
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        )
    ) AS "Avg Wait Time for Payment (min)"

-- 2. Average delivery duration by customer location
SELECT
    "Pizza_Case_Table_Pizza_Case"."Customer Location" AS "Customer Location",
    AVG(
        CALC_THROUGHPUT(
            FIRST_OCCURRENCE["Departure pizza"] TO FIRST_OCCURRENCE["Pizza arrives at customer"],
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        )
    ) AS "Avg Delivery Duration (min)"
GROUP BY "Pizza_Case_Table_Pizza_Case"."Customer Location"

-- 3. Count of orders with 'Phone Bill' as cost factor
SELECT
    COUNT(*) AS "Phone Orders"
FROM "Pizza_Case_Table_Pizza_Case"
WHERE "Pizza_Case_Table_Pizza_Case"."Cost Factor" = 'Phone Bill'

-- 4. Total Revenue and Cost by Cost Factor (Filtered to Chefs)
SELECT
    "Pizza_Case_Table_Pizza_Case"."Cost Factor" AS "Cost Factor",
    SUM("Pizza_Case_Table_Pizza_Case"."Revenue") AS "Total Revenue",
    SUM("Pizza_Case_Table_Pizza_Case"."Costs") AS "Total Costs"
FROM "Pizza_Case_Table_Pizza_Case"
WHERE "Pizza_Case_Table_Pizza_Case"."Cost Factor" LIKE 'Chef%'
GROUP BY "Pizza_Case_Table_Pizza_Case"."Cost Factor"

-- 5. Average order time on website (Order placed to Restaurant received)
SELECT
    AVG(
        CALC_THROUGHPUT(
            FIRST_OCCURRENCE["Order by website"] TO FIRST_OCCURRENCE["Restaurant receives order"],
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        )
    ) AS "Avg Order Processing Time (Website)"

-- 6. Profit and cost analysis for Chefs
SELECT
    "Pizza_Case_Table_Pizza_Case"."Cost Factor" AS "Chef",
    SUM("Pizza_Case_Table_Pizza_Case"."Revenue" - "Pizza_Case_Table_Pizza_Case"."Costs") AS "Total Profit",
    SUM("Pizza_Case_Table_Pizza_Case"."Costs") AS "Total Cost"
FROM "Pizza_Case_Table_Pizza_Case"
WHERE "Pizza_Case_Table_Pizza_Case"."Cost Factor" LIKE 'Chef%'
GROUP BY "Pizza_Case_Table_Pizza_Case"."Cost Factor"

-- 7. Profit and cost analysis for Delivery Guys
SELECT
    "Pizza_Case_Table_Pizza_Case"."Cost Factor" AS "Delivery Guy",
    SUM("Pizza_Case_Table_Pizza_Case"."Revenue" - "Pizza_Case_Table_Pizza_Case"."Costs") AS "Total Profit",
    SUM("Pizza_Case_Table_Pizza_Case"."Costs") AS "Total Cost"
FROM "Pizza_Case_Table_Pizza_Case"
WHERE "Pizza_Case_Table_Pizza_Case"."Cost Factor" LIKE 'Delivery Guy%'
GROUP BY "Pizza_Case_Table_Pizza_Case"."Cost Factor"


-- 8 unknown 
SUM(
    (
        CALC_THROUGHPUT(
            FIRST_OCCURRENCE['Call Customer'] TO FIRST_OCCURRENCE['Start preparing pizza'],
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        ) / 
        CALC_THROUGHPUT(
            CASE_START TO CASE_END,
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        )
    )
    * "Pizza_Case_Table_Pizza_Case"."Costs"
)

-- 9 

PU_SUM(
    DOMAIN_TABLE("Pizza_Case_Table_Pizza_Case"."Cost Factor"),
    "Pizza_Case_Table_Pizza_Case"."Costs",
    "Pizza_Case_Table_Pizza_Case"."Cost Factor" = 'Phone Bill'
)

10 Cost of Delay Between Calling Customer and Starting Preparation

SUM(
    (
        CALC_THROUGHPUT(
            FIRST_OCCURRENCE['Call Customer'] TO FIRST_OCCURRENCE['Start preparing pizza'],
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        )
        /
        CALC_THROUGHPUT(
            CASE_START TO CASE_END,
            REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
        )
    )
    * "Pizza_Case_Table_Pizza_Case"."Costs"
)


11. Time brtween arrival & payment

AVG(
    CALC_THROUGHPUT(
        FIRST_OCCURRENCE['Pizza arrives at customer'] TO FIRST_OCCURRENCE['Payment customer'],
        REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
    )
)

12.  Time between arrival & payment

AVG(
    CALC_THROUGHPUT(
        FIRST_OCCURRENCE['Pizza arrives at customer'] TO FIRST_OCCURRENCE['Payment customer'],
        REMAP_TIMESTAMPS("Pizza_Activity_Table_Pizzeria_Event"."EVENTTIME", MINUTES)
    )
)

13. Average Delivery Time 

(AVG(CALC_THROUGHPUT(FIRST_OCCURRENCE['Order by phone'] TO LAST_OCCURRENCE['Pizza arrives at customer'], REMAP_TIMESTAMPS("Pizza Events"."EVENTTIME", days)))*24*60)-15

14. First activity date
    
YEAR(<% time_round %>(<%=ref_date%>)) 
<% if(time_round == 'ROUND_YEAR') { %> || ' '  <% } %>
<% if(time_round == 'ROUND_MONTH') { %>
|| ' - ' || CASE WHEN LEN(MONTH(<%=ref_date%>) || ' ') = 3 THEN
' ' || MONTH(<%=ref_date%>) ELSE ' 0' || MONTH(<%=ref_date%>) END <% } %>
<% if(time_round == 'ROUND_WEEK') { %>
|| ' - ' || CASE WHEN LEN(CALENDAR_WEEK(<%=ref_date%>) || ' ') = 3 THEN
' CW ' || CALENDAR_WEEK(<%=ref_date%>) ELSE ' CW 0' || CALENDAR_WEEK(<%=ref_date%>) END <% } %>
<% if(time_round == 'ROUND_DAY') { %>
|| ' - ' || CASE WHEN LEN(MONTH(<%=ref_date%>) || ' ') = 3 THEN
' ' || MONTH(<%=ref_date%>) ELSE ' 0' || MONTH(<%=ref_date%>) END 
|| ' - ' || CASE WHEN LEN(DAY(<%=ref_date%>) || ' ') = 3 THEN
' ' || DAY(<%=ref_date%>) ELSE ' 0' || DAY(<%=ref_date%>) END
<% } %>

