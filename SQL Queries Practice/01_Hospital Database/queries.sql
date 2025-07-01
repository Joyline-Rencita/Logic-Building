mysql -u root -p 
*******@xxx

show databases;

use hospital;

show tables;
+--------------------+
| Tables_in_hospital |
+--------------------+
| admissions         |
| doctors            |
| patients           |
| province_names     |
+--------------------+

CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    gender CHAR(1), -- 'M' for male, 'F' for female
    birth_date DATE,
    height DECIMAL(5,2), -- in centimeters
    weight DECIMAL(5,2), -- in kilograms
    allergies VARCHAR(255),
    city VARCHAR(100),
    province_id VARCHAR(5),
    UNIQUE(first_name, last_name)
);

CREATE TABLE admissions (
    admission_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    attending_doctor_id INT,
    admission_date DATE,
    discharge_date DATE,
    diagnosis VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    FOREIGN KEY (attending_doctor_id) REFERENCES doctors(doctor_id)
);

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE province_names (
    province_id VARCHAR(5) PRIMARY KEY,
    province_name VARCHAR(100)
);


-- Insert sample data into patients
INSERT INTO patients (first_name, last_name, gender, birth_date, height, weight, allergies, city, province_id) VALUES
('John', 'Doe', 'M', '1985-03-15', 180.34, 75.50, 'Penicillin', 'Toronto', 'ON'),
('Jane', 'Smith', 'F', '1992-07-23', 160.10, 60.25, 'Morphine', 'Hamilton', 'ON'),
('Chris', 'Brown', 'M', '2010-12-10', 120.00, 50.00, NULL, 'Toronto', 'ON'),
('Emily', 'Clark', 'F', '1975-05-05', 170.00, 68.00, 'NKA', 'Halifax', 'NS'),
('David', 'Maroni', 'M', '1990-08-08', 190.00, 85.00, 'Peanuts', 'Ottawa', 'ON');

-- Insert sample data into admissions
INSERT INTO admissions (patient_id, attending_doctor_id, admission_date, discharge_date, diagnosis) VALUES
(1, 1, '2023-01-15', '2023-01-20', 'Flu'),
(2, 2, '2022-06-01', '2022-06-05', 'Dementia'),
(3, 1, '2021-09-10', '2021-09-12', 'Asthma'),
(4, 3, '2023-07-15', '2023-07-15', 'Dementia'),
(5, 1, '2024-04-10', '2024-04-12', 'Diabetes');

-- Insert sample data into doctors
INSERT INTO doctors (first_name, last_name) VALUES
('Alice', 'Williams'),
('Robert', 'Jones'),
('Sarah', 'Johnson');

-- Insert sample data into province_names
INSERT INTO province_names (province_id, province_name) VALUES
('ON', 'Ontario'),
('NS', 'Nova Scotia'),
('QC', 'Quebec');

All Values : 
select * from patients;
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
| patient_id | first_name | last_name | gender | birth_date | height | weight | allergies  | city     | province_id |
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
|          1 | John       | Doe       | M      | 1985-03-15 | 180.34 |  75.50 | Penicillin | Toronto  | ON          |
|          2 | Jane       | Smith     | F      | 1992-07-23 | 160.10 |  60.25 | Morphine   | Hamilton | ON          |
|          3 | Chris      | Brown     | M      | 2010-12-10 | 120.00 |  50.00 | NULL       | Toronto  | ON          |
|          4 | Emily      | Clark     | F      | 1975-05-05 | 170.00 |  68.00 | NKA        | Halifax  | NS          |
|          5 | David      | Maroni    | M      | 1990-08-08 | 190.00 |  85.00 | Peanuts    | Ottawa   | ON          |
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
select * from patients;
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
| patient_id | first_name | last_name | gender | birth_date | height | weight | allergies  | city     | province_id |
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
|          1 | John       | Doe       | M      | 1985-03-15 | 180.34 |  75.50 | Penicillin | Toronto  | ON          |
|          2 | Jane       | Smith     | F      | 1992-07-23 | 160.10 |  60.25 | Morphine   | Hamilton | ON          |
|          3 | Chris      | Brown     | M      | 2010-12-10 | 120.00 |  50.00 | NULL       | Toronto  | ON          |
|          4 | Emily      | Clark     | F      | 1975-05-05 | 170.00 |  68.00 | NKA        | Halifax  | NS          |
|          5 | David      | Maroni    | M      | 1990-08-08 | 190.00 |  85.00 | Peanuts    | Ottawa   | ON          |
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+

