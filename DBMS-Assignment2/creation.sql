/*
Create all tables of Library
*/
CREATE DATABASE IF NOT EXISTS library_information_system;

USE library_information_system;

CREATE TABLE IF NOT EXISTS members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    address_line1 VARCHAR(45) NOT NULL,
    address_line2 VARCHAR(45),
    category CHAR(1) CHECK(category IN ("S", "F", "O"))
);

CREATE TABLE IF NOT EXISTS subjects (
    subject_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS publishers (
    publisher_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS titles (
    title_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    subject_id INT,
    publisher_id INT,
    CONSTRAINT titles_fk_subject_id
    FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT titles_fk_publisher_id
    FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS books (
    accession_no INT PRIMARY KEY AUTO_INCREMENT,
    title_id INT NOT NULL,
    purchase_date DATE NOT NULL,
    price FLOAT UNSIGNED NOT NULL,
    status VARCHAR(30) CHECK(status IN ("issued", "available", "lost") ),
    CONSTRAINT books_fk_title_id
    FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS authors (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS title_author (
    title_id INT,
    author_id INT,
    CONSTRAINT title_author_fk_title_id
    FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT title_author_fk_author_id
    FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (title_id, author_id)
);

CREATE TABLE IF NOT EXISTS book_issue (
    issue_date TIMESTAMP NOT NULL,
    due_date TIMESTAMP NOT NULL,
    accession_no INT,
    member_id INT,
    CONSTRAINT book_issue_fk_accession_no
    FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT book_issue_fk_member_id
    FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (issue_date, accession_no, member_id)
);

CREATE TABLE IF NOT EXISTS book_return (
    return_date TIMESTAMP NOT NULL,
    issue_date TIMESTAMP NOT NULL,
    accession_no INT,
    member_id INT,
    CONSTRAINT book_return_fk_accession_no
    FOREIGN KEY(accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT book_return_fk_member_id
    FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (return_date, accession_no, member_id)
);