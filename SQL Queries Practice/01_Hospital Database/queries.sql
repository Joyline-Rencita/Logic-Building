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


| patient_id | first_name | last_name | gender | birth_date  | weight | height | city      | province_id | allergies  |
|------------|------------|-----------|--------|-------------|--------|--------|-----------|-------------|------------|
| 1          | John       | Doe       | M      | 1980-05-10  | 75     | 180    | Toronto   | ON          | Penicillin |
| 2          | Jane       | Smith     | F      | 1990-03-15  | 65     | 165    | Hamilton  | ON          | None       |
| 3          | Chris      | Johnson   | M      | 2000-12-21  | 80     | 170    | Halifax   | NS          | Morphine   |
| 4          | Leo        | Brown     | M      | 1975-11-25  | 90     | 190    | Vancouver | BC          | NKA        |
| 5          | Emily      | White     | F      | 2010-07-18  | 50     | 155    | Calgary   | AB          | None       |
| 6          | Michael    | Maroni    | M      | 1995-01-05  | 85     | 175    | Edmonton  | AB          | Penicillin |
| 7          | Sarah      | Davis     | F      | 1985-09-09  | 60     | 160    | Hamilton  | ON          | Morphine   |
| 8          | Paul       | Garcia    | M      | 1978-02-20  | 100    | 185    | Toronto   | ON          | NKA        |
| 9          | Sophie     | Adams     | F      | 1989-04-25  | 55     | 150    | Halifax   | NS          | None       |
| 10         | Mark       | Thomas    | M      | 2005-08-12  | 95     | 180    | Toronto   | ON          | Peanuts    |

| admission_id | patient_id | admission_date | discharge_date | diagnosis     | attending_doctor_id |
|--------------|------------|----------------|----------------|---------------|---------------------|
| 1            | 1          | 2023-09-01     | 2023-09-05     | Flu           | 1                   |
| 2            | 2          | 2023-08-12     | 2023-08-12     | Allergy       | 2                   |
| 3            | 3          | 2023-07-22     | 2023-07-28     | Fracture      | 3                   |
| 4            | 1          | 2022-12-15     | 2022-12-18     | Diabetes      | 2                   |
| 5            | 4          | 2023-06-01     | 2023-06-10     | Hypertension  | 3                   |
| 6            | 5          | 2023-05-25     | 2023-05-30     | Asthma        | 1                   |
| 7            | 6          | 2023-03-15     | 2023-03-20     | Dementia      | 2                   |
| 8            | 7          | 2023-01-10     | 2023-01-10     | Flu           | 1                   |
| 9            | 8          | 2022-11-22     | 2022-11-25     | COVID-19      | 3                   |
| 10           | 9          | 2022-10-05     | 2022-10-08     | Pneumonia     | 2                   |


| doctor_id | first_name | last_name |
|-----------|------------|-----------|
| 1         | Dr. Alan   | Grant     |
| 2         | Dr. Ellie  | Sattler   |
| 3         | Dr. Ian    | Malcolm   |

| province_id | province_name      |
|-------------|--------------------|
| ON          | Ontario            |
| NS          | Nova Scotia        |
| BC          | British Columbia   |
| AB          | Alberta            |


Queries: 