select * from admissions;
+--------------+------------+---------------------+----------------+----------------+-----------+
| admission_id | patient_id | attending_doctor_id | admission_date | discharge_date | diagnosis |
+--------------+------------+---------------------+----------------+----------------+-----------+
|            6 |          1 |                   1 | 2023-01-15     | 2023-01-20     | Flu       |
|            7 |          2 |                   2 | 2022-06-01     | 2022-06-05     | Dementia  |
|            8 |          3 |                   1 | 2021-09-10     | 2021-09-12     | Asthma    |
|            9 |          4 |                   3 | 2023-07-15     | 2023-07-15     | Dementia  |
|           10 |          5 |                   1 | 2024-04-10     | 2024-04-12     | Diabetes  |
+--------------+------------+---------------------+----------------+----------------+-----------+

select * from province_names;
+-------------+---------------+
| province_id | province_name |
+-------------+---------------+
| NS          | Nova Scotia   |
| ON          | Ontario       |
| QC          | Quebec        |
+-------------+---------------+

Queries : 

1. Show first name, last name, and gender of patients whose gender is 'M'.

 mysql> select first_name, last_name,gender from patients where gender = "m";
+------------+-----------+--------+
| first_name | last_name | gender |
+------------+-----------+--------+
| John       | Doe       | M      |
| Chris      | Brown     | M      |
| David      | Maroni    | M      |
+------------+-----------+--------+

2. Show first name and last name of patients who does not have allergies. (null).
     select first_name, last_name from patients where allergies is null;
+------------+-----------+
| first_name | last_name |
+------------+-----------+
| Chris      | Brown     |
+------------+-----------+

3. Show first name of patients that start with the letter 'C'.
    mysql> select first_name from patients where first_name like 'ç%';
+------------+
| first_name |
+------------+
| Chris      |
+------------+

4. Show first name and last name of patients that weight within the range of 100 to 120
(inclusive).
    mysql> select first_name, last_name from patients where weight between 100 and 120;
    Empty set (0.01 sec)

    mysql> select first_name, last_name from patients where weight between 70 and 120;
    +------------+-----------+
    | first_name | last_name |
    +------------+-----------+
    | John       | Doe       |
    | David      | Maroni    |
    +------------+-----------+

5. Update the patients table for the allergies column. If the patient''s allergies is null then
    replace it with 'NKA'.

    mysql> update patients set allergies = "NKA" where allergies is null;
    mysql> select * from patients;
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
| patient_id | first_name | last_name | gender | birth_date | height | weight | allergies  | city     | province_id |
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+
|          1 | John       | Doe       | M      | 1985-03-15 | 180.34 |  75.50 | Penicillin | Toronto  | ON          |
|          2 | Jane       | Smith     | F      | 1992-07-23 | 160.10 |  60.25 | Morphine   | Hamilton | ON          |
|          3 | Chris      | Brown     | M      | 2010-12-10 | 120.00 |  50.00 | NKA        | Toronto  | ON          |
|          4 | Emily      | Clark     | F      | 1975-05-05 | 170.00 |  68.00 | NKA        | Halifax  | NS          |
|          5 | David      | Maroni    | M      | 1990-08-08 | 190.00 |  85.00 | Peanuts    | Ottawa   | ON          |
+------------+------------+-----------+--------+------------+--------+--------+------------+----------+-------------+

6. Show first name and last name concatinated into one column to show their full name.
    mysql> SELECT CONCAT(first_name, " ", last_name) AS `Full Name` FROM patients;
+--------------+
| Full Name    |
+--------------+
| Chris Brown  |
| David Maroni |
| Emily Clark  |
| Jane Smith   |
| John Doe     |
+--------------+

7. Show first name, last name, and the full province name of each patient. 
    mysql> select first_name, last_name, province_name
    from patients join province_names ON 
    patients.province_id = province_names.province_id;
+------------+-----------+---------------+
| first_name | last_name | province_name |
+------------+-----------+---------------+
| John       | Doe       | Ontario       |
| Jane       | Smith     | Ontario       |
| Chris      | Brown     | Ontario       |
| Emily      | Clark     | Nova Scotia   |
| David      | Maroni    | Ontario       |
+------------+-----------+---------------+

8. Show how many patients have a birth_date with 2010 as the birth year.
    mysql> select count(birth_date) from patients where birth_date like "%2010%";
+-------------------+
| count(birth_date) |
+-------------------+
|                 1 |
+-------------------+

9. Show the first_name, last_name, and height of the patient with the greatest height.
  select first_name, last_name, max(height)
  from patients
  group by first_name, last_name
  order by max(height) desc
  limit 1;
  OR if you want to use AS:
  select first_name, last_name, max(height) as height
  from patients
  group by first_name, last_name
  order by height desc
  limit 1;

+------------+-----------+-------------+
| first_name | last_name | max(height) |
+------------+-----------+-------------+
| David      | Maroni    |      190.00 |
+------------+-----------+-------------+

10.  Show all columns for patients who have one of these patient_ids: 1,45,534,879,1000.
    select * from patients where patient_id in (1,45,534,879,1000);

