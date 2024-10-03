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

    
