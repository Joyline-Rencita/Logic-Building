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

10.  Show all columns for patients who have one of these patient_ids: 1,45,534,879,1000.
    select * from patients where patient_id in (1,45,534,879,1000);

11. Show the total number of admissions.
    select count(admission_date) from admissions;

12. Show all the columns from admissions where the patient was admitted and discharged
on the same day.

    select * from admissions where admission_date = discharge_date;

13. Show the patient id and the total number of admissions for patient_id 579.
    select patient_id, count(admission_date) from admissions where patient_id = 579;

14. Based on the cities that our patients live in, show unique cities that are in province_id
'NS'?
    select distinct(city) from patients where province_id = "NS";

15. Write a query to find the first_name, last name and birth date of patients who has height
greater than 160 and weight greater than 70.
    select first_name, last_name, birth_date from patients where height > 160 and weight > 70;

16. Write a query to find list of patients first_name, last_name, and allergies where allergies
are not null and are from the city of 'Hamilton'

select first_name, last_name, allergies
from patients
where allergies is not null and city = "Hamilton";


17. Show unique birth years from patients and order them by ascending.

    select distinct(year(birth_date)) as birth_year
    from patients
    order by birth_year;    

18. Show unique first names from the patients table which only occurs once in the list. For example, if two or more people are named 'John' in the first_name 
    column then do not include their name in the output list. If only 1 person is named 'Leo' then include them in the output.
    
    select first_name
    from patients
    group by first_name
    having count(first_name ="Leo") = 1;