+------------+------------+-----------+--------+------------+--------+--------+------------+---------+-------------+
| patient_id | first_name | last_name | gender | birth_date | height | weight | allergies  | city    | province_id |
+------------+------------+-----------+--------+------------+--------+--------+------------+---------+-------------+
|          1 | John       | Doe       | M      | 1985-03-15 | 180.34 |  75.50 | Penicillin | Toronto | ON          |
+------------+------------+-----------+--------+------------+--------+--------+------------+---------+-------------+

11. Show the total number of admissions.
    select count(admission_date) from admissions;

+-----------------------+
| count(admission_date) |
+-----------------------+
|                     5 |
+-----------------------+

12. Show all the columns from admissions where the patient was admitted and discharged
on the same day.

    select * from admissions where admission_date = discharge_date;

+--------------+------------+---------------------+----------------+----------------+-----------+
| admission_id | patient_id | attending_doctor_id | admission_date | discharge_date | diagnosis |
+--------------+------------+---------------------+----------------+----------------+-----------+
|            9 |          4 |                   3 | 2023-07-15     | 2023-07-15     | Dementia  |
+--------------+------------+---------------------+----------------+----------------+-----------+

13. Show the patient id and the total number of admissions for patient_id 579.
    select patient_id, count(admission_date) from admissions where patient_id = 579;
+------------+-----------------------+
| patient_id | count(admission_date) |
+------------+-----------------------+
|       NULL |                     0 |
+------------+-----------------------+

14. Based on the cities that our patients live in, show unique cities that are in province_id
'NS'?
    select distinct(city) from patients where province_id = "NS";

+---------+
| city    |
+---------+
| Halifax |
+---------+

15. Write a query to find the first_name, last name and birth date of patients who has height
greater than 160 and weight greater than 70.
    select first_name, last_name, birth_date from patients where height > 160 and weight > 70;

+------------+-----------+------------+
| first_name | last_name | birth_date |
+------------+-----------+------------+
| John       | Doe       | 1985-03-15 |
| David      | Maroni    | 1990-08-08 |
+------------+-----------+------------+

16. Write a query to find list of patients first_name, last_name, and allergies where allergies
are not null and are from the city of 'Hamilton'

    select first_name, last_name, allergies
    from patients
    where allergies is not null and city = "Hamilton";

+------------+-----------+-----------+
| first_name | last_name | allergies |
+------------+-----------+-----------+
| Jane       | Smith     | Morphine  |
+------------+-----------+-----------+


17. Show unique birth years from patients and order them by ascending.

    select distinct(year(birth_date)) as birth_year
    from patients
    order by birth_year;  

+------------+
| birth_year |
+------------+
|       1975 |
|       1985 |
|       1990 |
|       1992 |
|       2010 |
+------------+


18. Show unique first names from the patients table which only occurs once in the list. For example, if two or more people are named 'John' in the first_name 
    column then do not include their name in the output list. If only 1 person is named 'Leo' then include them in the output.
    
    select first_name
    from patients
    group by first_name
    having count(first_name ="Leo") = 1;

+------------+
| first_name |
+------------+
| Chris      |
| David      |
| Emily      |
| Jane       |
| John       |
+------------+

19. Show patient_id and first_name from patients where their first_name start and ends with
's' and is at least 6 characters long.
        select patient_id, first_name
        from patients
        where first_name like "s%" and first_name like "%s" and first_name like "%______%";
OR
        select patient_id, first_name
        from patients
        where first_name like "s%s" and first_name like "%______%";
OR
        SELECT patient_id, first_name
        FROM patients
        WHERE first_name LIKE "s____%s";

Empty set

20. Show patient_id, first_name, last_name from patients whos diagnosis is 'Dementia'. Primary diagnosis is stored in the admissions table.
    select p.patient_id, p.first_name, p.last_name
    from patients as p
    join admissions as a
     on p.patient_id = a.patient_id
    where diagnosis = "Dementia";


21. Display every patients first_name. Order the list by the length of each name and then by alphabetically.
    select first_name
    from patients
    order by len(first_name), first_name asc;



22. Show the total amount of male patients and the total amount of female patients in the patients table. Display the two results in the same row.
select count(gender = "M") as Male,
 count(gender = "F") as Female
from patients;

23. Show first and last name, allergies from patients which have allergies to either
'Penicillin' or 'Morphine'. Show results ordered ascending by allergies then by first_name
then by last_name.
select first_name ,last_name, allergies
from patients
where allergies = "Penicillin" or allergies = "Morphine"
order by allergies, first_name, last_name;

24. Show patient_id, diagnosis from admissions. Find patients admitted multiple times for
the same diagnosis.
select patient_id, diagnosis
from admissions
group by patient_id, diagnosis
having count(patient_id = diagnosis) > 1;

