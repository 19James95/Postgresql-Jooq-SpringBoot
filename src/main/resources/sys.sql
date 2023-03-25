-- 学生表格
CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  gender VARCHAR(10) NOT NULL,
  birthdate DATE NOT NULL,
  grade INT NOT NULL,
  major VARCHAR(100) NOT NULL,
  clazz VARCHAR(100),
  headteacher VARCHAR(100),
  direction VARCHAR(100),
  supervisor VARCHAR(100)
);
INSERT INTO students(name, gender, birthdate, grade, major, clazz, headteacher)
VALUES('张三', '男', '1999-01-01', 3, '计算机科学与技术', '20231104', '王老师');

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

