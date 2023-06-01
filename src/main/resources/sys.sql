-- 学生表格
CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  gender VARCHAR(10) NOT NULL,
  birthdate VARCHAR(100) NOT NULL,
  grade INT NOT NULL,
  major VARCHAR(100) NOT NULL,
  clazz VARCHAR(100),
  headteacher VARCHAR(100),
  direction VARCHAR(100),
  supervisor VARCHAR(100),
  identity VARCHAR(100),
  phone VARCHAR(100),
  profession_id INT,
  school_id INT
);

-- 课程表格
CREATE TABLE courses (
 id SERIAL PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 teacher VARCHAR(100) NOT NULL,
 info TEXT NOT NULL,
 credit INT NOT NULL,
 capacity INT NOT NULL,
 selected_num INT NOT NULL
);

-- 选课表格
CREATE TABLE selections (
 id SERIAL PRIMARY KEY,
 student_id INT NOT NULL,
 course_id INT NOT NULL,
 grade INT NOT NULL
);

CREATE TABLE log (
 id SERIAL PRIMARY KEY,
 url varchar(1024),
 request TEXT,
 response TEXT
);

CREATE TABLE profession (
 id SERIAL PRIMARY KEY,
 name varchar(1024),
 create_time timestamp,
 deleted INT
);

CREATE TABLE school (
 id SERIAL PRIMARY KEY,
 name varchar(1024),
 create_time timestamp,
 deleted INT
);