25. Show the city and the total number of patients in the city. Order from most to least
patients and then by city name ascending.
select city, count(*) as number_of_patients
from patients
group by city
order by number_of_patients desc, city;

26. Show first name, last name and role of every person that is either patient or doctor. The
roles are either "Patient" or "Doctor"
select first_name, last_name, "Patient" as role
from patients
union all
select first_name, last_name, "Doctor" as role
from doctors;

27. Show all allergies ordered by popularity. Remove NULL values from query.
select allergies, count(*) as popular_allergies
from patients
where allergies is not null
group by allergies
order by popular_allergies desc;

28. Show all patients first_name, last_name, and birth_date who were born in the 1970s
decade. Sort the list starting from the earliest birth_date.
select first_name, last_name, birth_date
from patients
where birth_date like "%197%"
order by birth_date asc;
OR
select first_name, last_name, birth_date
from patients
where Year(birth_date) between 1970 and 1979
order by birth_date asc;

29. We want to display each patients full name in a single column. Their last_name in all
upper letters must appear first, then first_name in all lower case letters. Separate the
last_name and first_name with a comma. Order the list by the first_name in decending
order. EX: SMITH,jane
select concat(upper(last_name), "," ,lower(first_name)) as full_name
from patients
order by first_name desc;

30. Show the province_id(s), sum of height; where the total sum of its patients height is
greater than or equal to 7,000.
Select province_id, sum(height)
From patients
Group By province_id
Having sum(height) >= 7000;

31. Show the difference between the largest weight and smallest weight for patients with
the last name 'Maroni'
select (max(weight) - min(weight)) as weight_diff
from patients
where last_name = "Maroni";

32. Show all of the days of the month (1-31) and how many admission_dates occurred on
that day. Sort by the day with most admissions to least admissions.
select day(admission_date) as day_num, count(patient_id) as num_of_addmission
from admissions
group by day_num
order by num_of_addmission Desc;

33. Show all columns for patient_id 542s most recent admission_date.
select *
from admissions
where patient_id = 542
order by admission_date desc
limit 1;

34. Show patient_id, attending_doctor_id, and diagnosis for admissions that match one of
the two criteria: (A). patient_id is an odd number and attending_doctor_id is either 1, 5,
or (B). attending_doctor_id contains a 2 and the length of patient_id is 3 characters.
select patient_id, attending_doctor_id, diagnosis
from admissions
where patient_id % 2 = 1 and attending_doctor_id in (1,5,19)
or attending_doctor_id like "%2%" and len(patient_id) = 3;

35. Show first_name, last_name, and the total number of admissions attended for each
doctor. Every admission has been attended by a doctor.
select first_name, last_name, count(admission_date) as admissions_attended
from admissions a
join doctors d
 on a.attending_doctor_id = d.doctor_id
group by doctor_id;

36. For each doctor, display their id, full name, and the first and last admission date they
attended.
select doctor_id,
concat("first_name", " ", "last_name") as full_name,
min(admission_date) as first_date_attended,
 max(admission_date) as last_date_attended
from admissions a
join doctors d
 on a.attending_doctor_id = d.doctor_id
group by doctor_id;

37. Display the total amount of patients for each province. Order by descending.
select pr.province_name, count(p.patient_id) as total_patients
from patients as p
join province_names as pr
 on p.province_id = pr.province_id
group by pr.province_name
order by total_patients desc;


38. For every admission, display the patients full name, their admission diagnosis, and their
doctors full name who diagnosed their problem.
select
concat(p.first_name, " ", p.last_name) as patient_full_name,
a.diagnosis,
concat(d.first_name, " ", d.last_name) as doc_full_name
from patients as p
join admissions as a
 on p.patient_id = a.patient_id
 join doctors as d
 on d.doctor_id = a.attending_doctor_id;


39. display the first name, last name and number of duplicate patients based on their first
name and last name.
select first_name, last_name, count(*) as num_of_duplicates
from patients
group by first_name, last_name
having count(*) > 1;


40. Display patients full name, height in the units feet rounded to 1 decimal, weight in the
unit pounds rounded to 0 decimals, birth_date, gender non abbreviated. Convert CM to
feet by dividing by 30.48. Convert KG to pounds by multiplying by 2.205.
select
concat(first_name, " ", last_name) as patient_full_name,
round((height/30.48), 1) as height,
round((weight*2.205), 0) as weight,
birth_date,
case
when gender = "M" then "Male"
 when gender = "F" then "Female"
end as gender
from patients;

41. Show patient_id, first_name, last_name from patients who do not have any records in
the admissions table. (Their patient_id does not exist in any admissions.patient_id
rows.)
select p.patient_id, p.first_name, p.last_name
from patients as p
Left join admissions as a
 on p.patient_id = a.patient_id
where a.patient_id is null;
